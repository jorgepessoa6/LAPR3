/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Francisco Ferreira
 */
public class CalculateTripCostTest {
    
    /**
     * Test of calculateCost method, of class CalculateTripCost.
     */
    @Test
    public void testCalculateCost() throws ParseException {
        System.out.println("calculateCost");
        String stringDateS = "2019-06-18 09:12:00";
        String stringDateE = "2019-06-18 09:56:00";
        Date sDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDateS);
        Date eDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(stringDateE);
        CalculateTripCost instance = new CalculateTripCost();
        double expResult = 0.0;
        double result = instance.calculateCost(sDate, eDate);
        System.out.println (result);
        assertEquals(expResult, result, 0.5);
    }
    
}
