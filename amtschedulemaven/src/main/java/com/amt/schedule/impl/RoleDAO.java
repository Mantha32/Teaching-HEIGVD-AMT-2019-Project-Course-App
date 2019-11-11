package com.amt.schedule.impl;

import com.amt.schedule.inter.RoleEJB;
import com.amt.schedule.entities.Role;
import com.amt.schedule.utility.DB;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "RoleImpl")
public class RoleDAO implements RoleEJB {

    private Connection db = DB.connection();

    public RoleDAO() throws Exception {
    }

    @Override
    public Role chercher(String role) {
        String req = "SELECT * FROM role WHERE status = ?";
        Role rol = new Role();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                rol.setStatus(role);
            }
        } catch (SQLException e) {

        }
        return rol;
    }

    @Override
    public List<Role> list() {
        String req = "SELECT * FROM role";
        PreparedStatement preparedStatement = null;
        List<Role> roles = new ArrayList<>();
        try {
            preparedStatement = db.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                roles.add(new Role(resultSet.getString("status")));
            }
        } catch (SQLException e) {

        }
        return roles;
    }

    @Override
    public String creer(String role) {
        String req = "INSERT INTO role VALUES (?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, role);
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }

    @Override
    public String delete(Role role) {
        String req = "DELETE FROM role WHERE status = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, role.getStatus());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {

        }
        return "fail";
    }
}
