import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class bIMS {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/bIMS_DB";
    private static final String user = "svought";
    private static final String password = "Svoughtpass00";

    private static void connectToDB() {

        // Change later to get user input and verify login credentials




    }

    private static void Create(String tableName, String attributes, String contents) {
        // Code to create record in database

        //Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting...");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");

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

    private static void Read() {
        // Code to obtain information from record(s) from database

        //Try to connect to database using username and password
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting...");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully");

            // Execute a select all statement as a test
            String sql = "SELECT * FROM items";
            Statement statement = conn.createStatement();
            statement.execute(sql);


            System.out.println();
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
        //connectToDB();

        //Create Manufacturere in DB
        Create("manufacturers", "(ManufacturerName, ManufacturerPhoneNumber, ManufacturerEmail)", "('testManufacturer', 4065956593, 'test@gmail.com')");

        //Create item in DB
        //Create("items", "(Name, Cost, SalePrice, Quantity, Location, ManufacturerID)", "('testItem', 2, 3, 10, '4E', 0)");
    }

   public static void main(String[] args) {
       bIMSDriver();
   }
}




