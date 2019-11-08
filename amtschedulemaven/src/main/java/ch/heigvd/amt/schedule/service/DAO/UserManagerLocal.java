package ch.heigvd.amt.schedule.service.DAO;

import ch.heigvd.amt.schedule.model.User;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

@Local
public interface UserManagerLocal {
    public boolean addUser(User newUser);
    public User findUser(int userId) throws SQLException;
    public User findUser(String username) throws SQLException;
    public User findUser(String userName, String password) throws SQLException;
    public boolean updateUser(User user) throws SQLException;
    public boolean deleteUser(int userId);

    public int countNumberOfUsers();
/*
    public List<User> findListUser(int numberOfUsers);
    public List<User> findAll();
    public boolean getPassword(String userName, String password);
    public boolean setPassword(User user, String newPassword);

 */
}
