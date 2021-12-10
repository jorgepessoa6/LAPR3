package lapr.project.model;

import java.util.Objects;

/**
 * @author Jorge Pessoa
 */

public class Scooter extends Vehicle {

    // Instance Variables
    //---------------------------------------------------------------------

    private ScooterType type;
    private double maxBattery;
    private double actualBattery;
    private int motor;

    // Constructors
    //---------------------------------------------------------------------

    public Scooter(){
        // empty constructor
    }

    public Scooter(int idVehicle,String idPark, String description, int weight, ScooterType type, double maxBattery, double actualBattery, double aerodynamicCoefficient, double frontalArea, boolean isActive, int motor) {
        super(idVehicle,idPark,description,weight,aerodynamicCoefficient,frontalArea, isActive);
        this.type = type;
        this.maxBattery = maxBattery;
        this.actualBattery = actualBattery;
        this.motor = motor;
    }

    // Getters & Setters
    //---------------------------------------------------------------------

    public ScooterType getType() {
        return type;
    }

    public void setType(String type) {
        switch (type.toUpperCase()) {
            case "OFF-ROAD":
                this.type = ScooterType.OFF_ROAD;
                break;
            default:
                this.type = ScooterType.CITY;
        }
    }

    public double getMaxBattery() {
        return maxBattery;
    }

    public void setMaxBattery(double maxBattery) {
        this.maxBattery = maxBattery;
    }

    public Double getActualBattery() {
        return actualBattery;
    }

    public void setActualBattery(double actualBattery) {
        this.actualBattery = actualBattery;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }
    

    // Equals, hashCode & toString
    //---------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return  getIdVehicle() == scooter.getIdVehicle() &&
                Objects.equals(getIdPark(), scooter.getIdPark()) &&
                Double.compare(scooter.getWeight(), getWeight()) == 0 &&
                Double.compare(scooter.maxBattery, maxBattery) == 0 &&
                Double.compare(scooter.actualBattery, actualBattery) == 0 &&
                Double.compare(scooter.getAerodynamicCoefficient(), getAerodynamicCoefficient()) == 0 &&
                Double.compare(scooter.getFrontalArea(), getFrontalArea()) == 0 &&
                Objects.equals(getDescription(), scooter.getDescription()) &&
                //getIsActive() == scooter.getIsActive() &&
                type == scooter.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPark(), getDescription(), getWeight(), type, maxBattery, actualBattery, getAerodynamicCoefficient(), getFrontalArea());
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "idVehicle=" + getIdVehicle() +
                ", idPark=" + getIdPark() +
                ", description='" + getDescription() + '\'' +
                ", weight=" + getWeight() +
                ", type=" + type +
                ", maxBattery=" + maxBattery +
                ", actualBattery=" + actualBattery +
                ", aerodynamicCoefficient=" + getAerodynamicCoefficient() +
                ", frontalArea=" + getFrontalArea() +
                '}';
    }
}
