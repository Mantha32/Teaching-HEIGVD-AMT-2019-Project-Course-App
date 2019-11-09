package com.amt.schedule.impl;

import com.amt.schedule.inter.CourseEJB;
import com.amt.schedule.entities.Course;
import com.amt.schedule.entities.User;
import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.utility.DB;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "CourseImpl")
public class CourseDAO implements CourseEJB {

    private Connection db = DB.connection();

    @EJB
    private UserEJB userEJB;

    public CourseDAO() throws Exception {
    }

    @Override
    public String creer(String COURSEID, String description, User user) {
        String req = "INSERT INTO course VALUES (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, COURSEID);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, user.getUserid());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @Override
    public Course chercher(int id) {
        String req = "SELECT * FROM course WHERE COURSEID = ?";
        Course course = new Course();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                course.setCourseid(resultSet.getInt("courseid"));
                course.setTitre(resultSet.getString("title"));
                course.setDescription(resultSet.getString("description"));
                course.setUser(userEJB.chercher(resultSet.getString("userid")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course;
    }

    @Override
    public List<Course> list() {
        String req = "SELECT * FROM course";
        PreparedStatement preparedStatement = null;
        List<Course> courses = new ArrayList<>();
        try {
            preparedStatement = db.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                courses.add(new Course(resultSet.getString("COURSEID"), resultSet.getString("description"),
                        userEJB.chercher(resultSet.getInt("userid"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public List<Course> list(User user) {
        String req = "SELECT * FROM course WHERE userid = ?";
        PreparedStatement preparedStatement = null;
        List<Course> courses = new ArrayList<>();
        Course course;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, user.getUserid());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                course = new Course(resultSet.getString("title"), resultSet.getString("description"),
                        user);
                course.setCourseid(resultSet.getInt("courseid"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public String delete(Course course) {
        String req = "DELETE FROM course WHERE courseid = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, course.getCourseid());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @Override
    public String edit(Course course, String title, String desc) {
        String req = "UPDATE course SET TITLE = ?, DESCRIPTION = ? WHERE COURSEID = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, desc);
            preparedStatement.setInt(3, course.getCourseid());
            return "succes";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }
}
