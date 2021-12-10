/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Diogo Soares
 */
public class CalculateCalories {

    
   
    public double calculateCalories(double velocidade, double velocidadeVento, double direcao, double massaTotal, double inclinacao, double k1, double area, double aerodynamic, int tempoMinutos, double distancia) {
        double k2=0.5*area*aerodynamic*distancia;
        double potencia=(9.8*massaTotal*(k1+inclinacao))+(k2*(velocidadeVento)*velocidade*Math.cos(direcao));
        double calorias= (potencia*((double)(tempoMinutos)/(60*60))*3.6);
        if (calorias>0) return calorias;
    return 0;}
   
}


