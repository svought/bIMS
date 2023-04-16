package test;

import org.junit.Test;
import src.bIMS;

import static org.junit.jupiter.api.Assertions.*;

public class bIMSTest {

    @Test
    public void containsTest() {
        // Create Manufacturer in DB
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
        assertTrue(bIMS.contains("manufacturers", "testManufacturer"));
    }

    @Test
    public void createManufacturerTest () {
        // Create Manufacturer in DB
        bIMS.Create("manufacturers", "(ManufacturerName, ManufacturerPhoneNumber, ManufacturerEmail)", "('tempManufacturer', 4065956593, 'test@gmail.com')");
        assertTrue(bIMS.contains("manufacturers", "tempManufacturer"));
    }

    @Test
    public void deleteManufacturerTest () {
        // Create Manufacturer in DB
        bIMS.Delete("manufacturers", "tempManufacturer");
        assertFalse(bIMS.contains("manufacturers", "tempManufacturer"));
    }

}