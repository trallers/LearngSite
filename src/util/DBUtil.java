package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Антон on 02.04.2016.
 */
public class DBUtil {
    private static Connection connection = null;
    private static final String PROPERTIES_PATH = "resources/db.properties";

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties properties = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_PATH);
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String login = properties.getProperty("login");
                String password = properties.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, login, password);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
