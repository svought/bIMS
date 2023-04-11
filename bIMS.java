import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
        String sql;

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            //TODO Add ManufacturerName to header
            if (tableName == "items") {
                sql = "SELECT items.ItemID, items.ItemName, items.Cost, items.Cost, items.Quantity, items.Location, manufacturers.ManufacturerName " +
                        "FROM items INNER JOIN manufacturers ON items.ManufacturerID=manufacturers.ManufacturerID;";
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

    private static void Update(String tableName) {
        // Code to update record(s) in database
    }

    private static void Delete(String tableName, String recordName) {
        // Code to delete record(s) from database

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create record column based on given table name
            String recordColumn;
            switch (tableName){
                case "items":
                    recordColumn = "ItemName";
                    break;
                case "manufacturers":
                    recordColumn = "ManufacturerName";
                    break;
                case "users":
                    recordColumn = "UserName";
                    break;
                default:
                    System.out.println("Could not locate a column in " + tableName + " table to remove " + recordName);
                    return;
            }

            String sql = "DELETE FROM " + tableName + " WHERE " + recordColumn + "='" + recordName + "';";

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

    private static void Delete(String tableName, int recordID) {
        // Code to delete record(s) from database

        // Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);

            // Create record column based on given table name
            String recordColumn;
            switch (tableName){
                case "items":
                    recordColumn = "ItemID";
                    break;
                case "manufacturers":
                    recordColumn = "ManufacturerID";
                    break;
                case "Orders":
                    recordColumn = "OrderID";
                    break;
                case "users":
                    recordColumn = "UserID";
                    break;
                default:
                    System.out.println("Could not locate a column in " + tableName + " table to remove " + recordID);
                    return;
            }

            String sql = "DELETE FROM " + tableName + " WHERE " + recordColumn + "='" + recordID + "';";

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

    private static void bIMSDriver() {
        // Create Manufacturer in DB
        // Create("manufacturers", "(ManufacturerName, ManufacturerPhoneNumber, ManufacturerEmail)", "('testManufacturer', 4065956593, 'test@gmail.com')");

        // Create item in DB
        // Create("items", "(ItemName, Cost, SalePrice, Quantity, Location, ManufacturerID)", "('testItem', 2, 3, 10, '4E', 1)");

        // Read manufacturers table
        // Read("manufacturers");

        // Read items table
         Read("items");

        // Update
        // Update();

        // Delete record from table
//        System.out.println("\nDelete attempt, testOrder from orders...");
//        Delete("orders", "testOrder");
        System.out.println("\nDelete attempt, testItem with ID 4 from items...");
        Delete("items", 4);
        Read("items");

    }

   public static void main(String[] args) {
       bIMSDriver();
   }
}