package main.java.proiect.persistence.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtils {

    private static final String MYSQL_JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "123456";


    private Connection connection;

    private static volatile DatabaseConnectionUtils instance;

    private DatabaseConnectionUtils() {
        try {
            Class.forName(MYSQL_JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("MySQL connection available");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not available: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Could not connect to database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unknown error: " + e.getMessage());
        }
    }


    public static Connection getDatabaseConnection() {
        System.out.println("Getting database connection...");
        System.out.println(instance);
        if (instance == null) {
            synchronized (DatabaseConnectionUtils.class) {
                if (instance == null) {
                    instance = new DatabaseConnectionUtils();
                }
            }
        }
        return instance.connection;
    }


}