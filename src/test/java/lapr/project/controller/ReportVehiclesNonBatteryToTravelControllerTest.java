/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lapr.project.data.VehicleAPI;
import lapr.project.model.Scooter;
import lapr.project.model.ScooterType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Diogo Soares
 */
public class ReportVehiclesNonBatteryToTravelControllerTest {
    
    static private VehicleAPI vehicleAPI;
  
    
    private List<Scooter> list;
    private Scooter s1;
    private Scooter s2;
    private Scooter s3;
            
    
    
    public ReportVehiclesNonBatteryToTravelControllerTest() {
    }


     @BeforeEach
    void setUp() {
       vehicleAPI = mock(VehicleAPI.class);
       
        
        
       s1 = new Scooter(1,"parque1","scooter1",10,ScooterType.CITY,700,50,20,20,true,250);
       s2 = new Scooter(2,"parque2","scooter2",10,ScooterType.OFF_ROAD,700,50,20,20,true,400);
       s3=  new Scooter(3,"parque3","scooter3",10,ScooterType.OFF_ROAD,700,50,20,20,true,400);

       list = Arrays.asList(s1,s2,s3);
        
    }
    

    /**
     * Test of ReportVehiclesNonBatteryToTravel method, of class ReportVehiclesNonBatteryToTravelController.
     */
    @Test
    public void testReportVehiclesNonBatteryToTravel() {
        System.out.println("ReportVehiclesNonBatteryToTravel");
        
       
        when(vehicleAPI.getScooterByDesc(s1.getDescription())).thenReturn(s1);
        when(vehicleAPI.getScooterByDesc(s2.getDescription())).thenReturn(s2);
        when(vehicleAPI.getScooterByDesc(s3.getDescription())).thenReturn(s3);
         
        int km =20;
        ReportVehiclesNonBatteryToTravelController instance = new  ReportVehiclesNonBatteryToTravelController();
        List<Scooter> expResult = new ArrayList<>();
        expResult.add(s2);
        expResult.add(s3);
        List<Scooter> result = instance.ReportVehiclesNonBatteryToTravel(list, km);
        assertEquals(expResult, result);
    }    

    /**
     * Test of ReportVehiclesBatteryToTravel method, of class ReportVehiclesNonBatteryToTravelController.
     */
    @org.junit.Test
    public void testReportVehiclesBatteryToTravel() {
        System.out.println("ReportVehiclesNonBatteryToTravel");
        
       
        when(vehicleAPI.getScooterByDesc(s1.getDescription())).thenReturn(s1);
        when(vehicleAPI.getScooterByDesc(s2.getDescription())).thenReturn(s2);
        when(vehicleAPI.getScooterByDesc(s3.getDescription())).thenReturn(s3);
         
        int km =20;
        ReportVehiclesNonBatteryToTravelController instance = new ReportVehiclesNonBatteryToTravelController();
        List<Scooter> expResult = new ArrayList<>();
        expResult.add(s1);
        List<Scooter> result = instance.ReportVehiclesBatteryToTravel(list, km);
        assertEquals(expResult, result);
        
    }
    
}
