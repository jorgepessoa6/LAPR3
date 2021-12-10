/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;

/**
 *
 * @author jorgi
 */
public class RouteEnergy {

    List<Location> route;
    private double energy;

    public RouteEnergy(List<Location> route, double energy) {
        this.route = route;
        this.energy = energy;
    }

    public List<Location> getRoute() {
        return route;
    }

    public void setRoute(List<Location> route) {
        this.route = route;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
