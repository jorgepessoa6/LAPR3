/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lapr.project.data.PathAPI;
import lapr.project.model.CalculateCalories;
import lapr.project.model.Path;



/**
 *
 * @author Diogo Soares
 */
public class CalculateCaloriesController {


    private final CalculateCalories calculateCalories;
    private final PathAPI pathAPI;
            
    /**
     *
     */
    

    public CalculateCaloriesController() {
        calculateCalories= new CalculateCalories();
        this.pathAPI=new PathAPI();
    }

    public CalculateCaloriesController(PathAPI pathAPI) {
        this.pathAPI = pathAPI;
        this.calculateCalories=new CalculateCalories();
    }
    
    
     public Map<Path,Double> calculateCalories(List<Path> list,double velocidade,double massaTotal, double inclinacao, double area, double aerodynamic, int tempoMinutos, double distancia){
        Map<Path,Double> mapa= new HashMap<>();
        double calories=0;
        for(Path p: list){
            calories=calculateCalories.calculateCalories(velocidade, p.getWindSpeed(), p.getWindDirection(), massaTotal, inclinacao, p.getKineticCoefficient(), area, aerodynamic, tempoMinutos, distancia);
            System.out.println(calories);
            mapa.put(p,calories);
        }
    return mapa;}
        
    
}