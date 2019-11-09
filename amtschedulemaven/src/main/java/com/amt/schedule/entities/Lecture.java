package com.amt.schedule.entities;

import java.io.Serializable;

public class Lecture implements Serializable {

    private int id;
    private User user;
    private Course course;
    private Classroom classroom;

    public Lecture(){

    }

    public Lecture(User user, Course course, Classroom classroom) {
        this.user = user;
        this.course = course;
        this.classroom = classroom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
