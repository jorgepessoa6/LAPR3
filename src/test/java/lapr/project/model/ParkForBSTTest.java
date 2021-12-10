/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jorgi
 */
public class ParkForBSTTest {

    public ParkForBSTTest() {
    }

    /**
     * Test of getPark method, of class ParkForBST.
     */
    @Test
    public void testGetPark() {
        System.out.println("getPark");
        Park park = new Park("0", "park", 10, 10, 0d, 0d, 3, 4d, 5d);
        ParkForBST instance = new ParkForBST(park, 10);
        Park expResult = park;
        Park result = instance.getPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class ParkForBST.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Park park = new Park("0", "park", 10, 10, 0d, 0d, 3, 4d, 5d);
        ParkForBST instance = new ParkForBST(park, 10);
        double expResult = 10;
        double result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class ParkForBST.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Park park = new Park("0", "park", 10, 10, 0d, 0d, 3, 4d, 5d);
        Park park1 = new Park();
        ParkForBST instance = new ParkForBST(park, 10);
        ParkForBST instance1 = new ParkForBST(park, 10);
        ParkForBST instance2 = new ParkForBST(park, 10.2);
        ParkForBST instance3 = new ParkForBST(park1, 10);
        ParkForBST instance4 = null;
        assertEquals(instance, instance);
        assertEquals(instance, instance1);
        assertNotEquals(instance, instance2);
        assertNotEquals(instance, instance3);
        assertNotEquals(instance, instance4);
        assertNotEquals(instance, park);
    }

    /**
     * Test of hashCode method, of class ParkForBST.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Park park = new Park("0", "park", 10, 10, 0d, 0d, 3, 4d, 5d);
        Park park1 = new Park();
        ParkForBST instance = new ParkForBST(park, 10);
        ParkForBST instance1 = new ParkForBST(park, 10);
        ParkForBST instance2 = new ParkForBST(park, 10.2);
        ParkForBST instance3 = new ParkForBST(park1, 10);
        assertEquals(instance.hashCode(), instance1.hashCode());
        assertNotEquals(instance.hashCode(), instance2.hashCode());
        assertNotEquals(instance.hashCode(), instance3.hashCode());
        assertNotEquals(instance.hashCode(), park.hashCode());
    }

    /**
     * Test of compareTo method, of class ParkForBST.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Park park = new Park("0", "park", 10, 10, 0d, 0d, 3, 4d, 5d);
        ParkForBST instance1 = new ParkForBST(park, 10);
        ParkForBST instance2 = new ParkForBST(park, 10.2);
        int result = instance1.compareTo(instance2);
        assertEquals(-1, result);
        result = instance2.compareTo(instance1);
        assertEquals(1, result);
        assertEquals(-1, instance1.compareTo(instance1));
    }
}
