package com.amt.schedule.inter;

import com.amt.schedule.entities.Classroom;
import com.amt.schedule.entities.Course;
import com.amt.schedule.entities.Lecture;
import com.amt.schedule.entities.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LectureEJB {
    public String creer(User user, Course course, Classroom classroom, String date);
    public List<Lecture> list(User user);
    public List<Lecture> list(Classroom classroom);
    public List<Lecture> list();
    public Lecture chercher(int lectureid);
    public String delete(Lecture lecture);
}
