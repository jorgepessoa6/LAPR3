package lapr.project.model;

import java.util.Objects;

/**
 * @author Jorge Pessoa
 */

public class Path {

    // Instance Variables
    //---------------------------------------------------------------------

    private int idPath;
    private double latitudeA;
    private double longitudeA;
    private double latitudeB;
    private double longitudeB;
    private double kineticCoefficient;
    private double windDirection;
    private double windSpeed;

    // Constructors
    //---------------------------------------------------------------------

    public Path(){
        // empty constructor
    }

    public Path(int idPath, double latitudeA, double longitudeA, double latitudeB, double longitudeB, double kineticCoefficient, double windDirection, double windSpeed) {
        this.idPath = idPath;
        this.latitudeA = latitudeA;
        this.longitudeA = longitudeA;
        this.latitudeB = latitudeB;
        this.longitudeB = longitudeB;
        this.kineticCoefficient = kineticCoefficient;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

    // Getters & Setters
    //---------------------------------------------------------------------

    public int getIdPath() {
        return idPath;
    }

    public void setIdPath(int idPath) {
        this.idPath = idPath;
    }

    public double getLatitudeA() {
        return latitudeA;
    }

    public void setLatitudeA(double latitudeA) {
        this.latitudeA = latitudeA;
    }

    public double getLongitudeA() {
        return longitudeA;
    }

    public void setLongitudeA(double longitudeA) {
        this.longitudeA = longitudeA;
    }

    public double getLatitudeB() {
        return latitudeB;
    }

    public void setLatitudeB(double latitudeB) {
        this.latitudeB = latitudeB;
    }

    public double getLongitudeB() {
        return longitudeB;
    }

    public void setLongitudeB(double longitudeB) {
        this.longitudeB = longitudeB;
    }

    public double getKineticCoefficient() {
        return kineticCoefficient;
    }

    public void setKineticCoefficient(double kineticCoefficient) {
        this.kineticCoefficient = kineticCoefficient;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    // Equals, hashCode & toString
    //---------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return idPath == path.idPath &&
                Double.compare(path.latitudeA, latitudeA) == 0 &&
                Double.compare(path.longitudeA, longitudeA) == 0 &&
                Double.compare(path.latitudeB, latitudeB) == 0 &&
                Double.compare(path.longitudeB, longitudeB) == 0 &&
                Double.compare(path.kineticCoefficient, kineticCoefficient) == 0 &&
                Double.compare(path.windDirection, windDirection) == 0 &&
                Double.compare(path.windSpeed, windSpeed) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPath, latitudeA, longitudeA, latitudeB, longitudeB, kineticCoefficient, windDirection, windSpeed);
    }

    @Override
    public String toString() {
        return "Path{" +
                "idPath=" + idPath +
                ", latitudeA=" + latitudeA +
                ", longitudeA=" + longitudeA +
                ", latitudeB=" + latitudeB +
                ", longitudeB=" + longitudeB +
                ", kineticCoefficient=" + kineticCoefficient +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
