package com.amt.schedule.entities;

public class SlotEvent {
    private int sloteventid;
    private String jour;
    private String heure;

    public SlotEvent(){

    }

    public SlotEvent(String jour, String heure){
        this.jour = jour;
        this.heure = heure;
    }

    public int getSloteventid() {
        return sloteventid;
    }

    public void setSloteventid(int sloteventid) {
        this.sloteventid = sloteventid;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
