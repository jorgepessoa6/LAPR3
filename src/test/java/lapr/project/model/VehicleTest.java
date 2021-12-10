/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 *
 * @author Blanco
 */
public class VehicleTest{

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of isIsActive method, of class Vehicle.
     */
    @Test
    public void testIsIsActive() {
        System.out.println("isIsActive");
        Vehicle instance = new Vehicle(1,"1", null, 0, 0, 0, true);
        boolean expResult = true;
        boolean result = instance.isIsActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsActive method, of class Vehicle.
     */
    @Test
    public void testSetIsActive() {
        System.out.println("setIsActive");
        boolean isActive = false;
        Vehicle instance = new Vehicle( 1,"1", null, 0, 0, 0, true);
        instance.setIsActive(isActive);
        boolean expResult = false;
        boolean result = instance.isIsActive();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIdPark method, of class Vehicle.
     */
    @Test
    public void testGetIdPark() {
        System.out.println("getIdPark");
        Vehicle instance = new Vehicle( 1,"5", null, 0, 0, 0, true);
        String expResult = "5";
        String result = instance.getIdPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdPark method, of class Vehicle.
     */
    @Test
    public void testSetIdPark() {
        System.out.println("setIdPark");
        String idPark = "8";
        Vehicle instance = new Vehicle(1, "5", null, 0, 0, 0,true);
        instance.setIdPark(idPark);
        String expResult = "8";
        String result = instance.getIdPark();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Vehicle.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Vehicle instance = new Vehicle(1, "5", "desc1", 0, 0, 0, true);
        String expResult = "desc1";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Vehicle.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "desc2";
        Vehicle instance = new Vehicle(1,"5", "desc1", 0, 0, 0, true);
        instance.setDescription(description);
        String expResult = "desc2";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWeight method, of class Vehicle.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        Vehicle instance = new Vehicle(1,"5", "desc1", 45, 0, 0, true);
        int expResult = 45;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }

    /**
     * Test of setWeight method, of class Vehicle.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int weight = 12;
        Vehicle instance = new Vehicle(1,"5", "desc1", 45, 0, 0, true);
        instance.setWeight(weight);
        int expResult = 12;
        int result = instance.getWeight();
        assertEquals(expResult, result);
    }


    /**
     * Test of getAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testGetAerodynamicCoefficient() {
        System.out.println("getAerodynamicCoefficient");
        Vehicle instance = new Vehicle(1,"5", "desc1", 45, 4.2, 0, true);
        double expResult = 4.2;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAerodynamicCoefficient method, of class Vehicle.
     */
    @Test
    public void testSetAerodynamicCoefficient() {
        System.out.println("setAerodynamicCoefficient");
        double aerodynamicCoefficient = 7.2;
        Vehicle instance = new Vehicle(1,"5", "desc1", 45, 5.7, 0, true);
        instance.setAerodynamicCoefficient(aerodynamicCoefficient);
        double expResult = 7.2;
        double result = instance.getAerodynamicCoefficient();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getFrontalArea method, of class Vehicle.
     */
    @Test
    public void testGetFrontalArea() {
        System.out.println("getFrontalArea");
        Vehicle instance = new Vehicle(1,"5", "desc1", 45, 0, 91.2,true);
        double expResult = 91.2;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFrontalArea method, of class Vehicle.
     */
    @Test
    public void testSetFrontalArea() {
        System.out.println("setFrontalArea");
        double frontalArea = 76.2;
        Vehicle instance = new Vehicle(1, "5", "desc1", 45, 0, 56.4, true);
        instance.setFrontalArea(frontalArea);
        double expResult = 76.2;
        double result = instance.getFrontalArea();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class Vehicle.
     */
    @Test
    public void testEquals() {
        Vehicle vehicle1 = new Vehicle();
        Vehicle vehicle2 = new Vehicle();
        Vehicle vehicle3 = new Vehicle(1,"5", "desc1", 45, 0, 56.4, true);
        Vehicle vehicle4 = new Vehicle(1,"5", "desc1", 45, 0, 56.4, true);
        Vehicle vehicle5 = new Vehicle(2,"5", "desc1", 45, 0, 56.4, true);
        Vehicle vehicle6 = new Vehicle(1,"2", "desc1", 45, 0, 56.4, true);
        Vehicle vehicle7 = new Vehicle(1,"5", "a", 45,  0, 56.4, true);
        Vehicle vehicle8 = new Vehicle(1,"5", "desc1", 4, 0, 56.4, true);
        Vehicle vehicle11 = new Vehicle(1,"5", "desc1", 45, 10, 56.4, true);
        Vehicle vehicle12 = new Vehicle(1,"5", "desc1", 45, 0, 6.4, true);
        Vehicle vehicle13 = new Vehicle(1,"5", "desc1", 45, 0, 56.4, false);
        User user = new User();

        assertEquals(vehicle1, vehicle2);
        assertEquals(vehicle2, vehicle2);
        assertEquals(vehicle4, vehicle3);
        assertNotEquals(vehicle1, vehicle3);
        assertNotEquals(vehicle4, vehicle5);
        assertNotEquals(vehicle4, vehicle6);
        assertNotEquals(vehicle4, vehicle7);
        assertNotEquals(vehicle4, vehicle8);
        assertNotEquals(vehicle4, vehicle11);
        assertNotEquals(vehicle4, vehicle12);
        assertNotEquals(vehicle4, vehicle13);
        assertNotEquals(vehicle1, null);
        assertNotEquals(vehicle1, user);
    }

    /**
     * Test of hashCode method, of class Vehicle.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Vehicle instance = new Vehicle();
        Vehicle instance1 = new Vehicle();
        Vehicle instance2 = new Vehicle( 1,"5", "desc1", 45, 0, 56.4, true);
        assertEquals(instance.hashCode(), instance1.hashCode());
        assertNotEquals(instance1.hashCode(), instance2.hashCode());
    }

    /**
     * Test of toString method, of class Vehicle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Vehicle instance = new Vehicle(1,"5", "desc1", 45, 0, 56.4, true);
        String expResult = "Vehicle{"
                + "idVehicle=1"
                + ", idPark=5"  
                + ", description='desc1'"
                + ", weight=45"
                + ", aerodynamicCoefficient=0.0" 
                + ", frontalArea=56.4" 
                + ", isActive=true" 
                + '}';
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
