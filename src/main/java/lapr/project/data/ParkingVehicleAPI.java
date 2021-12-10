package lapr.project.data;

import lapr.project.controller.*;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import lapr.project.data.DataHandler;
import lapr.project.model.Park;

public class ParkingVehicleAPI extends DataHandler {

    public boolean parkVehicle(int cod_request, double latitude, double longitude) {
        boolean parked = false;
        try {
            String sqlUpdate = "UPDATE trips SET end_date = ?, latitude_end = ?, longitude_end = ? WHERE cod_trip = ?";
            PreparedStatement ps = getConnection().prepareStatement(sqlUpdate);

            Timestamp t = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(1, t);
            ps.setDouble(2, latitude);
            ps.setDouble(3, longitude);
            ps.setInt(4, cod_request);
            int result = ps.executeUpdate();

           ParkAPI papi = new ParkAPI();
           Park p = papi.getParkByCoord(latitude, longitude);

            if (p != null) {
                parked = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parked;
    }
}
