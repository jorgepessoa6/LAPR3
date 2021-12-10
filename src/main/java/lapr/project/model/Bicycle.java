package lapr.project.model;

import java.util.Objects;

/**
 * @author Jorge Pessoa
 */

public class Bicycle extends Vehicle {

    // Instance Variables
    //---------------------------------------------------------------------

    private int bicycleType;
    private int wheelSize;

    // Constructors
    //---------------------------------------------------------------------

    public Bicycle(){
        // empty constructor
    }

    public Bicycle(int idVehicle,String idPark,String description, int weight, double aerodynamicCoefficient, double frontalArea, int bicycleType, boolean isActive, int wheelSize) {
        super(idVehicle,idPark,description,weight,aerodynamicCoefficient,frontalArea, isActive);
        this.bicycleType = bicycleType;
        this.wheelSize = wheelSize;
    }

    // Getters & Setters
    //---------------------------------------------------------------------

    public int getBicycleType() {
        return bicycleType;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setBicycleType(int bicycleType) {
        this.bicycleType = bicycleType;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    // Equals, hashCode & toString
    //---------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return  getIdVehicle() == bicycle.getIdVehicle() &&
                Objects.equals(getIdPark(), bicycle.getIdPark()) &&
                getWeight() == bicycle.getWeight() &&
                Double.compare(bicycle.getAerodynamicCoefficient(), getAerodynamicCoefficient()) == 0 &&
                Double.compare(bicycle.getFrontalArea(), getFrontalArea()) == 0 &&
                bicycleType == bicycle.bicycleType &&
                Objects.equals(getDescription(), bicycle.getDescription());
    }

    @Override
    public int hashCode() {
       return Objects.hash(getIdPark(), getDescription(), getWeight(),getAerodynamicCoefficient(), getFrontalArea(), bicycleType);
   }

    @Override
    public String toString() {
        return "Bicycle{" +
                "idVehicle=" + getIdVehicle() +
                ", idPark=" + getIdPark() +
                ", description='" + getDescription() + '\'' +
                ", weight=" + getWeight() +
                ", aerodynamicCoefficient=" + getAerodynamicCoefficient() +
                ", frontalArea=" + getFrontalArea() +
                ", bicycleType=" + bicycleType +
                ", wheel_size=" + wheelSize +
                '}';
    }
}
