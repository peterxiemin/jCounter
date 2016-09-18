package com.xm.counter.bussiness;

import java.io.Serializable;

/**
 * Created by peter on 2016/9/18.
 */

public class Comment implements Serializable {
    private int agree;
    private int disagree;

    public Comment() {
        agree = 0;
        disagree = 0;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public int getDisagree() {
        return disagree;
    }

    public void setDisagree(int disagree) {
        this.disagree = disagree;
    }

    public void addAgree() {
        this.agree ++;
    }

    public void addDisagree() {
        this.disagree ++;
    }

    public void delAgree() {
        this.agree --;
    }

    public void delDisagree() {
        this.disagree --;
    }

    public String toString() {
        return "agree : " + agree + " disagree : " + disagree;
    }
}