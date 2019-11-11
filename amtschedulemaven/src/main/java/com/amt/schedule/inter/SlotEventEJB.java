package com.amt.schedule.inter;

import com.amt.schedule.entities.SlotEvent;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SlotEventEJB {
    public List<SlotEvent> list();
    public SlotEvent chercher(int id);
}
