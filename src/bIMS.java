package src;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.Integer.parseInt;

public class bIMS {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/bIMS_DB";
    private static final String user = "svought";
    private static final String password = "Svoughtpass00";

    public static void Create(String tableName, String attributes, String contents) {
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

    public static void Read(String tableName) {
        // Code to obtain information from record(s) from database
        String sql;

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            //TODO Add ManufacturerName to header
            if (tableName == "items") {
                sql = "SELECT items.ItemID, items.Name, items.Cost, items.SalePrice, items.Quantity, items.Location, manufacturers.Name " +
                        "FROM items INNER JOIN manufacturers ON items.ID=manufacturers.ID;";
            } else {
                sql = "SELECT * FROM " + tableName;
            }

            // Execute a select all statement as a test
            ResultSet result = conn.createStatement().executeQuery(sql);
            ResultSetMetaData metaData = result.getMetaData();
            Statement statement = conn.createStatement();
            statement.execute(sql);

            // Print results
            if (!result.next()) {
                System.out.println("No records found");
            } else {
                // Print table header
                for (int i = 1; i < metaData.getColumnCount(); i++) {
                    System.out.print(metaData.getColumnName(i) + "\t");
                }
                System.out.println("\n");

                // Print results
                do {
                    for (int i = 1; i < metaData.getColumnCount(); i++) {
                        System.out.print("\t" + result.getString(i) + "\t\t");
                    }
                    System.out.println();
                }
                while(result.next());
            }

            // Close result set and connection
            result.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public static void Update(String tableName) {
        // Code to update record(s) in database
    }

    public static void Delete(String tableName, String recordName) {
        // Code to delete record(s) from database

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM " + tableName + " WHERE Name='" + recordName + "';";

            // Execute a select all statement as a test
            Statement statement = conn.createStatement();
            statement.execute(sql);

            // Print results
            System.out.println("Successfully deleted " + recordName + " from " + tableName);

            // Close connection
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public static void Delete(String tableName, int recordID) {
        // Code to delete record(s) from database

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            String sql = "DELETE FROM " + tableName + " WHERE ID='" + recordID + "';";

            // Execute a select all statement as a test
            Statement statement = conn.createStatement();
            statement.execute(sql);

            // Print results
            System.out.println("Successfully deleted " + recordID + " from " + tableName);

            // Close connection
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public static boolean contains(String tableName, String element) {

        boolean inDB = false;

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Execute a select all statement as a test
            String sql = "SELECT 1 FROM " + tableName + " WHERE Name='" + element + "' LIMIT 1";
            ResultSet result = conn.createStatement().executeQuery(sql);
            Statement statement = conn.createStatement();
            statement.execute(sql);

            inDB = result.next();

            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return inDB;
    }

    public static int getID(String tableName, String name) {
        // Code to obtain id from record
        int ID = -99;
        String sql;

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            sql = "SELECT ID FROM " + tableName + " WHERE Name='" + name + "'";

            // Execute a select all statement as a test
            ResultSet result = conn.createStatement().executeQuery(sql);
            Statement statement = conn.createStatement();
            statement.execute(sql);

            // Set ID to result value
            while (result.next()) {
                ID = parseInt(result.getString("ID"));
            }

            // Close result set and connection
            result.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            throw new RuntimeException(ex);
        }

        return ID;
    }

    private static void bIMSDriver() {

        // Create item in DB
        // Create("items", "(ItemName, Cost, SalePrice, Quantity, Location, ManufacturerID)", "('testItem', 2, 3, 10, '4E', 1)");

        // Read manufacturers table
        // Read("manufacturers");

        // Read items table
        Read("manufacturers");

        //contains("manufacturers", "testManufacturer");

        // Update
        // Update();

        // Delete record from table
//        System.out.println("\nDelete attempt, testOrder from orders...");
//        Delete("orders", "testOrder");
//        System.out.println("\nDelete attempt, testItem with ID 4 from items...");
//        Delete("items", 4);
//        Read("items");

    }

   public static void main(String[] args) {
       bIMSDriver();
   }
}