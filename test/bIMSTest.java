package test;

import org.junit.Test;
import src.bIMS;

import static org.junit.jupiter.api.Assertions.*;

public class bIMSTest {

    @Test
    public void containsTest() {
        // Note that testManufacturer is in database for testing purposes while tempManufacturer is not
        assertTrue(bIMS.contains("manufacturers", "testManufacturer"));
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
    }

    @Test
    public void getIDTest() {
        // Note that testManufacturer is in database for testing purposes
        assertEquals(1, bIMS.getID("manufacturers", "testManufacturer"));
        bIMS.Create("manufacturers", "(Name, ManufacturerPhoneNumber, ManufacturerEmail)", "('testManufacturer2', 4065956594, 'test2@gmail.com')");
        assertNotEquals(1, bIMS.getID("manufacturers", "testManufacturer2"));
        bIMS.Delete("manufacturers", "testManufacturer2");
    }

    @Test
    public void createManufacturerTest() {
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
        bIMS.Create("manufacturers", "(Name, ManufacturerPhoneNumber, ManufacturerEmail)", "('tempManufacturer', 4065956593, 'temp@gmail.com')");
        assertTrue(bIMS.contains("manufacturers", "tempManufacturer"));
        bIMS.Delete("manufacturers", "tempManufacturer");
    }

    @Test
    public void deleteManufacturerByNameTest() {
        bIMS.Create("manufacturers", "(Name, ManufacturerPhoneNumber, ManufacturerEmail)", "('tempManufacturer', 4065956593, 'temp@gmail.com')");
        assertTrue(bIMS.contains("manufacturers", "tempManufacturer"));
        bIMS.Delete("manufacturers", "tempManufacturer");
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
    }

    @Test
    public void deleteManufacturerByIDTest() {
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
        bIMS.Create("manufacturers", "(Name, ManufacturerPhoneNumber, ManufacturerEmail)", "('tempManufacturer', 4065956593, 'temp@gmail.com')");
        assertTrue(bIMS.contains("manufacturers", "tempManufacturer"));

        int ID = bIMS.getID("manufacturers", "tempManufacturer");
        bIMS.Delete("manufacturers", ID);
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
    }

}