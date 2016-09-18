package com.xm.counter;


/**
 * Created by peter on 2016/9/17.
 */
public class PersistenceThread extends Thread {
    private Counter counter;
    public PersistenceThread(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        try {
            while(true) {
                sleep(5000);
                Util.SerializeCounter(counter);
                System.out.println("PersistenceThread save counter to " + Util.getFileName());
            }
        }
        catch (InterruptedException e) {
            System.out.println("I was interrupted!");
            e.printStackTrace();
        }

    }
}
