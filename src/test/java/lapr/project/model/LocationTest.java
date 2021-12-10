/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gabriel Vieira
 */
public class LocationTest {

    /**
     * Test of getLatitude method, of class Location.
     */
    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Location instance = new Location(1, 1, 1);
        double expResult = 1;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLatitude method, of class Location.
     */
    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 2;
        Location instance = new Location(1,1,1);
        instance.setLatitude(latitude);
    }

    /**
     * Test of getLongitude method, of class Location.
     */
    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Location instance = new Location(1,1,1);
        double expResult = 1;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLongitude method, of class Location.
     */
    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 2;
        Location instance = new Location(1,1,1);
        instance.setLongitude(longitude);
    }

    /**
     * Test of getElevation method, of class Location.
     */
    @Test
    public void testGetElevation() {
        System.out.println("getElevation");
        Location instance = new Location(1,1,1);
        int expResult = 1;
        int result = instance.getElevation();
        assertEquals(expResult, result);
    }

    /**
     * Test of setElevation method, of class Location.
     */
    @Test
    public void testSetElevation() {
        System.out.println("setElevation");
        int elevation = 2;
        Location instance = new Location(1,1,1);
        instance.setElevation(elevation);
    }
    
}
