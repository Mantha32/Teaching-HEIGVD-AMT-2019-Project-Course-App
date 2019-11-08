package ch.heigvd.amt.schedule.service.DAO;

import ch.heigvd.amt.schedule.utility.IFunctionAddStatement;
import ch.heigvd.amt.schedule.utility.IFunctionFindStatement;

import javax.ejb.Local;
import javax.sql.DataSource;
import java.sql.ResultSet;

@Local
public interface IJobDBStatementRoutineLocal {
     public ResultSet findObjectInDB(DataSource dataSource, IFunctionFindStatement statement);
     public int addObjectInDB(DataSource dataSource, IFunctionAddStatement statement);
}
