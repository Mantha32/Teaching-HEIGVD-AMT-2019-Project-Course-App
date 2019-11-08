package ch.heigvd.amt.schedule.utility;

import javax.sql.DataSource;
import java.sql.ResultSet;

public interface IJobDBStatementRoutine {
     public ResultSet findObjectInDB(DataSource dataSource, IFunctionFindStatement statement);
     public int addObjectInDB(DataSource dataSource, IFunctionAddStatement statement);
}
