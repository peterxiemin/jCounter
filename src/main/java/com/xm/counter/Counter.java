package com.xm.counter;

import java.io.Serializable;

/**
 * Created by peter on 2016/9/17.
 */
public class Counter implements Serializable {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public int getCount() {
        return counter;
    }

    public synchronized void setCount(int counter) {
        this.counter = counter;
    }

    public synchronized  void addCount() {
        this.counter++;
    }

    public String toString() {
        return "counter : " + counter;
    }
}
