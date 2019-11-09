package com.amt.schedule.entities;

import java.io.Serializable;

public class Role implements Serializable {
    private String status;

    public Role(){

    }

    public Role(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
