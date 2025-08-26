
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class D29_04 {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL JDBC Driver loaded successfully");

            // Establish a connection
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Database connection established successfully");
                // You can perform database operations here
            } catch (SQLException e) {
                System.out.println("Database connection failed: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
