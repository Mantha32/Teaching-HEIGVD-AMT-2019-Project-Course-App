package com.amt.schedule.inter;

import com.amt.schedule.entities.Lecture;
import com.amt.schedule.entities.Time;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TimeEJB {
    public List<Time> list(Lecture lecture);
}
