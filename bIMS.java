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

// Readme.md
//<h1 align="center">bIMS</h1>
//
//<h2>Project Description</h2>
//A small buisness (lowecase b in bIMS) inventory management system designed to track inventory for small companies and make oredering an easier process.<br /><br />
//
//<h2>Why bIMS</h2>
//I aim to incorperate machine learning later in the developement life cycle to predict the buisnesses needs for a predetermined set of time (weekly, monthly, ect.). bIms will produce a list of predicted items that will need to be ordered, this list will be based on your companies history of sales.<br /><br />
//
//<h2>The Process</h2>
//In creating bIMS, I intned to start with getting the database set up and running. Then I will get a small java program running and interacting with the database from the MYSQL server. After that I will add CRUD capabilities for the user. Over time, I will add more features that will improve the usability of bIMS.<br /><br />
//
//
//<h2>Obstacles</h2>
//<ul>
//<li>Design database layout</li>
//<li>Creating database</li>
//<li>Normalizing database</li>
//<li>Get simple java program to interact with database</li>
//<li>UI desing process</li>
//<li>Adding CRUD operations</li>
//<li>Creating reporting system</li>
//<li>Adding inventory management features</li>
//<li>Hash user passwords for better security</li>
//<li>Learn ML and incorperate for predictions</li>
//<li>UX design process</li>
//<li>Continuously testing program</li>
//<li>Determine when first version can be published</li>
//</ul>
//
//<h2>Goals</h2>
//My goal with this project is to get hands on experience outside of the class room. Experience desired includes but is not limited to learning how to set up a MYSQL databes, connect and interact with said database from java program, build a larger scale project, more practice with soucre control, and data analysis with machine learning.
//
//<h2>Images</h2>
//Database Design <br />
//https://user-images.githubusercontent.com/42819077/230560467-d451148d-92ac-4287-b060-32e8a7c26222.jpg <br /><br />
//
//Database <br />
//https://user-images.githubusercontent.com/42819077/230562145-e7be64b4-a214-4b07-829b-89de1dae6160.png <br />
//
//<h2>Conclusion</h2>
//Yet to be determined, still working on and enjoying this project. Will update this section in the future.




