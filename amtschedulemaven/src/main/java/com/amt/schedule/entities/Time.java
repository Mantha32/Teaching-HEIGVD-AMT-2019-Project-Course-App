package com.amt.schedule.entities;

public class Time {
    private Lecture lecture;
    private SlotEvent slotEvent;

    public Time(Lecture lecture, SlotEvent slotEvent){
        this.lecture = lecture;
        this.slotEvent = slotEvent;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public SlotEvent getSlotEvent() {
        return slotEvent;
    }

    public void setSlotEvent(SlotEvent slotEvent) {
        this.slotEvent = slotEvent;
    }
}
