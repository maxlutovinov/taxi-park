package taxi.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static Connection getConnection() {
        try (var input = ConnectionUtil.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Can't find application.properties");
            }
            Properties dbProperties = new Properties();
            dbProperties.load(input);
            Class.forName(dbProperties.getProperty("jdbc.driver"));
            return DriverManager.getConnection(
                    dbProperties.getProperty("db.url"),
                    dbProperties.getProperty("db.username"),
                    dbProperties.getProperty("db.password"));
        } catch (IOException e) {
            throw new RuntimeException("Can't read application.properties", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        } catch (SQLException e) {
            throw new RuntimeException("Can't create connection to DB", e);
        }
    }
}
