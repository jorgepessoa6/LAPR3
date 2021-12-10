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
 */
public class CalculateCaloriesTest {
    
    public CalculateCaloriesTest() {
    }
    

    /**
     * Test of calculateCalories method, of class CalculateCalories.
     */
    @Test
    public void testCalculateCalories() {
        System.out.println("calculateCalories");
        double velocidade = 0.0;
        double velocidadeVento = 0.0;
        int direcao = 0;
        int massaTotal = 0;
        int inclinacao = 0;
        double k1 = 0.0;
        double area = 0.0;
        double aerodynamic = 0.0;
        int tempoMinutos = 0;
        double distancia = 0.0;
        CalculateCalories instance = new CalculateCalories();
        double expResult = 0.0;
        double result = instance.calculateCalories(velocidade, velocidadeVento, direcao, massaTotal, inclinacao, k1, area, aerodynamic, tempoMinutos, distancia);
        assertEquals(expResult, result, 0.0);
    }
    
}
