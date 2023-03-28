package helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {

    private final String url = "jdbc:postgresql://localhost:5432/cpp_db";
    private final String user = "postgres";
    private final String password = "root";

    //Prepares Java Postgres Connection
    public Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println("Connection failed with error: " + e.getMessage());
        }

        return connection;
    }
}
