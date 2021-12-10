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
public class ScooterTest {

    /**
     * Test of getType method, of class Scooter.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Scooter instance = new Scooter(1,"2", "description", 12, ScooterType.CITY, 13, 14, 15, 16, true,1);
        ScooterType expResult = ScooterType.CITY;
        ScooterType result = instance.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setType method, of class Scooter.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "OFF-ROAD";
        Scooter instance = new Scooter(1,"2", "description", 12, ScooterType.CITY, 13, 14, 15, 16, true,1);
        instance.setType(type);
        assertEquals(ScooterType.OFF_ROAD, instance.getType());
        instance.setType("city");
        assertEquals(ScooterType.CITY, instance.getType());
    }

    /**
     * Test of getMaxBattery method, of class Scooter.
     */
    @Test
    public void testGetMaxBattery() {
        System.out.println("getMaxBattery");
        Scooter instance = new Scooter(1,"3", "description_2", 12, ScooterType.CITY, 13, 14, 29, 30, true,1);
        double expResult = 13.0;
        double result = instance.getMaxBattery();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setMaxBattery method, of class Scooter.
     */
    @Test
    public void testSetMaxBattery() {
        System.out.println("setMaxBattery");
        double maxBattery = 14.0;
        Scooter instance = new Scooter(1,"3", "description_3", 12, ScooterType.OFF_ROAD, 13, 14, 15, 16, true,1);
        instance.setMaxBattery(maxBattery);
    }

    /**
     * Test of getActualBattery method, of class Scooter.
     */
    @Test
    public void testGetActualBattery() {
        System.out.println("getActualBattery");
        Scooter instance = new Scooter(1,"4", "description_4", 112, ScooterType.OFF_ROAD,22, 23.2, 24, 25, true,1);
        Double expResult = 23.2;
        Double result = instance.getActualBattery();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActualBattery method, of class Scooter.
     */
    @Test
    public void testSetActualBattery() {
        System.out.println("setActualBattery");
        double actualBattery = 22.2;
        Scooter instance = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.2, 24, 25, true,1);
        instance.setActualBattery(actualBattery);
    }
    
        @Test
    public void testGetMotor() {
        System.out.println("getMotor");
        Scooter instance = new Scooter(1,"4", "description_4", 112, ScooterType.OFF_ROAD,22, 23.2, 24, 25, true,1);
        int expResult = 1;
        int result = instance.getMotor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setActualBattery method, of class Scooter.
     */
    @Test
    public void testSetMotor() {
        System.out.println("setMotor");
        int motor = 2;
        Scooter instance = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.2, 24, 25, true,1);
        instance.setMotor(motor);
    }

    /**
     * Test of equals method, of class Scooter.
     */
    @Test
    void testEquals() {
        Scooter scooter1 = new Scooter();
        Scooter scooter2 = new Scooter();
        Scooter scooter3 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.2, 24, 25, true,1);
        Scooter scooter4 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY,  22, 23.2, 24, 25, true,1);
        Scooter scooter5 = new Scooter(2,"4", "description_4", 112, ScooterType.CITY,  22, 23.2, 24, 25, true,1);
        Scooter scooter6 = new Scooter(1,"5", "description_4", 112, ScooterType.CITY,  22, 23.2, 24, 25, true,1);
        Scooter scooter7 = new Scooter(1,"4", "a", 112, ScooterType.CITY, 22, 23.2, 24, 25, true,1);
        Scooter scooter8 = new Scooter(1,"4", "description_4", 10, ScooterType.CITY, 22, 23.2, 24, 25, true,1);
        Scooter scooter9 = new Scooter(1,"4", "description_4", 112, ScooterType.OFF_ROAD, 22, 23.2, 24, 25, true,1);
        Scooter scooter12 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 2, 23.2, 24, 25, true,1);
        Scooter scooter13 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.0, 24, 25, true,1);
        Scooter scooter14 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.2, 2, 25, true,1);
        Scooter scooter15 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.2, 24, 2, true,1);
        User user = new User();

        assertEquals(scooter1, scooter2);
        assertEquals(scooter2, scooter2);
        assertEquals(scooter4, scooter3);
        assertNotEquals(scooter1, scooter3);
        assertNotEquals(scooter4, scooter5);
        assertNotEquals(scooter4, scooter6);
        assertNotEquals(scooter4, scooter7);
        assertNotEquals(scooter4, scooter8);
        assertNotEquals(scooter4, scooter9);
        assertNotEquals(scooter4, scooter12);
        assertNotEquals(scooter4, scooter13);
        assertNotEquals(scooter4, scooter14);
        assertNotEquals(scooter4, scooter15);
        assertNotEquals(scooter1, null);
        assertNotEquals(scooter1, user);
    }

    @Test
    void testHashCode() {
        Scooter scooter1 = new Scooter();
        Scooter scooter2 = new Scooter();
        Scooter scooter3 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY,22, 23.2, 24, 25, true,1);
        User user = new User();

        assertEquals(scooter1.hashCode(), scooter2.hashCode());
        assertEquals(scooter2.hashCode(), scooter2.hashCode());
        assertNotEquals(scooter1.hashCode(), scooter3.hashCode());
        assertNotEquals(scooter3.hashCode(), user.hashCode());
    }

    @Test
    void testToString() {
        Scooter scooter1 = new Scooter();
        Scooter scooter2 = new Scooter();
        Scooter scooter3 = new Scooter(1,"4", "description_4", 112, ScooterType.CITY, 22, 23.2, 24, 25, true,1);
        User user = new User();

        assertEquals(scooter1.toString(), scooter2.toString());
        assertEquals(scooter2.toString(), scooter2.toString());
        assertNotEquals(scooter1.toString(), scooter3.toString());
        assertNotEquals(scooter1.toString(), user.toString());
    }
}
