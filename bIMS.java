import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class bIMS {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/bIMS_DB";
    private static final String user = "svought";
    private static final String password = "Svoughtpass00";

    private static void Create(String tableName, String attributes, String contents) {
        // Code to create record in database

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Execute a select all statement as a test
            String sql = "INSERT INTO " + tableName + " " + attributes + "VALUES " + contents;
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

            conn.close();
            System.out.println("Process finished, connection closed");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    private static void Read(String tableName) {
        // Code to obtain information from record(s) from database

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Execute a select all statement as a test
            String sql = "SELECT * FROM " + tableName;
            ResultSet result = conn.createStatement().executeQuery(sql);
            ResultSetMetaData metaData = result.getMetaData();
            Statement statement = conn.createStatement();
            statement.execute(sql);

            // Print table header
            for (int i = 1; i < metaData.getColumnCount(); i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println("\n");

            // Print results
            while(result.next()){
                for (int i = 1; i < metaData.getColumnCount(); i++) {
                    System.out.print("\t" + result.getString(i) + "\t\t");
                }
                System.out.println();
            }

            // Close result set and connection
            result.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    private static void Update() {
        // Code to update record(s) in database
    }

    private static void Delete() {
        // Code to delete record(s) from database
    }

    public static void bIMSDriver() {
        // Create Manufacturer in DB
        // Create("manufacturers", "(ManufacturerName, ManufacturerPhoneNumber, ManufacturerEmail)", "('testManufacturer', 4065956593, 'test@gmail.com')");

        // Create item in DB
        // Create("items", "(Name, Cost, SalePrice, Quantity, Location, ManufacturerID)", "('testItem', 2, 3, 10, '4E', 0)");

        // Read manufacturers table
        Read("manufacturers");
    }

   public static void main(String[] args) {
       bIMSDriver();
   }
}




