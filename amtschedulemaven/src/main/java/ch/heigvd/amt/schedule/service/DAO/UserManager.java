package ch.heigvd.amt.schedule.service.DAO;

import ch.heigvd.amt.schedule.model.User;
import ch.heigvd.amt.schedule.utility.*;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class UserManager implements UserManagerLocal {
    @Resource(lookup = "jdbc/scheduleDatabase")
    private DataSource dataSource;
    private Connection connection = null;
    private PreparedStatement psmt = null;
    private ResultSet rs = null;

    @EJB
    private IJobDBStatementRoutineLocal job;

    @Override
    public boolean addUser(User newUser) {
        boolean successfulInsert = false;

        //Create the add user statement
        IFunctionAddStatement foo = (connection) -> {

            psmt = connection.prepareStatement("INSERT INTO users (firstname, lastname, username, hashed_password, email, is_admin) VALUES (?, ?, ?, ?, ?, ?);");
            psmt.setString(1, newUser.getFirstName());
            psmt.setString(2, newUser.getLastName());
            psmt.setString(3, newUser.getUserName());
            psmt.setString(4, newUser.getHashedPassword());
            psmt.setString(5, newUser.getEmail());
            psmt.setBoolean(6, newUser.isAdmin());

            int count = psmt.executeUpdate();

            return count;
        };

        //Embedded the statement execution in try catch matter.
        IJobDBStatementRoutineLocal job = new JobDBStatementRoutine();
        int insertCount = job.addObjectInDB(dataSource, foo);

        //Verify about the process is successfull
        successfulInsert = (insertCount > 0);

        return successfulInsert;
    }

    @Override
    public User findUser(int userId) throws SQLException {
        //Create the specific find user by ID statement
        IFunctionFindStatement foo = (connection) -> {
            psmt = connection.prepareStatement("SELECT * FROM users WHERE user_id = ?;");
            psmt.setInt(1, userId);
            ResultSet rs = psmt.executeQuery();
            return rs;
        };

        //Embedded the statement execution in try catch matter.
         rs = job.findObjectInDB(dataSource, foo);

        //Hydrate the user with the data from the data base upon the userId and return
        return hydrateUser(rs);
    }

    @Override
    public User findUser(String username) throws SQLException {
        //Create the specific find user by username statement
        IFunctionFindStatement foo = (connection) -> {
            psmt = connection.prepareStatement("SELECT * FROM users WHERE username = ?;");
            psmt.setString(1, username);
            ResultSet rs = psmt.executeQuery();
            return rs;
        };

        //Embedded the statement execution in try catch matter.
        rs = job.findObjectInDB(dataSource, foo);

        //Hydrate the user with the data from the data base upon the username and return
        return hydrateUser(rs);
    }

    @Override
    public User findUser(String userName, String password) throws SQLException {
        //Create the specific find user by username statement
        IFunctionFindStatement foo = (connection) -> {
            psmt = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND hashed_password = ?;");
            psmt.setString(1, userName);
            psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();
            return rs;
        };

        //Embedded the statement execution in try catch matter.
        rs = job.findObjectInDB(dataSource, foo);

        //Hydrate the user with the data from the data base upon the username and password and return
        return hydrateUser(rs);
    }

    private User hydrateUser(ResultSet rs){
        User user = null;
        try {
            if (!rs.next()) {
                user = User.builder().userId(rs.getInt("userId")).firstName(rs.getString("firstname"))
                        .lastName(rs.getString("lastname"))
                        .userName(rs.getString("username"))
                        .email(rs.getString("email"))
                        .hashedPassword(rs.getString("hashed_password"))
                        .isAdmin(rs.getBoolean("is_admin")).build();
            }
        }catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    @Override
    public boolean updateUser(User updatedUser) throws SQLException {
        boolean successfulInsert = false;

        //Create the update user statement
        IFunctionAddStatement foo = (connection) -> {

            psmt = connection.prepareStatement("UPDATE user SET firstname = ?, lastname = ?, username = ?, hashed_password = ?, email = ?, is_admin = ?;");
            psmt.setString(1, updatedUser.getFirstName());
            psmt.setString(2, updatedUser.getLastName());
            psmt.setString(3, updatedUser.getUserName());
            psmt.setString(4, updatedUser.getHashedPassword());
            psmt.setString(5, updatedUser.getEmail());
            psmt.setBoolean(6, updatedUser.isAdmin());

            int count = psmt.executeUpdate();

            return count;
        };

        //Embedded the statement execution in try catch matter.
        IJobDBStatementRoutineLocal job = new JobDBStatementRoutine();
        int insertCount = job.addObjectInDB(dataSource, foo);

        //Verify about the process is successfull
        successfulInsert = (insertCount > 0);

        return successfulInsert;
    }

    @Override
    public boolean deleteUser(int userId) {
        boolean deleteSuccess = false;

        //Create the delete user statement
        IFunctionAddStatement foo = (connection) -> {

            psmt = connection.prepareStatement("DELETE FROM user WHERE user_id = ?;");
            psmt.setInt(1, userId);
            psmt.execute();

            return 1;
        };

        //Embedded the statement execution in try catch matter.
        IJobDBStatementRoutineLocal job = new JobDBStatementRoutine();
        int deleteCount = job.addObjectInDB(dataSource, foo);

        //Verify about the process is successfull
        deleteSuccess = (deleteCount > 0);

        return deleteSuccess;
    }

    @Override
    public int countNumberOfUsers() {
        int numberOfUsers = 0;

        try {
            connection = dataSource.getConnection();
            try {
                psmt = connection.prepareStatement("SELECT COUNT(user_id) AS total FROM user;");
                ResultSet rs = psmt.executeQuery();

                if (rs.next()) {
                    numberOfUsers = rs.getInt("total");
                }

            } catch (Exception e) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                DBUtils.close(rs);
                DBUtils.close(psmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(connection);
        }

        return numberOfUsers;
    }
/*
    @Override
    public List<User> findListUser(int numberOfUsers) {
        return null;
    }

    @Override
    public List<User> findAll(){
        return  null;
    }
    @Override
    public boolean getPassword(String userName, String password) {
        return false;
    }

    @Override
    public boolean setPassword(User user, String newPassword) {
        return false;
    }
*/
    private List<User> fromDBToList(ResultSet rs) {
        List<User> users = new ArrayList<>();

        try {
            while (rs.next()) {
                users.add(User.builder().userId(rs.getInt("userId")).firstName(rs.getString("firstname"))
                        .lastName(rs.getString("lastname"))
                        .userName(rs.getString("username"))
                        .email(rs.getString("email"))
                        .hashedPassword(rs.getString("hashed_password"))
                        .isAdmin(rs.getBoolean("is_admin")).build());
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(connection);
        }
        return users;
    }


}
