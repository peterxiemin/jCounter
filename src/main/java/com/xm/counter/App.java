package com.xm.counter;

import org.eclipse.jetty.server.Server;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {
        Counter counter = Util.DeserializeCounter();
        if (counter == null) {
            counter = new Counter();
        }

        //jetty server start.....
        Server server = new Server(8080);
        server.setHandler(new CounterHandler(counter));
        // 启动一个线程，对数据进行store
        new PersistenceThread(counter).start();
        server.start();
        server.join();
    }


}
