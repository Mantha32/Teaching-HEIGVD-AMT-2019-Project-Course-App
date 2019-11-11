package com.amt.schedule.impl;

import com.amt.schedule.inter.ClassroomEJB;
import com.amt.schedule.entities.Classroom;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "ClassroomImpl")
public class ClassroomDAO implements ClassroomEJB {

    private Connection db = DB.connection();

    public ClassroomDAO() throws Exception {
    }

    @Override
    public String create(String floor, String name) {
        String req = "INSERT INTO classroom (FLOOR, NAME) VALUES (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, floor);
            preparedStatement.setString(2, name);
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }

    @Override
    public Classroom chercher(int idclassroom) {
        String req = "SELECT * FROM classroom WHERE IDCLASSROOM = ?";
        Classroom classroom = new Classroom();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, idclassroom);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                classroom.setNumero(resultSet.getInt("idclassroom"));
                classroom.setName(resultSet.getString("name"));
                classroom.setFloor(resultSet.getString("floor"));
            }
        } catch (SQLException e) {

        }
        return classroom;
    }

    @Override
    public List<Classroom> list() {
        String req = "SELECT * FROM classroom";
        PreparedStatement preparedStatement = null;
        List<Classroom> classes = new ArrayList<>();
        try {
            preparedStatement = db.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                classes.add(new Classroom(resultSet.getInt("idclassroom"), resultSet.getString("floor"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {

        }
        return classes;
    }

    @Override
    public String delete(Classroom classroom) {
        String req = "DELETE FROM classroom WHERE idclassroom = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, classroom.getNumero());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }

    @Override
    public String edit(Classroom classroom, String floor, String name) {
        String req = "UPDATE classroom SET NAME = ?, FLOOR = ? WHERE IDCLASSROOM = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, floor);
            preparedStatement.setInt(3, classroom.getNumero());
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }
}
