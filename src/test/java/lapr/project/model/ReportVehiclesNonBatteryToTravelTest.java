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
 * @author Diogo Soares
 *
 */
public class ReportVehiclesNonBatteryToTravelTest {
    
    public ReportVehiclesNonBatteryToTravelTest() {
    }
    
    

    /**
     * Test of ReportVehiclesNonBatteryToTravel method, of class ReportVehiclesNonBatteryToTravel.
     */
    @Test
    public void testReportVehiclesNonBatteryToTravel() {
        System.out.println("ReportVehiclesNonBatteryToTravel");
        Scooter s = new Scooter(1,"parque","scooter",10,ScooterType.CITY,700,50,20,20,true,250);
        int km = 20;
        ReportVehiclesNonBatteryToTravel instance = new ReportVehiclesNonBatteryToTravel();
        boolean expResult =false;
        boolean result = instance.ReportVehiclesNonBatteryToTravel(s, km);
        assertEquals(expResult, result);
        s.setMotor(400);
        expResult =true;
        result = instance.ReportVehiclesNonBatteryToTravel(s, km);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of ReportVehiclesBatteryToTravel method, of class ReportVehiclesNonBatteryToTravel.
     */
    @org.junit.Test
    public void testReportVehiclesBatteryToTravel() {
        System.out.println("ReportVehiclesBatteryToTravel");
        Scooter s = new Scooter(1,"parque","scooter",10,ScooterType.CITY,700,50,20,20,true,250);
        int km = 20;
        ReportVehiclesNonBatteryToTravel instance = new ReportVehiclesNonBatteryToTravel();
        boolean expResult =true;
        boolean result = instance.ReportVehiclesBatteryToTravel(s, km);
        assertEquals(expResult, result);
        s.setMotor(400);
        expResult =false;
        result = instance.ReportVehiclesNonBatteryToTravel(s, km);
        assertEquals(expResult, result);
    }
    
}
