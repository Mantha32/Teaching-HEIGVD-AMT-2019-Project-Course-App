package com.amt.schedule.entities;

import java.io.Serializable;

public class Course implements Serializable {
    private int courseid;
    private String titre;
    private String description;
    private String modified;
    private User user;

    public Course(){

    }
    public Course(String titre, String description, User user) {
        this.titre = titre;
        this.description = description;
        this.user = user;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
