package src;

public class Driver extends bIMS{

    public static void main(String[] args) {

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
}
