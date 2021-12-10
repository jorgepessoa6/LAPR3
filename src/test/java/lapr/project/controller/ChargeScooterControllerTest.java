/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Diogo Soares
 */
public class ChargeScooterControllerTest {
    
    public ChargeScooterControllerTest() {
    }
    
   

    /**
     * Test of chargeScooter method, of class ChargeScooterController.
     */
    @Test
    public void testChargeScooter() {
        System.out.println("chargeScooter");
        int tempo = 2;
        int battery = 0;
        int batteryMax = 1500;
        int numberScooters = 4;
        ChargeScooterController instance = new ChargeScooterController();
        int expResult = 100;
        int result = instance.chargeScooter(tempo, battery, batteryMax, numberScooters);
        assertEquals(expResult, result);
        battery=1700;
        expResult=-1;
        result = instance.chargeScooter(tempo, battery, batteryMax, numberScooters);
        assertEquals(expResult, result);
        tempo=1;
        battery=0;
        expResult = 58;
        result = instance.chargeScooter(tempo, battery, batteryMax, numberScooters);
        assertEquals(expResult, result);
    }
    
}
