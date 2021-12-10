package lapr.project.model;

import java.util.Objects;

/**
 * @author Jorge Pessoa
 */
public class Trip {

    // Instance Variables
    //---------------------------------------------------------------------
    private int idTrip;
    private String idVehicle;
    private String email;
    private String idStartPark;
    private double latitudeEnd;
    private double longitudeEnd;
    private String timestampStart;
    private String timestampFinish;

    // Constructors
    //---------------------------------------------------------------------
    public Trip() {
        //empty constructor
    }

    public Trip(int idTrip, String idVehicle, String email, String idStartPark, double latitudeEnd, double longitudeEnd, String timestampStart, String timestampFinish) {
        this.idTrip = idTrip;
        this.idVehicle = idVehicle;
        this.email = email;
        this.idStartPark = idStartPark;
        this.latitudeEnd = latitudeEnd;
        this.longitudeEnd = longitudeEnd;
        this.timestampStart = timestampStart;
        this.timestampFinish = timestampFinish;
    }

    // Getters & Setters
    //---------------------------------------------------------------------
    public int getIdTrip() {
        return idTrip;
    }

    public void setIdTrip(int idTrip) {
        this.idTrip = idTrip;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdStartPark() {
        return idStartPark;
    }

    public void setIdStartPark(String idStartPark) {
        this.idStartPark = idStartPark;
    }

    public double getLatitudeEnd() {
        return latitudeEnd;
    }

    public void setLatitudeEnd(double latitudeEnd) {
        this.latitudeEnd = latitudeEnd;
    }

    public double getLongitudeEnd() {
        return longitudeEnd;
    }

    public void setLongitudeEnd(double longitudeEnd) {
        this.longitudeEnd = longitudeEnd;
    }

    public String getTimestampStart() {
        return timestampStart;
    }

    public void setTimestampStart(String timestampStart) {
        this.timestampStart = timestampStart;
    }

    public String getTimestampFinish() {
        return timestampFinish;
    }

    public void setTimestampFinish(String timestampFinish) {
        this.timestampFinish = timestampFinish;
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
        Trip trip = (Trip) o;
        return idTrip == trip.idTrip
                && idVehicle == trip.idVehicle
                && Objects.equals(idStartPark, trip.idStartPark)
                && latitudeEnd == trip.latitudeEnd
                && longitudeEnd == trip.longitudeEnd
                && Objects.equals(email, trip.email)
                && Objects.equals(timestampStart, trip.timestampStart)
                && Objects.equals(timestampFinish, trip.timestampFinish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrip, idVehicle, email, idStartPark, timestampStart, timestampFinish);
    }

    @Override
    public String toString() {
        return "Trip{"
                + "idTrip=" + idTrip
                + ", idVehicle=" + idVehicle
                + ", email='" + email + '\''
                + ", idStartPark=" + idStartPark
                + ", latitudeEnd=" + latitudeEnd
                + ", longitudeEnd=" + longitudeEnd
                + ", timestampStart=" + timestampStart
                + ", timestampFinish=" + timestampFinish
                + '}';
    }
}
