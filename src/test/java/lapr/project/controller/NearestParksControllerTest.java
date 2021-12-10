package lapr.project.controller;

import lapr.project.model.Park;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.ParkForBST;
import lapr.project.utils.Utils;

import static org.junit.jupiter.api.Assertions.*;

class NearestParksControllerTest {

    @Test
    void getNearestParks() {
        double userLatitude = 40.41;
        double userLongitude = -3.70;
        int range = 1000;
        Park park1 = new Park("1", "park", 0, 0, 38.70, -9.13, 3, 4d, 5d);
        Park park2 = new Park("0", "park", 0, 0, -34.61, -58.37, 3, 4d, 5d);
        List<Park> parks = new ArrayList<>();
        List<Park> parks2 = new ArrayList<>();
        List<Park> parks3 = new ArrayList<>();
        parks.add(park1);
        parks.add(park2);
        parks2.add(park2);
        parks2.add(park1);
        parks3.add(park1);
        NearestParksController nearestParksController = new NearestParksController();
        List<Park> listParks = nearestParksController.getNearestParks(userLatitude, userLongitude, range, parks);
        List<Park> listParks2 = nearestParksController.getNearestParks(userLatitude, userLongitude, range, parks2);
        assertEquals(parks3, listParks);
        assertNotEquals(parks, listParks);
        assertEquals(listParks, listParks2);
    }

    @Test
    void addNearestPark() {
        double userLatitude = 40.41;
        double userLongitude = -3.70;
        NearestParksController nearestParksController = new NearestParksController();
        int range = 1000;
        Park park1 = new Park("1", "park", 0, 0, 38.70, -9.13, 3, 4d, 5d);
        Park park2 = new Park("0", "park", 0, 0, -34.61, -58.37, 3, 4d, 5d);
        List<Park> parks = new ArrayList<>();
        int dist = (int) Utils.distance(userLatitude, park1.getLatitude(), userLongitude, park1.getLongitude());
        ParkForBST parkForBST = new ParkForBST(park1, dist);
        ParkForBST parkForBST2 = new ParkForBST(park2, Utils.distance(userLatitude, park2.getLatitude(), userLongitude, park2.getLongitude()));
        nearestParksController.addNearestPark(parkForBST, range, parks);
        nearestParksController.addNearestPark(parkForBST, dist, parks);
        nearestParksController.addNearestPark(parkForBST2, range, parks);
        assertTrue(parks.contains(park1));
        assertFalse(parks.contains(park2));
    }
}
