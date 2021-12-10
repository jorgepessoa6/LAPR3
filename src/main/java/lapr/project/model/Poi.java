package lapr.project.model;

import java.util.Objects;

/**
 * @author Jorge Pessoa
 */
public class Poi extends Location {

    // Instance Variables
    //---------------------------------------------------------------------
    private String description;

    // Constructors
    //---------------------------------------------------------------------
    public Poi() {
        //empty constructor
    }

    public Poi(double latitude, double longitude, int elevation, String description) {
        super(latitude, longitude, elevation);
        this.description = description;
    }

    // Getters & Setters
    //---------------------------------------------------------------------
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        Poi that = (Poi) o;
        return Double.compare(that.getLatitude(), getLatitude()) == 0
                && Double.compare(that.getLongitude(), getLongitude()) == 0
                && getElevation() == that.getElevation()
                && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLatitude(), getLongitude(), getElevation(), description);
    }

    @Override
    public String toString() {
        return "PointOfInterest{"
                + ", latitude=" + getLatitude()
                + ", longitude=" + getLongitude()
                + ", elevation=" + getElevation()
                + ", description='" + description + '\''
                + '}';
    }
}
