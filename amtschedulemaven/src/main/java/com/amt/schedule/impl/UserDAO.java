package com.amt.schedule.impl;

import com.amt.schedule.inter.RoleEJB;
import com.amt.schedule.inter.UserEJB;
import com.amt.schedule.entities.Role;
import com.amt.schedule.entities.User;
import com.amt.schedule.utility.DB;
import com.amt.schedule.utility.DataFactory;
import com.amt.schedule.utility.InvalidCredentialsException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "UserImpl")
public class UserDAO implements UserEJB {

    private Connection db = DB.connection();

    @EJB
        private RoleEJB roleEJB;

    public UserDAO() throws Exception {
    }

    @Override
    public String creer(String username, String firstname, Role status) {
        String req = "INSERT INTO user VALUES (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, firstname);
            preparedStatement.setString(3, status.getStatus());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @Override
    public User chercher(int userid) {
        String req = "SELECT * FROM user WHERE userid = ?";
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                user.setUserid(userid);
                user.setUsername(resultSet.getString("username"));
                user.setNom(resultSet.getString("firstname"));
                user.setRole(roleEJB.chercher(resultSet.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public User chercher(String username) {
        String req = "SELECT * FROM user WHERE username = ?";
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.first()) {
                user.setUsername(resultSet.getString("username"));
                user.setNom(resultSet.getString("firstname"));
                user.setRole(roleEJB.chercher(resultSet.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> list(Role roleS) {
        String req = "SELECT * FROM user WHERE status = ?";
        PreparedStatement preparedStatement = null;
        List<User> users = new ArrayList<>();
        User user;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, roleS.getStatus());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                user = new User(resultSet.getString("username"), resultSet.getString("firstname"),
                        roleS);
                user.setUserid(resultSet.getInt("userid"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public String delete(User user) {
        String req = "DELETE FROM user WHERE userid = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setInt(1, user.getUserid());
            preparedStatement.execute();
            return "succes";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @Override
    public String edit(User user, String username, String firstname, Role role) {
        String req = "UPDATE user SET USERNAME = ?, FIRSTNAME = ?, STATUS = ? WHERE USERID = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.prepareStatement(req);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, firstname);
            preparedStatement.setString(3, role.getStatus());
            preparedStatement.setInt(4, user.getUserid());
            return "succes";
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "fail";
    }

    @Override
    public User login(String key, String password, String status) throws InvalidCredentialsException {
        // TODO Auto-generated method stub
        String msg = "";
        String errField = "";
        String cPass = DataFactory.crypt(password);
        String req = "SELECT * FROM user WHERE USERNAME = ? AND PASSWORD = ? AND STATUS = ?";
        User user = null;
        try {
            PreparedStatement prepared = db.prepareStatement(req);
            prepared.setString(1, key);
            prepared.setString(2, cPass);
            prepared.setString(3, status);
            ResultSet result = prepared.executeQuery();
            if (result.first()) {
                    user = new User(result.getString("username"), result.getString("firstname"), roleEJB.chercher(status));
                    user.setUserid(result.getInt("userid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(user != null);
        if (user != null) {
            return user;
        } else {
            user = chercher(key);
            if(user == null) {
                errField = "mat";
                msg = "utilisateur introuvable";
            }
            else {
                errField = "pass";
                msg = "Mot de passe incorrect";
            }
            throw new InvalidCredentialsException(msg, errField);
        }
    }
}
