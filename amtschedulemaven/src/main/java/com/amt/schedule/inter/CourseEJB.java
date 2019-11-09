package com.amt.schedule.inter;

import com.amt.schedule.entities.Course;
import com.amt.schedule.entities.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CourseEJB {
    public String creer(String titre, String description, User user);
    public Course chercher(int id);
    public List<Course> list();
    public List<Course> list(User user);
    public String delete(Course course);
    public String edit(Course course, String title, String desc);
}
