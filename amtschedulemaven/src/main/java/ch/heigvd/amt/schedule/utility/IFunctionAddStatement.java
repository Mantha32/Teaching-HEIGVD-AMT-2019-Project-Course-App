package ch.heigvd.amt.schedule.utility;

import java.sql.Connection;
import java.sql.SQLException;

@FunctionalInterface
public interface IFunctionAddStatement {
    public int execute(Connection conn) throws SQLException;
}
