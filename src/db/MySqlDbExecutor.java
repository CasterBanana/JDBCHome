package db;

import utils.resources.IResource;
import utils.resources.PropertiesReader;

import java.sql.*;

import java.util.Map;

public class MySqlDbExecutor implements IDbExecutor {
    private static Connection connection = null;
    private static Statement statement = null;

    @Override
    public ResultSet execute(String sqlRequest) throws SQLException {
        IResource resources = new PropertiesReader();
        Map<String, String> props = resources.read();

        String url = String.format("%s/%s", props.get("url"), props.get("db_name"));


        try {
            connection = DriverManager.getConnection(url, props.get("username"), props.get("password"));
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlRequest);

            return resultSet;

        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
