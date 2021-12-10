/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author jorgi
 */
public class ParkForBST implements Comparable<ParkForBST> {

    Park park;
    private final double distance;

    public ParkForBST(Park park, double distance) {
        this.park = park;
        this.distance = distance;
    }

    public Park getPark() {
        return park;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ParkForBST parkForBST = (ParkForBST) o;
        return park == parkForBST.park
                && Double.compare(distance, parkForBST.distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(park, distance);
    }

    @Override
    public int compareTo(ParkForBST t) {
        if (this.distance > t.distance) {
            return 1;
        }
        return -1;
    }
}

