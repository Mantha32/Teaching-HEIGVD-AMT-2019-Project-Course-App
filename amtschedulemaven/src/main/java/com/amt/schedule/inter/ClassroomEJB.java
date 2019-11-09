package com.amt.schedule.inter;

import com.amt.schedule.entities.Classroom;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ClassroomEJB {
    public String create(String floor, String bloc);
    public Classroom chercher(int numero);
    public List<Classroom> list();
    public String delete(Classroom classroom);
    public String edit(Classroom classroom, String floor, String bloc);
}
