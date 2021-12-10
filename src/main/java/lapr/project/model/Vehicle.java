package lapr.project.model;

import java.util.Objects;

public class Vehicle {

    // Instance Variables
    //---------------------------------------------------------------------
    private int idVehicle;
    private String idPark;
    private String description;
    private int weight;
    private double aerodynamicCoefficient;
    private double frontalArea;
    private boolean isActive;

    // Constructors
    //---------------------------------------------------------------------
    public Vehicle() {
        // empty constructor
    }

    public Vehicle(int idVehicle,String idPark, String description, int weight, double aerodynamicCoefficient, double frontalArea, boolean isActive) {
        this.idVehicle = idVehicle;
        this.idPark = idPark;
        this.description = description;
        this.weight = weight;
        this.aerodynamicCoefficient = aerodynamicCoefficient;
        this.frontalArea = frontalArea;
        this.isActive = isActive;
    }

    // Getters & Setters
    //---------------------------------------------------------------------

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getIdPark() {
        return idPark;
    }

    public void setIdPark(String idPark) {
        this.idPark = idPark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getAerodynamicCoefficient() {
        return aerodynamicCoefficient;
    }

    public void setAerodynamicCoefficient(double aerodynamicCoefficient) {
        this.aerodynamicCoefficient = aerodynamicCoefficient;
    }

    public double getFrontalArea() {
        return frontalArea;
    }

    public void setFrontalArea(double frontalArea) {
        this.frontalArea = frontalArea;
    }
    

    // Equals, hashCode & toString
    //---------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vehicle vehicle = (Vehicle) o;
        return  idVehicle == vehicle.idVehicle 
                && Objects.equals(idPark, vehicle.idPark)
                && weight == vehicle.weight
                && isActive == vehicle.isActive
                && Double.compare(vehicle.aerodynamicCoefficient, aerodynamicCoefficient) == 0
                && Double.compare(vehicle.frontalArea, frontalArea) == 0
                && Objects.equals(description, vehicle.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPark, description, weight,aerodynamicCoefficient, frontalArea,isActive);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "idVehicle=" + getIdVehicle()
                + ", idPark=" + idPark
                + ", description='" + description + '\''
                + ", weight=" + weight
                + ", aerodynamicCoefficient=" + aerodynamicCoefficient
                + ", frontalArea=" + frontalArea
                + ", isActive=" + isActive
                + '}';
    }
}
