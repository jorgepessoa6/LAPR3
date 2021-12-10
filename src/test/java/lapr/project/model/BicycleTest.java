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
public class BicycleTest {

    /**
     * Test of getBicycleType method, of class Bicycle.
     */
    @Test
    public void testGetBicycleType() {
        System.out.println("getBicycleType");
        Bicycle instance = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        int expResult = 4;
        int result = instance.getBicycleType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWheelSize method, of class Bicycle.
     */
    @Test
    public void testGetWheelSize() {
        System.out.println("getWheelSize");
        Bicycle instance = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        int expResult = 21;
        int result = instance.getWheelSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBicycleType method, of class Bicycle.
     */
    @Test
    public void testSetBicycleType() {
        System.out.println("setBicycleType");
        int bicycleType = 13;
        Bicycle instance = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        instance.setBicycleType(bicycleType);
        assertEquals(instance.getBicycleType(), bicycleType);
    }

    /**
     * Test of setWheelSize method, of class Bicycle.
     */
    @Test
    public void testSetWheelSize() {
        System.out.println("setWheelSize");
        int wheelSize = 19;
        Bicycle instance = new Bicycle(1, "1", "description", 3, 3, 5, 4, true, 21);
        instance.setWheelSize(wheelSize);
        assertEquals(instance.getWheelSize(), wheelSize);
    }

    /**
     * Test of equals method, of class Bicycle.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Bicycle b = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        Object o = (Object) b;
        boolean expResult = true;
        boolean result = b.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bicycle.
     */
    @Test
    public void testEquals1() {
        System.out.println("equals1");
        Bicycle b = new Bicycle(1,"3", "a", 4, 6, 9, 10, false, 22);
        Object o = (Object) b;
        Bicycle instance = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bicycle.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals2");
        Bicycle b = new Bicycle( 1,"1", "description", 3, 3, 5, 4, true, 21);
        Object o = (Object) b;
        Bicycle instance = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bicycle.
     */
    @Test
    public void testEquals3() {
        System.out.println("equals");
        Bicycle b = new Bicycle();
        Bicycle c = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        Object o = (Object) c;
        boolean expResult = false;
        boolean result = b.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Bicycle.
     */
    @Test
    public void testEquals4() {
        Bicycle bicycle1 = new Bicycle();
        Bicycle bicycle2 = new Bicycle();
        Bicycle bicycle3 = new Bicycle(1, "1", "description", 3, 3, 5, 4, true, 21);
        Bicycle bicycle4 = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        Bicycle bicycle5 = new Bicycle(2,"1", "description", 3, 3, 5, 4, true, 21);
        Bicycle bicycle6 = new Bicycle(1,"2", "description", 3, 3, 5, 4, true, 21);
        Bicycle bicycle7 = new Bicycle(1,"1", "a", 3, 3, 5, 4, true, 21);
        Bicycle bicycle8 = new Bicycle(1,"1", "description", 4, 3, 5, 4, true, 21);
        Bicycle bicycle11 = new Bicycle(1,"1", "description", 3, 4, 5, 4, true, 21);
        Bicycle bicycle12 = new Bicycle(1,"1", "description", 3, 3, 6, 4, true, 21);
        Bicycle bicycle13 = new Bicycle(1,"1", "description", 3, 3, 5, 7, true, 21);
        User user = new User();
        assertEquals(bicycle1, bicycle2);
        assertEquals(bicycle2, bicycle2);
        assertEquals(bicycle4, bicycle3);
        assertNotEquals(bicycle1, bicycle3);
        assertNotEquals(bicycle4, bicycle5);
        assertNotEquals(bicycle4, bicycle6);
        assertNotEquals(bicycle4, bicycle7);
        assertNotEquals(bicycle4, bicycle8);
        assertNotEquals(bicycle4, bicycle11);
        assertNotEquals(bicycle4, bicycle12);
        assertNotEquals(bicycle4, bicycle13);
        assertNotEquals(bicycle1, null);
        assertNotEquals(bicycle1, user);
    }

    /**
     * Test of hashCode method, of class Bicycle.
     */
    @Test
    void testHashCode() {
        Bicycle bicycle1 = new Bicycle();
        Bicycle bicycle2 = new Bicycle();
        Bicycle bicycle3 = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        User user = new User();
        assertEquals(bicycle1.hashCode(), bicycle2.hashCode());
        assertEquals(bicycle2.hashCode(), bicycle2.hashCode());
        assertNotEquals(bicycle1.hashCode(), bicycle3.hashCode());
        assertNotEquals(bicycle1.hashCode(), user.hashCode());
    }

    /**
     * Test of toString method, of class Bicycle.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Bicycle instance = new Bicycle(1,"1", "description", 3, 3, 5, 4, true, 21);
        String expResult = "Bicycle{idVehicle=1, idPark=1, description='description', weight=3, aerodynamicCoefficient=3.0, frontalArea=5.0, bicycleType=4, wheel_size=21}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
