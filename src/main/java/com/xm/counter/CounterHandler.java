package com.xm.counter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


/**
 * Created by peter on 2016/9/17.
 */
public class CounterHandler extends AbstractHandler {
    private Counter counter;
    public CounterHandler(Counter count) {
        this.counter = count;
    }
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        counter.addCount();
        response.getWriter().println("count : " + counter.getCount());
    }
}
