package com.amt.schedule.entities;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private int userid;
    private String username;
    private String firstname;
    private String lastname;
    private java.util.List<Lecture> lectures;
    private java.util.List<Course> courses;
    private Role status;

    public User(){

    }

    public User(String username, String firstname, Role status){
        this.username = username;
        this.firstname = firstname;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getStatus() {
        return status;
    }

    public void setStatus(Role status) {
        this.status = status;
    }

    public String getNom() {
        return firstname;
    }

    public void setNom(String firstname) {
        this.firstname = firstname;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Role getRole() {
        return status;
    }

    public void setRole(Role status) {
        this.status = status;
    }
}
