package Kelompok_1_tubes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/studikasus";
    private static final String USER = "root";  // Replace with your MySQL username
    private static final String PASSWORD = "";   // Replace with your MySQL password

    public static void main(String[] args) {
        testConnection();
    }

    public static Connection getConnection() throws SQLException {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection successful!");
            return conn;

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found", e);
        } catch (SQLException e) {
            System.out.println("Connection failed! Check output console");
            e.printStackTrace();
            throw e;
        }
    }

    public static void testConnection() {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("You successfully connected to the database!");
                conn.close();
                System.out.println("Connection closed.");
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}