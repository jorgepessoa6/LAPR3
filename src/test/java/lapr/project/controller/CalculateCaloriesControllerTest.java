/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lapr.project.data.PathAPI;
import lapr.project.model.Path;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Diogo Soares
 */
public class CalculateCaloriesControllerTest {
    
    public CalculateCaloriesControllerTest() {
    }
    
    static private PathAPI pathAPI;
    static private ReportVehiclesNonBatteryToTravelController rv;
    
    private List<Path> list;
    private Path p1;
    private Path p2;
    private Path p3;

    
    @BeforeEach
    void setUp() {
       pathAPI= mock(PathAPI.class);
        
        
       p1= new Path(12,45.5,46.5,47.5,47.7,10,0,25.0);
       p2= new Path(12,45.5,46.5,47.5,47.7,10,0.5,25.0);
       p3= new Path(12,45.5,46.5,47.5,47.7,10,0.6,25.0);
       list = Arrays.asList(p1,p2,p3);
        
    }

    /**
     * Test of calculateCalories method, of class CalculateCaloriesController.
     */
    @Test
    public void testCalculateCalories() {
        System.out.println("calculateCalories");
        double velocidade = 30;
        double massaTotal =75;
        double inclinacao =0;
        double area = 0.5;
        double aerodynamic = 0.2;
        int tempoMinutos = 60;
        double distancia = 15;
        CalculateCaloriesController instance = new CalculateCaloriesController();
        Map <Path,Double> expResult = new HashMap<>();
        expResult.putIfAbsent(p1, 474.75);
        expResult.put(p2, 470.6184114638001);
        expResult.put(p3,468.85507700320164);
        Map<Path,Double> result = instance.calculateCalories(list,velocidade, massaTotal, inclinacao, area, aerodynamic, tempoMinutos, distancia);
        assertEquals(expResult, result);
    }
    
}
