package com.xm.counter.bussiness;

import java.util.List;

/**
 * Created by peter on 2016/9/18.
 */
public class RequestParam {
    private int id;
    private String op;
    private List<String> prop;


    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public List<String> getProp() {
        return prop;
    }

    public void setProp(List<String> prop) {
        this.prop = prop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

