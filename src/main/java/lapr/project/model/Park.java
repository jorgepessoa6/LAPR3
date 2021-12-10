package lapr.project.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Jorge Pessoa
 */
public class Park extends Location {

    // Instance Variables
    //---------------------------------------------------------------------
    private String idPark;
    private String description;
    private int maxCapacityScooters;
    private int maxCapacityBicycles;
    private double voltage;
    private double current;
    private final Set<Bicycle> listBicycles = new HashSet<>();
    private final Set<Scooter> listScooters = new HashSet<>();

    // Constructors
    //---------------------------------------------------------------------
    public Park() {
        // empty constructor
    }

    /**
     * Constructs a new park
     *
     * @param idPark the id of the park
     * @param description the description of the park
     * @param maxCapacityScooters the maximum capacity for scooters of the park
     * @param maxCapacityBicycles the maximum capacity for bicycles of the park
     * @param latitude the latitude of the park
     * @param longitude the longitude of the park
     * @param elevation the elevation of the park
     * @param voltage the voltage of the park (Volts (V))
     * @param current the current of the park (Amperes (A))
     */
    public Park(String idPark, String description, int maxCapacityScooters, int maxCapacityBicycles, double latitude, double longitude, int elevation, double voltage, double current) {
        super(latitude, longitude, elevation);
        this.idPark = idPark;
        this.description = description;
        this.maxCapacityScooters = maxCapacityScooters;
        this.maxCapacityBicycles = maxCapacityBicycles;
        this.voltage = voltage;
        this.current = current;
    }

    // Getters & Setters
    //---------------------------------------------------------------------
    public Set<Bicycle> getListBicycles() {
        return listBicycles;
    }

    public Set<Scooter> getListScooters() {
        return listScooters;
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

    public int getMaxCapacityScooters() {
        return maxCapacityScooters;
    }

    public void setMaxCapacityScooters(int maxCapacityScooters) {
        this.maxCapacityScooters = maxCapacityScooters;
    }

    public int getMaxCapacityBicycles() {
        return maxCapacityBicycles;
    }

    public void setMaxCapacityBicycles(int maxCapacityBicycles) {
        this.maxCapacityBicycles = maxCapacityBicycles;
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public double getCurrent() {
        return current;
    }

    public void setCurrent(double current) {
        this.current = current;
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
        Park park = (Park) o;
        return Objects.equals(idPark, park.idPark)
                && maxCapacityScooters == park.maxCapacityScooters
                && maxCapacityBicycles == park.maxCapacityBicycles
                && Double.compare(park.getLatitude(), getLatitude()) == 0
                && Double.compare(park.getLongitude(), getLongitude()) == 0
                && getElevation() == park.getElevation()
                && Double.compare(park.voltage, voltage) == 0
                && Double.compare(park.current, current) == 0
                && Objects.equals(description, park.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPark, description, maxCapacityScooters, maxCapacityBicycles, getLatitude(), getLongitude(), getElevation(), voltage, current);
    }

    @Override
    public String toString() {

        return "Park{"
                + "idPark=" + idPark
                + ", description='" + description + '\''
                + ", maxCapacityScooters=" + maxCapacityScooters
                + ", maxCapacityBicycles=" + maxCapacityBicycles
                + ", latitude=" + getLatitude()
                + ", longitude=" + getLongitude()
                + ", elevation=" + getElevation()
                + ", voltage=" + voltage
                + ", current=" + current
                + '}';
    }

    public int availablePlacesBicycle() {
        return maxCapacityBicycles - listBicycles.size();
    }

    public int availablePlacesScooter() {
        return maxCapacityScooters - listScooters.size();
    }

    public boolean addBicycle(Bicycle b) {
        if (availablePlacesBicycle() > 0) {
            listBicycles.add(b);
            return true;
        }
        return false;
    }

    public boolean addScooter(Scooter s) {
        if (availablePlacesScooter() > 0) {
            listScooters.add(s);
            return true;
        }
        return false;
    }
}
