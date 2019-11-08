package ch.heigvd.amt.schedule.service.DAO;

import ch.heigvd.amt.schedule.utility.DBUtils;
import ch.heigvd.amt.schedule.utility.IFunctionAddStatement;
import ch.heigvd.amt.schedule.utility.IFunctionFindStatement;

import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class JobDBStatementRoutine implements IJobDBStatementRoutineLocal {

    @Override
    public ResultSet findObjectInDB(DataSource dataSource, IFunctionFindStatement statement) {
        Connection connection = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        try {
            connection = dataSource.getConnection();
            try {

                 rs =statement.execute(connection);

            } catch (Exception e) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                DBUtils.close(psmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(connection);
        }

        return  rs;
    }

    @Override
    public int addObjectInDB(DataSource dataSource, IFunctionAddStatement statement){
        Connection connection = null;
        PreparedStatement psmt = null;
        int rs = 0;

        try {
            connection = dataSource.getConnection();
            try {

                rs =statement.execute(connection);

            } catch (Exception e) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, e);
            } finally {
                DBUtils.close(psmt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBUtils.close(connection);
        }

        return  rs;
    }
}
