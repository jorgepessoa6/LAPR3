/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.controller.AssignPointsController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Francisco Ferreira
 */
public class AssignPointsTest {

    /**
     * Test of calculateElevationDifference method, of class AssignPoints.
     */
    @Test
    public void testCalculateElevationDifference() {
        System.out.println("calculateElevationDifference");
        Integer elOne = 200;
        Integer elTwo = 348;
        AssignPointsController instance = new AssignPointsController();
        Integer expResult = 148;
        Integer result = instance.calculateElevationDifference(elOne, elTwo);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculateTripTime method, of class AssignPoints.
     */
    @Test
    public void testCalculateTripTime() throws ParseException {
        System.out.println("calculateTripTime");
        String stringDateS = "2019-06-18 09:12:00";
        String stringDateE = "2019-06-18 09:56:00";
        Date sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDateS);
        Date eDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDateE);
        AssignPointsController instance = new AssignPointsController();
        double expResult = 44.0;
        double result = instance.calculateTripTime(sDate, eDate);
        assertEquals(expResult, result, 0.5);
    }

}
