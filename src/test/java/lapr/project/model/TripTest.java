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
 * @author Francisco Ferreira
 */
public class TripTest {

    /**
     * Test of getIdTrip method, of class Trip.
     */
    @Test
    public void testGetIdTrip() {
        System.out.println("getIdTrip");
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        int expResult = 1;
        int result = instance.getIdTrip();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTrip method, of class Trip.
     */
    @Test
    public void testSetIdTrip() {
        System.out.println("setIdTrip");
        int idTrip = 3;
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        instance.setIdTrip(idTrip);
    }

    /**
     * Test of getIdVehicle method, of class Trip.
     */
    @Test
    public void testGetIdVehicle() {
        System.out.println("getIdVehicle");
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        String expResult = "2";
        String result = instance.getIdVehicle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdVehicle method, of class Trip.
     */
    @Test
    public void testSetIdVehicle() {
        System.out.println("setIdVehicle");
        String idVehicle = "3";
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        instance.setIdVehicle(idVehicle);
    }

    /**
     * Test of getEmail method, of class Trip.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        String expResult = "email_1";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Trip.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        instance.setEmail(email);
    }

    /**
     * Test of getIdStartPark method, of class Trip.
     */
    @Test
    public void testGetIdStartPark() {
        System.out.println("getIdStartPark");
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        String expResult = "3";
        String result = instance.getIdStartPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdStartPark method, of class Trip.
     */
    @Test
    public void testSetIdStartPark() {
        System.out.println("setIdStartPark");
        String idStartPark = "5";
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        instance.setIdStartPark(idStartPark);
    }

    /**
     * Test of testGetLatitudeEnd method, of class Trip.
     */
    @Test
    public void testGetLatitudeEnd() {
        System.out.println("getLatitudeEnd");
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        int expResult = 4;
        double result = instance.getLatitudeEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of testSetLatitudeEnd method, of class Trip.
     */
    @Test
    public void testSetLatitudeEnd() {
        System.out.println("setLatitudeEnd");
        double idEndPark = 7;
        Trip instance = new Trip(3, "4", "email_1", "5", 6, 2, "timestampStart_3", "timestampFinish_3");
        instance.setLatitudeEnd(idEndPark);
    }

    /**
     * Test of testGetLongitudeEnd method, of class Trip.
     */
    @Test
    public void testGetLongitudeEnd() {
        System.out.println("getLongitudeEnd");
        Trip instance = new Trip(1, "2", "email_1", "3", 4, 3, "timestampStart_1", "timestampFinish_1");
        int expResult = 3;
        double result = instance.getLongitudeEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of testSetIdEndPark method, of class Trip.
     */
    @Test
    public void testSetLongitudeEnd() {
        System.out.println("setLongitudeEnd");
        double idEndPark = 7;
        Trip instance = new Trip(3, "4", "email_1", "5", 6, 2, "timestampStart_3", "timestampFinish_3");
        instance.setLongitudeEnd(idEndPark);
    }

    /**
     * Test of getTimestampStart method, of class Trip.
     */
    @Test
    public void testGetTimestampStart() {
        System.out.println("getTimestampStart");
        Trip instance = new Trip(3, "4", "email_1", "5", 6, 2, "timestampStart_3", "timestampFinish_3");
        String expResult = "timestampStart_3";
        String result = instance.getTimestampStart();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimestampStart method, of class Trip.
     */
    @Test
    public void testSetTimestampStart() {
        System.out.println("setTimestampStart");
        String timestampStart = "";
        Trip instance = new Trip(3, "4", "email_1", "5", 6, 2, "timestampStart_3", "timestampFinish_3");
        instance.setTimestampStart(timestampStart);
    }

    /**
     * Test of getTimestampFinish method, of class Trip.
     */
    @Test
    public void testGetTimestampFinish() {
        System.out.println("getTimestampFinish");
        Trip instance = new Trip(3, "4", "email_1", "5", 6, 2, "timestampStart_3", "timestampFinish_5");
        String expResult = "timestampFinish_5";
        String result = instance.getTimestampFinish();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTimestampFinish method, of class Trip.
     */
    @Test
    public void testSetTimestampFinish() {
        System.out.println("setTimestampFinish");
        String timestampFinish = "";
        Trip instance = new Trip(3, "4", "email_1", "4", 5, 2, "timestampStart_3", "timestampFinish_3");
        instance.setTimestampFinish(timestampFinish);
    }

    /**
     * Test of equals method, of class Trip.
     */
    @Test
    public void testEquals() {
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();
        Trip trip3 = new Trip(3, "4", "email_1", "4", 5, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip4 = new Trip(3, "4", "email_1", "4", 5, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip5 = new Trip(4, "4", "email_1", "4", 5, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip6 = new Trip(3, "5", "email_1", "4", 5, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip7 = new Trip(3, "4", "a", "4", 5, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip8 = new Trip(3, "4", "email_1", "2", 5, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip9 = new Trip(3, "4", "email_1", "4", 2, 2, "timestampStart_3", "timestampFinish_3");
        Trip trip10 = new Trip(3, "4", "email_1", "4", 5, 1, "timestampStart_3", "timestampFinish_3");
        Trip trip11 = new Trip(3, "4", "email_1", "4", 5, 2, "a", "timestampFinish_3");
        Trip trip12 = new Trip(3, "4", "email_1", "4", 5, 2, "timestampStart_3", "a");
        User user = new User();

        assertEquals(trip1, trip2);
        assertEquals(trip2, trip2);
        assertEquals(trip4, trip3);
        assertNotEquals(trip1, trip3);
        assertNotEquals(trip4, trip5);
        assertNotEquals(trip4, trip6);
        assertNotEquals(trip4, trip7);
        assertNotEquals(trip4, trip8);
        assertNotEquals(trip4, trip9);
        assertNotEquals(trip4, trip10);
        assertNotEquals(trip4, trip11);
        assertNotEquals(trip4, trip12);
        assertNotEquals(trip1, null);
        assertNotEquals(trip1, user);

    }

    @Test
    void testHashCode() {
        Trip trip1 = new Trip();
        Trip trip2 = new Trip();
        Trip trip3 = new Trip(3, "4", "email_1", "4", 5, 1, "timestampStart_3", "timestampFinish_3");
        User user = new User();
        assertEquals(trip1.hashCode(), trip2.hashCode());
        assertEquals(trip2.hashCode(), trip2.hashCode());
        assertNotEquals(trip1.hashCode(), trip3.hashCode());
        assertNotEquals(trip1.hashCode(), user.hashCode());
    }

    /**
     * Test of toString method, of class Trip.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Trip instance = new Trip(5, "6", "email_6", "3", 2,2, "timestampStart_6", "timestampFinish_7");
        String expResult = "Trip{idTrip=5, idVehicle=6, email='email_6', idStartPark=3, latitudeEnd=2.0, longitudeEnd=2.0, timestampStart=timestampStart_6, timestampFinish=timestampFinish_7}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
