package ch.heigvd.amt.schedule.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface IFunctionFindStatement {
    public ResultSet execute(Connection conn) throws SQLException;
}
