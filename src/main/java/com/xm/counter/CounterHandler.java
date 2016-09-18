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
        String ret = null;
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        String param = request.getParameter("param");
        RequestParam rp = mapper.readValue(param, RequestParam.class);
        switch (rp.getId()) {
            case 1000001:
                Comment c = (Comment)counter.getBusiById(rp.getId());
                if (c == null) c = new Comment();
                List<String> list = rp.getProp();
                for (int i=0; i < list.size(); i++) {
                    String prop = list.get(i);
                    String firstLetter = prop.substring(0, 1).toUpperCase();
                    String addFunc = "add" + firstLetter + prop.substring(1);
                    try {
                        Method method = c.getClass().getMethod(addFunc, new Class[] {});
                        method.invoke(c, new Object[] {});
                        counter.setBusi(rp.getId(), c);
                        ret = mapper.writeValueAsString(c);
                        System.out.println("agree : " + c.getAgree() + " disagree : " + c.getDisagree());
                    } catch (Exception e) {
                        System.out.println("error: " + e.getMessage());
                        ret = "error: " + e.getMessage();
                    }
                }
                break;
            default:
                ret = "no id match";
                break;
        }
        if (ret == null) {
            ret = "err[empty]";
        }
        response.getWriter().println(ret);
    }
}
