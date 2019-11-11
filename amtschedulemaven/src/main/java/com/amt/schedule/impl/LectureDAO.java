package com.amt.schedule.impl;

import com.amt.schedule.inter.ClassroomEJB;
import com.amt.schedule.inter.CourseEJB;
import com.amt.schedule.inter.LectureEJB;
import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.entities.Classroom;
import com.amt.schedule.entities.Course;
import com.amt.schedule.entities.Lecture;
import com.amt.schedule.entities.User;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "LectureImpl")
public class LectureDAO implements LectureEJB {

    private Connection db = DB.connection();

    @EJB
    private UserEJB userEJB;

    @EJB
    private ClassroomEJB classroomEJB;

    @EJB
    private CourseEJB courseEJB;

    public LectureDAO() throws Exception {
    }

    @Override
    public String creer(User user, Course course, Classroom classroom, String date) {
        String req = "INSERT INTO lecture VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, course.getTitre());
            preparedStatement.setString(4, date);
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }

    @Override
    public List<Lecture> list(User user) {
        String req = "SELECT LECTUREID, lecture.COURSEID, lecture.USERID, lecture.IDCLASSROOM, FLOOR FROM user, classroom, course, lecture WHERE" +
                " (lecture.USERID = ? AND user.USERID = lecture.USERID) AND classroom.IDCLASSROOM = lecture.IDCLASSROOM AND course.COURSEID = lecture.COURSEID";
        PreparedStatement preparedStatement = null;
        List<Lecture> lectures = new ArrayList<>();
        Lecture lecture;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, user.getUserid());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                lecture = new Lecture(userEJB.chercher(resultSet.getInt("userid")),
                        courseEJB.chercher(resultSet.getInt("courseid")),
                        classroomEJB.chercher(resultSet.getInt("idclassroom")));
                lecture.setId(resultSet.getInt("lectureid"));
                lectures.add(lecture);
            }
        } catch (SQLException e) {

        }
        return lectures;
    }

    @Override
    public List<Lecture> list(Classroom classroom) {
        String req = "SELECT LECTUREID, lecture.COURSEID, lecture.USERID, lecture.IDCLASSROOM, FLOOR FROM user, classroom, course, lecture WHERE" +
                " user.USERID = lecture.USERID AND (lecture.IDCLASSROOM = ? AND classroom.IDCLASSROOM = lecture.IDCLASSROOM) AND " +
                "course.COURSEID = lecture.COURSEID";
        PreparedStatement preparedStatement = null;
        List<Lecture> lectures = new ArrayList<>();
        Lecture lecture;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, classroom.getNumero());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                lecture = new Lecture(userEJB.chercher(resultSet.getInt("userid")),
                        courseEJB.chercher(resultSet.getInt("courseid")),
                        classroomEJB.chercher(resultSet.getInt("idclassroom")));
                lecture.setId(resultSet.getInt("lectureid"));
                lectures.add(lecture);
            }
        } catch (SQLException e) {

        }
        return lectures;
    }

    @Override
    public List<Lecture> list() {
        String req = "SELECT LECTUREID, lecture.COURSEID, lecture.USERID, lecture.IDCLASSROOM, FLOOR FROM user, classroom, course, lecture WHERE" +
                " user.USERID = lecture.USERID AND classroom.IDCLASSROOM = lecture.IDCLASSROOM AND " +
                "course.COURSEID = lecture.COURSEID";
        PreparedStatement preparedStatement = null;
        List<Lecture> lectures = new ArrayList<>();
        Lecture lecture;
        try {
            preparedStatement = db.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                lecture = new Lecture(userEJB.chercher(resultSet.getInt("userid")),
                        courseEJB.chercher(resultSet.getInt("courseid")),
                        classroomEJB.chercher(resultSet.getInt("idclassroom")));
                lecture.setId(resultSet.getInt("lectureid"));
                lectures.add(lecture);
            }
        } catch (SQLException e) {

        }
        return lectures;
    }

    @Override
    public Lecture chercher(int lectureid) {
        String req = "SELECT * FROM lecture WHERE lectureid = ?";
        Lecture lecture = new Lecture();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, lectureid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                lecture.setId(resultSet.getInt("lectureid"));
                lecture.setClassroom(classroomEJB.chercher(resultSet.getInt("idclassroom")));
                lecture.setCourse(courseEJB.chercher(resultSet.getInt("courseid")));
                lecture.setUser(userEJB.chercher(resultSet.getInt("userid")));
            }
        } catch (SQLException e) {

        }
        return lecture;
    }

    @Override
    public String delete(Lecture lecture) {
        String req = "DELETE FROM lecture WHERE lectureid = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, lecture.getId());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }
}
