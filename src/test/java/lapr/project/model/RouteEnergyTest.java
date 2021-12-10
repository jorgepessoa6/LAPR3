/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author jorgi
 */
public class RouteEnergyTest {

    /**
     * Test of getRoute method, of class RouteEnergy.
     */
    @Test
    public void testGetRoute() {
        System.out.println("getRoute");
        List<Location> expResult = new ArrayList<>();
        RouteEnergy instance = new RouteEnergy(expResult, 10);
        List<Location> result = instance.getRoute();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRoute method, of class RouteEnergy.
     */
    @Test
    public void testSetRoute() {
        System.out.println("setRoute");
        List<Location> expResult = new ArrayList<>();
        List<Location> route = new ArrayList<>();
        RouteEnergy instance = new RouteEnergy(expResult, 10);
        instance.setRoute(route);
    }

    /**
     * Test of getEnergy method, of class RouteEnergy.
     */
    @Test
    public void testGetEnergy() {
        System.out.println("getEnergy");
        List<Location> route = new ArrayList<>();
        RouteEnergy instance = new RouteEnergy(route, 0.0);
        double expResult = 0.0;
        double result = instance.getEnergy();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of setEnergy method, of class RouteEnergy.
     */
    @Test
    public void testSetEnergy() {
        System.out.println("setEnergy");
        List<Location> route = new ArrayList<>();
        RouteEnergy instance = new RouteEnergy(route, 0.0);
        double energy = 10;
        instance.setEnergy(energy);
    }
}
