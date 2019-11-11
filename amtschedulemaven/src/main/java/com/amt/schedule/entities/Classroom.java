package com.amt.schedule.entities;

import java.io.Serializable;

public class Classroom implements Serializable {
    private int numero;
    private String floor;
    private String name;
    private boolean occp;

    public Classroom(){

    }

    public Classroom(int numero, String floor, String name) {
        this.numero = numero;
        this.floor = floor;
        this.name = name;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOccp() {
        return occp;
    }

    public void setOccp(boolean occp) {
        this.occp = occp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
