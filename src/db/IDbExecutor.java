package db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbExecutor {
    public ResultSet execute(String sqlRequest) throws SQLException;
}
