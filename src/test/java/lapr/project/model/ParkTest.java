/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Iterator;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author rickropes
 */
public class ParkTest {


    
    private Park setup() {
        Park instance = new Park("0", "park", 10, 10, 0d, 0d, 3, 4d, 5d);
        Bicycle b1 = new Bicycle(1,"0", "bicycle1", 1, 2d, 3d, 0, false, 1);
        Bicycle b2 = new Bicycle(1,"0", "bicycle2", 1, 2d, 3d, 0, false, 1);
        Bicycle b3 = new Bicycle(1,"0", "bicycle3", 1, 2d, 3d, 0, false, 1);
        Bicycle b4 = new Bicycle(1,"0", "bicycle4", 1, 2d, 3d, 0, false, 1);
        Bicycle b5 = new Bicycle(1,"0", "bicycle5", 1, 2d, 3d, 0, false, 1);
        instance.addBicycle(b1);
        instance.addBicycle(b2);
        instance.addBicycle(b3);
        instance.addBicycle(b4);
        instance.addBicycle(b5);

        Scooter s1 = new Scooter(1,"0", "scooter1", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        Scooter s2 = new Scooter(1,"0", "scooter2", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        Scooter s3 = new Scooter(1,"0", "scooter3", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        Scooter s4 = new Scooter(1,"0", "scooter4", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        Scooter s5 = new Scooter(1,"0", "scooter5", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        instance.addScooter(s1);
        instance.addScooter(s2);
        instance.addScooter(s3);
        instance.addScooter(s4);
        instance.addScooter(s5);

        return instance;
    }

    @Test
    public void testGetListBicycles() {
        System.out.println("getListBicycles");
        Park instance = setup();
        Set<Bicycle> result = instance.getListBicycles();
        Iterator<Bicycle> it = result.iterator(); 
       
        assertEquals(result.size(), 5);
        /*assertEquals(2, it.next().getIdVehicle());
        assertEquals(3, it.next().getIdVehicle());
        assertEquals(1, it.next().getIdVehicle());*/
    }

    @Test
    public void testGetListScooters() {
        System.out.println("getListScooters");
        Park instance = setup();
        Set<Scooter> result = instance.getListScooters();
        Iterator<Scooter> it = result.iterator();

        assertEquals(result.size(), 5);
        /*assertEquals(8, it.next().getIdVehicle());
        assertEquals(10, it.next().getIdVehicle());
        assertEquals(6, it.next().getIdVehicle());*/
        
    }

    @Test
    public void testGetIdPark() {
        System.out.println("getIdVehicle");
        Park instance = setup();
        Set<Bicycle> result = instance.getListBicycles();
        Iterator<Bicycle> it = result.iterator();
        
        assertEquals(result.size(), 5);
        assertEquals("0", it.next().getIdPark());
        assertEquals("0", it.next().getIdPark());
        assertEquals("0", it.next().getIdPark());
    }

    @Test
    public void testSetIdPark() {
        System.out.println("setIdPark");
        Park instance = setup();
        assertEquals(instance.getIdPark(), "0");
        String idPark = "1";
        instance.setIdPark(idPark);
        assertEquals(instance.getIdPark(), "1");
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Park instance = setup();
        String expResult = "park";
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        Park instance = setup();
        assertEquals("park", instance.getDescription());
        instance.setDescription("desc");
        assertEquals("desc", instance.getDescription());
    }

    @Test
    public void testGetMaxCapacityScooters() {
        System.out.println("getMaxCapacityScooters");
        Park instance = setup();
        int expResult = 10;
        int result = instance.getMaxCapacityScooters();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetMaxCapacityScooters() {
        System.out.println("setMaxCapacityScooters");
        Park instance = setup();
        assertEquals(10, instance.getMaxCapacityScooters());
        instance.setMaxCapacityScooters(10);
        assertEquals(10, instance.getMaxCapacityScooters());
    }

    @Test
    public void testGetMaxCapacityBicycles() {
        System.out.println("getMaxCapacityBicycles");
        Park instance = setup();
        int expResult = 10;
        int result = instance.getMaxCapacityBicycles();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetMaxCapacityBicycles() {
        System.out.println("setMaxCapacityBicycles");
        Park instance = setup();
        assertEquals(10, instance.getMaxCapacityBicycles());
        instance.setMaxCapacityBicycles(10);
        assertEquals(10, instance.getMaxCapacityBicycles());
    }

    @Test
    public void testGetLatitude() {
        System.out.println("getLatitude");
        Park instance = setup();
        double expResult = 0.0;
        double result = instance.getLatitude();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetLatitude() {
        System.out.println("setLatitude");
        double latitude = 8.0;
        Park instance = setup();
        assertEquals(instance.getLatitude(), 0.0, 0.0);
        instance.setLatitude(latitude);
        assertEquals(instance.getLatitude(), 8.0, 0.0);
    }

    @Test
    public void testGetLongitude() {
        System.out.println("getLongitude");
        Park instance = new Park();
        double expResult = 0.0;
        double result = instance.getLongitude();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetLongitude() {
        System.out.println("setLongitude");
        double longitude = 8.0;
        Park instance = setup();
        assertEquals(instance.getLongitude(), 0.0, 0.0);
        instance.setLongitude(longitude);
        assertEquals(instance.getLongitude(), 8.0, 0.0);
    }

    @Test
    public void testGetElevation() {
        System.out.println("getElevation");
        Park instance = setup();
        int expResult = 3;
        int result = instance.getElevation();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetElevation() {
        System.out.println("setElevation");
        int elevation = 0;
        Park instance = setup();
        assertEquals(instance.getElevation(), 3);
        instance.setElevation(elevation);
        assertEquals(instance.getElevation(), 0);
    }

    @Test
    public void testGetVoltage() {
        System.out.println("getVoltage");
        Park instance = setup();
        double expResult = 4.0;
        double result = instance.getVoltage();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetVoltage() {
        System.out.println("setVoltage");
        double voltage = 0.0;
        Park instance = setup();
        assertEquals(instance.getVoltage(), 4.0, 0.0);
        instance.setVoltage(voltage);
        assertEquals(instance.getVoltage(), 0.0, 0.0);
    }

    @Test
    public void testGetCurrent() {
        System.out.println("getCurrent");
        Park instance = setup();
        double expResult = 5.0;
        double result = instance.getCurrent();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testSetCurrent() {
        System.out.println("setCurrent");
        double current = 0.0;
        Park instance = setup();
        assertEquals(instance.getCurrent(), 5.0, 0.0);
        instance.setCurrent(current);
        assertEquals(instance.getCurrent(), 0.0, 0.0);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Park park1 = new Park();
        Park park2 = new Park();
        Park park3 = new Park("0", "park", 0, 0, 0d, 0d, 3, 4d, 5d);
        Park park4 = new Park("0", "park", 0, 0, 0d, 0d, 3, 4d, 5d);
        Park park5 = new Park("1", "park", 0, 0, 0d, 0d, 3, 4d, 5d);
        Park park6 = new Park("0", "a", 0, 0, 0d, 0d, 3, 4d, 5d);
        Park park7 = new Park("0", "park", 10, 0, 0d, 0d, 3, 4d, 5d);
        Park park8 = new Park("0", "park", 0, 10, 0d, 0d, 3, 4d, 5d);
        Park park9 = new Park("0", "park", 0, 0, 10, 0d, 3, 4d, 5d);
        Park park10 = new Park("0", "park", 0, 0, 0d, 10, 3, 4d, 5d);
        Park park11 = new Park("0", "park", 0, 0, 0d, 0d, 10, 4d, 5d);
        Park park12 = new Park("0", "park", 0, 0, 0d, 0d, 3, 10, 5d);
        Park park13 = new Park("0", "park", 0, 0, 0d, 0d, 3, 4d, 10);
        User user = new User();

        assertEquals(park1, park2);
        assertEquals(park2, park2);
        assertEquals(park4, park3);
        assertNotEquals(park1, park3);
        assertNotEquals(park4, park5);
        assertNotEquals(park4, park6);
        assertNotEquals(park4, park7);
        assertNotEquals(park4, park8);
        assertNotEquals(park4, park9);
        assertNotEquals(park4, park10);
        assertNotEquals(park4, park11);
        assertNotEquals(park4, park12);
        assertNotEquals(park4, park13);
        assertNotEquals(park1, null);
        assertNotEquals(park1, user);
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Park instance = new Park();
        int expResult = -196513505;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Park instance = setup();
        String expResult = "Park{idPark=0, description='park', maxCapacityScooters=10, maxCapacityBicycles=10, latitude=0.0, longitude=0.0, elevation=3, voltage=4.0, current=5.0}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testAvailablePlacesBicycle() {
        System.out.println("availablePlacesBicycle");
        Park instance = setup();
        Bicycle b6 = new Bicycle(1,"0", "bicycle6", 1, 2d, 3d, 0, false, 1);

        assertEquals(instance.availablePlacesBicycle(), 5);
        instance.addBicycle(b6);
        assertEquals(instance.availablePlacesBicycle(), 4);
    }

    @Test
    public void testAvailablePlacesScooter() {
        System.out.println("availablePlacesScooter");
        Park instance = setup();
        Scooter s6 = new Scooter(1,"0", "scooter6", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        
        assertEquals(5, instance.availablePlacesScooter());
        instance.addScooter(s6);
        assertEquals(4, instance.availablePlacesScooter());
    }

    @Test
    public void testAddBicycle() {
        System.out.println("addBicycle");

        Park park = new Park("0", "park", 0, 0, 0d, 0d, 3, 4d, 5d);

        Park instance = setup();
        Bicycle b6 = new Bicycle(1,"0", "bicycle6", 1, 2d, 3d, 0, false, 1);

        boolean result = instance.addBicycle(b6);
        assertEquals(true, result);

        result = park.addBicycle(b6);
        assertEquals(false, result);

    }

    @Test
    public void testAddScooter() {
        System.out.println("addScooter");
        Park park = new Park("0", "park", 0, 0, 0d, 0d, 3, 4d, 5d);
        Scooter s = new Scooter(1,"0", "scooter6", 1, ScooterType.CITY, 2d, 3d, 4d, 5d, false,1);
        Park instance = setup();

        boolean result = instance.addScooter(s);
        assertEquals(true, result);

        result = park.addScooter(s);
        assertEquals(false, result);
    }
}
