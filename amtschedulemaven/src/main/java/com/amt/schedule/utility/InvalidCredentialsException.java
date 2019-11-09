package com.amt.schedule.utility;

import java.util.ArrayList;

public class InvalidCredentialsException extends Exception {
    private String type;
    private String msg;

    public InvalidCredentialsException(String msg, String type) {
        super(msg);
        this.msg = msg;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
