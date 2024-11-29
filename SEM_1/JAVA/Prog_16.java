package Java_Prog;

import java.sql.*;
import java.util.Scanner;

public class Prog_16 {

    // Get database connection
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/University";
        String username = "root";  
        String password = "password";  
        return DriverManager.getConnection(url, username, password);
    }

    // Create the database if it doesn't exist
    public static void createDatabase(String dbName) {
        String createDBQuery = "CREATE DATABASE IF NOT EXISTS " + dbName;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(createDBQuery);
            System.out.println("Database created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create the table with the given table name and structure
    public static void createTable(String dbName, String tableName) {
        String createTableQuery = """
            CREATE TABLE IF NOT EXISTS %s (
                student_id INT PRIMARY KEY,
                first_name VARCHAR(50),
                last_name VARCHAR(50),
                age INT,
                major VARCHAR(100)
            )
        """.formatted(tableName);

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("USE " + dbName); // Switch to the created database
            stmt.executeUpdate(createTableQuery);
            System.out.println("Table " + tableName + " created or already exists.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create stored procedure to get student by ID
    public static void createStoredProcedure() {
        String dropProcedureQuery = "DROP PROCEDURE IF EXISTS getStudentById;";
        String procedureQuery = """
            CREATE PROCEDURE getStudentById(IN studentId INT)
            BEGIN
                SELECT student_id, first_name, last_name, age, major
                FROM Students
                WHERE student_id = studentId;
            END
        """;

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            // Drop the stored procedure if it already exists
            stmt.executeUpdate(dropProcedureQuery);

            // Now create the stored procedure
            stmt.executeUpdate(procedureQuery);
            System.out.println("Stored procedure 'getStudentById' created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve student by ID using the stored procedure
    public static void getStudentById(int studentId) {
        String sql = "{CALL getStudentById(?)}";

        try (Connection conn = getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, studentId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("student_id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    int age = rs.getInt("age");
                    String major = rs.getString("major");

                    System.out.println("Student ID: " + id);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("Age: " + age);
                    System.out.println("Major: " + major);
                } else {
                    System.out.println("No student found with ID: " + studentId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Create Database and Table
        String dbName = "University";
        String tableName = "Students";
        createDatabase(dbName);
        createTable(dbName, tableName);
        
        // Step 2: Create stored procedure
        createStoredProcedure();

        // Step 3: Retrieve student information by ID
        System.out.println("\n");
        System.out.print("Enter student ID to retrieve details: ");
        int studentId = scanner.nextInt();
        getStudentById(studentId);

        scanner.close();
    }
}
