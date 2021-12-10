/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Francisco Ferreira
 */
public class ReportTest {


    /**
     * Test of loadEstimate method, of class Report.
     */
    @Test
    public void testLoadEstimate() {
        System.out.println("loadEstimate");
        int battery = 10;
        int batteryMax = 20;
        int numberScooters = 3;
        double expResult = 30.690536499023438;
        double result = Report.loadEstimate(battery, batteryMax, numberScooters);
        System.out.println (result);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getNumUnloadedScooters method, of class Report.
     */
    @Test
    public void testGetNumUnloadedScooters() {
        System.out.println("getNumUnloadedScooters");
        Map<String, Double> map_cods = new HashMap<>();
        map_cods.put("abc",100.0);
        map_cods.put("abcd",89.0);
        map_cods.put("abcde",91.5);
        Report instance = new Report();
        long expResult = 2L;
        long result = instance.getNumUnloadedScooters(map_cods);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of writeReport method, of class Report.
//     */
//    @Test
//    public void testWriteReport() {
//        System.out.println("writeReport");
//        String outputFile = "";
//        Report instance = new Report();
//        instance.writeReport(outputFile);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }


    /**
     * Test of constructOutputFile method, of class Report.
     */
    @Test
    public void testConstructOutputFile() {
        System.out.println("constructOutputFile");
        String outputFileName = "flieTest.csv";
        List<Double> loadEstim = new ArrayList<>();
        loadEstim.add(12.12);
        loadEstim.add(23.24);
        
        Map<String, Double> map_cods = new HashMap<>();
        map_cods.put("desc1",100.00);
        map_cods.put("desc2", 81.70);
        
        List<String> eTypes = new ArrayList<>();
        eTypes.add("off-road");
        eTypes.add("city");
        
        Report instance = new Report();
        long expResult = 1L;
        long result = instance.constructOutputFile(outputFileName, loadEstim, map_cods, eTypes);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of converterDoubleDoisDecimais method, of class Report.
//     */
//    @Test
//    public void testConverterDoubleDoisDecimais() {
//        System.out.println("converterDoubleDoisDecimais");
//        double precoDouble = 12.2345;
//        double expResult = 12.23;
//        double result = Report.converterDoubleDoisDecimais(precoDouble);
//        assertEquals(expResult, result, 0.0);
//    }
//
//    /**
//     * Test of constructPointsReport method, of class Report.
//     */
//    @Test
//    public void testConstructPointsReport() {
//        System.out.println("constructPointsReport");
//        String outputFileName = "testFile1.csv";
//        String vehicle_desc = "desc1";
//        int vehicleUnlockTime = 12;
//        int vehicleLockTime = 10;
//        float latitude = 42.333F;
//        float longitude = 45.123F;
//        int elevation = 356;
//        float latitudeEnd = 25.23212F;
//        float longitudeEnd = 25.2321F;
//        int elevationEnd = 567;
//        int elevationDifference = 211;
//        int points = 20;
//        Report instance = new Report();
//        int expResult = 0;
//        int result = instance.constructPointsReport(outputFileName, vehicle_desc, vehicleUnlockTime, vehicleLockTime, latitude, longitude, elevation, latitudeEnd, longitudeEnd, elevationEnd, elevationDifference, points);
//        assertEquals(expResult, result);
//    }
    
}
