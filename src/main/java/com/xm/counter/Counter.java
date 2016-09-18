package com.xm.counter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by peter on 2016/9/17.
 */
public class Counter implements Serializable {
    private int counter;
    private HashMap<Integer, Object> busiMap;

    public Counter() {
        counter = 0;
        busiMap = new HashMap<Integer, Object>();
    }

    public Object getBusiById(int id) {
        return busiMap.get(id);
    }

    public void setBusi(int id, Object busi) {
        busiMap.put(id, busi);
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
