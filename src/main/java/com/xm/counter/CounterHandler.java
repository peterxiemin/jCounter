package com.xm.counter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xm.counter.bussiness.Comment;
import com.xm.counter.bussiness.RequestParam;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


/**
 * Created by peter on 2016/9/17.
 */
public class CounterHandler extends AbstractHandler {
    private Counter counter;
    ObjectMapper mapper = new ObjectMapper();

    public CounterHandler(Counter counter) {
        this.counter = counter;
    }

    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String ret = "";
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        String param = request.getParameter("param");
        if (param == null) {
            response.getWriter().println("param is empty");
            return;
        }
        RequestParam rp = mapper.readValue(param, RequestParam.class);
        if (rp == null) {
            response.getWriter().println("rp is empty");
            return;
        }
        switch (rp.getId()) {
            case 1000001:
                Comment c = (Comment) counter.getBusiById(rp.getId());
                if (c == null) c = new Comment();
                ret = propExec(c, rp);
                break;
            default:
                ret = "no id match";
                break;
        }
        response.getWriter().println(ret);
    }

    private <T> String propExec(T busi, RequestParam rp) {
        try {
            List<String> propList = rp.getProp();
            for (int i = 0; i < propList.size(); i++) {
                String prop = propList.get(i);
                String firstLetter = prop.substring(0, 1).toUpperCase();
                String func = rp.getOp() + firstLetter + prop.substring(1);
                Method method = busi.getClass().getMethod(func, new Class[]{});
                method.invoke(busi, new Object[]{});
            }
            counter.setBusi(rp.getId(), busi);
            System.out.println(busi);
            return mapper.writeValueAsString(busi);
        } catch (Exception e) {
            return "propExec error reason[" + e.getMessage() + "]";
        }
    }
}
