/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lapr.project.data.ParkAPI;
import lapr.project.data.PointOfInterestAPI;
import lapr.project.graph.Graph;
import lapr.project.model.Location;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.Poi;
import lapr.project.model.RouteEnergy;
import lapr.project.model.User;
import lapr.project.utils.Utils;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author jorgi
 */
public class EnergyEfficientRouteControllerTest {

    static private ParkAPI parkAPI;
    static private PointOfInterestAPI pointOfInterestAPI;
    static private EnergyEfficientRouteController energyEfficientRouteController;
    
    private List<Park> listParks;
    private Park park1;
    private Park park2;
    private Park park3;
    
    private List<Poi> listPois;
    private Poi poi1;
    private Poi poi2;


    public EnergyEfficientRouteControllerTest() {
    }

    @BeforeEach
    void setUp() {
        parkAPI = mock(ParkAPI.class);
        pointOfInterestAPI = mock(PointOfInterestAPI.class);
        energyEfficientRouteController = new EnergyEfficientRouteController(parkAPI, pointOfInterestAPI);
        
        park1 = new Park("idPark", "description", 10, 10, 10, 10, 20, 10, 10);
        park2 = new Park("idPark1", "description", 10, 10, 20, 20, 30, 10, 10);
        park3 = new Park("idPark2", "description", 10, 10, 30, 30, 40, 10, 10);

        listParks = Arrays.asList(park1, park2, park3);
        
        poi1 = new Poi(50, 50, 50, "description");
        poi2 = new Poi(60, 60, 60, "description1");
        
        listPois = Arrays.asList(poi1, poi2);
    }

    /**
     * Test of mostEnergyEfficientRouteBetweenTwoParks method, of class
     * EnergyEfficientRouteController.
     */
    @Test
    public void testMostEnergyEfficientRouteBetweenTwoParks() {
        System.out.println("mostEnergyEfficientRouteBetweenTwoParks");
        
        User user = new User("email", "username", 180, 70, 0, "F", 10, 10, "password");
        
        Path path = new Path(1, 10, 10, 20, 20, 0.5, 1, 10);
        Path path2 = new Path(2, 20, 20, 30, 30, 0.5, 1, 10);
        List<Path> paths = new LinkedList<>();
        paths.add(path);
        paths.add(path2);
        
        when(parkAPI.getParkByCoord(park1.getLatitude(), park1.getLongitude())).thenReturn(park1);
        when(parkAPI.getParkByCoord(park2.getLatitude(), park2.getLongitude())).thenReturn(park2);
        when(parkAPI.getParkByCoord(park3.getLatitude(), park3.getLongitude())).thenReturn(park3);
        when(pointOfInterestAPI.getPoiByCoord(poi1.getLatitude(), poi1.getLongitude())).thenReturn(poi1);
        when(pointOfInterestAPI.getPoiByCoord(poi2.getLatitude(), poi2.getLongitude())).thenReturn(poi2);

        RouteEnergy result = energyEfficientRouteController.mostEnergyEfficientRouteBetweenTwoParks(parkAPI.getParkByCoord(10, 10), parkAPI.getParkByCoord(30, 30), user, paths);
        assertEquals(result.getEnergy(), 389292.0123544655, 0.0);
    }

    @Test
    public void testMostEnergyEfficientRouteBetweenTwoParksWithPois() {
        System.out.println("mostEnergyEfficientRouteBetweenTwoParksWithPois");
        
        User user = new User("email", "username", 180, 70, 0, "F", 10, 10, "password");
        when(parkAPI.getParkByCoord(park1.getLatitude(), park1.getLongitude())).thenReturn(park1);
        when(parkAPI.getParkByCoord(park2.getLatitude(), park2.getLongitude())).thenReturn(park2);
        when(parkAPI.getParkByCoord(park3.getLatitude(), park3.getLongitude())).thenReturn(park3);
        when(pointOfInterestAPI.getPoiByCoord(poi1.getLatitude(), poi1.getLongitude())).thenReturn(poi1);
        when(pointOfInterestAPI.getPoiByCoord(poi2.getLatitude(), poi2.getLongitude())).thenReturn(poi2);
        

        List<Location> listPoi = new LinkedList<>();
        listPoi.add(poi1);
        Path path = new Path(1, 10, 10, 20, 20, 0.5, 1, 10);
        Path path2 = new Path(2, 20, 20, 50, 50, 0.5, 1, 10);
        Path path3 = new Path(3, 50, 50, 60, 60, 0.5, 1, 10);
        Path path4 = new Path(4, 50, 50, 30, 30, 0.5, 1, 10);
        Path path5 = new Path(5, 60, 60, 30, 30, 0.5, 1, 10);
        Path path6 = new Path(6, 100, 100, 200, 200, 0.5, 1, 10);
        Path path7 = new Path(7, 100, 100, 30, 30, 0.5, 1, 10);
        List<Path> paths = new LinkedList<>();
        paths.add(path);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);
        paths.add(path6);
        paths.add(path7);
        List<Location> exp = new LinkedList<>();
        exp.add(park1);
        exp.add(park2);
        exp.add(poi1);
        exp.add(park3);
        
        List<RouteEnergy> result = energyEfficientRouteController.mostEnergyEfficientRouteBetweenTwoParksWithPois(parkAPI.getParkByCoord(10, 10), parkAPI.getParkByCoord(30, 30), user, paths, listPoi, 1, "ascending");
        List<RouteEnergy> result2 = energyEfficientRouteController.mostEnergyEfficientRouteBetweenTwoParksWithPois(parkAPI.getParkByCoord(10, 10), parkAPI.getParkByCoord(30, 30), user, paths, listPoi, 1, "AscEnding");
        List<RouteEnergy> result1 = energyEfficientRouteController.mostEnergyEfficientRouteBetweenTwoParksWithPois(parkAPI.getParkByCoord(10, 10), parkAPI.getParkByCoord(30, 30), user, paths, listPoi, 1, "descending");
        assertEquals(result.get(0).getEnergy(), 1119105.8089400283, 0.0);
        assertEquals(result.get(0).getRoute(), exp);
        assertEquals(result1.get(0).getEnergy(), 1119105.8089400283, 0.0);
        assertEquals(result1.get(0).getRoute(), exp);
        assertEquals(result.get(0).getEnergy(), result2.get(0).getEnergy());
        assertEquals(result.get(0).getRoute(), result2.get(0).getRoute());
    }

    @Test
    public void testCreateGraph() {
        System.out.println("createGraph");
        User user = new User("email", "username", 180, 70, 0, "F", 10, 10, "password");

        when(parkAPI.getParkByCoord(park1.getLatitude(), park1.getLongitude())).thenReturn(park1);
        when(parkAPI.getParkByCoord(park2.getLatitude(), park2.getLongitude())).thenReturn(park2);
        when(parkAPI.getParkByCoord(park3.getLatitude(), park3.getLongitude())).thenReturn(park3);
        when(pointOfInterestAPI.getPoiByCoord(poi1.getLatitude(), poi1.getLongitude())).thenReturn(poi1);
        when(pointOfInterestAPI.getPoiByCoord(poi2.getLatitude(), poi2.getLongitude())).thenReturn(poi2);

        Path path = new Path(1, 10, 10, 20, 20, 0.5, 1, 10);
        Path path2 = new Path(2, 20, 20, 50, 50, 0.5, 1, 10);
        Path path3 = new Path(2, 50, 50, 60, 60, 0.5, 1, 10);
        Path path4 = new Path(2, 50, 50, 30, 30, 0.5, 1, 10);
        Path path5 = new Path(2, 60, 60, 30, 30, 0.5, 1, 10);

        List<Path> paths = new LinkedList<>();
        paths.add(path);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);

        Graph<Location, Double> graph = new Graph<>(true);
        graph.insertVertex(park1);
        graph.insertVertex(park2);
        graph.insertVertex(park3);
        graph.insertVertex(poi1);
        graph.insertVertex(poi2);
        graph.insertEdge(park1, park2, Utils.calculateEnergy(park1, park2, path, user), Utils.calculateEnergy(park1, park2, path, user));
        graph.insertEdge(park2, poi1, Utils.calculateEnergy(park2, poi1, path2, user), Utils.calculateEnergy(park2, poi1, path2, user));
        graph.insertEdge(poi1, poi2, Utils.calculateEnergy(poi1, poi2, path3, user), Utils.calculateEnergy(poi1, poi2, path3, user));
        graph.insertEdge(poi1, park3, Utils.calculateEnergy(poi1, park3, path4, user), Utils.calculateEnergy(poi1, park3, path4, user));
        graph.insertEdge(poi2, park3, Utils.calculateEnergy(poi2, park3, path5, user), Utils.calculateEnergy(poi2, park3, path5, user));

        assertEquals(energyEfficientRouteController.createGraph(user, paths), graph);
    }

    @Test
    public void testGetShortestsPathByList() {
        System.out.println("getShortestsPathByList");
        
        User user = new User("email", "username", 180, 70, 0, "F", 10, 10, "password");

        when(parkAPI.getParkByCoord(park1.getLatitude(), park1.getLongitude())).thenReturn(park1);
        when(parkAPI.getParkByCoord(park2.getLatitude(), park2.getLongitude())).thenReturn(park2);
        when(parkAPI.getParkByCoord(park3.getLatitude(), park3.getLongitude())).thenReturn(park3);
        when(pointOfInterestAPI.getPoiByCoord(poi1.getLatitude(), poi1.getLongitude())).thenReturn(poi1);
        when(pointOfInterestAPI.getPoiByCoord(poi2.getLatitude(), poi2.getLongitude())).thenReturn(poi2);

        Path path = new Path(1, 10, 10, 20, 20, 0.5, 1, 10);
        Path path2 = new Path(2, 20, 20, 50, 50, 0.5, 1, 10);
        Path path3 = new Path(2, 50, 50, 60, 60, 0.5, 1, 10);
        Path path4 = new Path(2, 50, 50, 30, 30, 0.5, 1, 10);
        Path path5 = new Path(2, 60, 60, 30, 30, 0.5, 1, 10);

        List<Path> paths = new LinkedList<>();
        paths.add(path);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);

        List<Location> listPoi = new LinkedList<>();
        listPoi.add(poi1);

        List<Location> exp = new LinkedList<>();
        exp.add(park1);
        exp.add(park2);
        exp.add(poi1);
        exp.add(park3);

        Graph<Location, Double> graph = energyEfficientRouteController.createGraph(user, paths);

        List<RouteEnergy> result = energyEfficientRouteController.getShortestsPathByList(Utils.permute(new int[1]), listPoi, park1, park3, graph);

        assertEquals(result.get(0).getEnergy(), 1119105.8089400283, 0.0);
        assertEquals(result.get(0).getRoute(), exp);
    }

    @Test
    public void testSortListAscending() {
        System.out.println("sortListAscending");
        EnergyEfficientRouteController instance = new EnergyEfficientRouteController();
        List<RouteEnergy> list = new LinkedList<>();
        LinkedList<Location> listLoc = new LinkedList<>();

        RouteEnergy route = new RouteEnergy(listLoc, 30);
        RouteEnergy route1 = new RouteEnergy(listLoc, 40);
        RouteEnergy route2 = new RouteEnergy(listLoc, 50);
        RouteEnergy route3 = new RouteEnergy(listLoc, 60);
        list.add(route1);
        list.add(route2);
        list.add(route3);
        list.add(route);

        List<RouteEnergy> listExp = new LinkedList<>();
        listExp.add(route);
        listExp.add(route1);
        listExp.add(route2);
        listExp.add(route3);

        assertEquals(instance.sortListAscending(list), listExp);
    }

    @Test
    public void testSortListDescending() {
        System.out.println("sortListDescending");
        List<RouteEnergy> list = new LinkedList<>();
        LinkedList<Location> listLoc = new LinkedList<>();

        RouteEnergy route = new RouteEnergy(listLoc, 30);
        RouteEnergy route1 = new RouteEnergy(listLoc, 40);
        RouteEnergy route2 = new RouteEnergy(listLoc, 50);
        RouteEnergy route3 = new RouteEnergy(listLoc, 60);
        list.add(route1);
        list.add(route2);
        list.add(route3);
        list.add(route);

        List<RouteEnergy> listExp = new LinkedList<>();
        listExp.add(route3);
        listExp.add(route2);
        listExp.add(route1);
        listExp.add(route);

        assertEquals(energyEfficientRouteController.sortListDescending(list), listExp);
    }

    @Test
    public void testGetListWithMaxRoutes() {
        System.out.println("getListWithMaxRoutes");
        EnergyEfficientRouteController instance = new EnergyEfficientRouteController();

        List<RouteEnergy> list = new LinkedList<>();
        LinkedList<Location> listLoc = new LinkedList<>();

        RouteEnergy route = new RouteEnergy(listLoc, 30);
        RouteEnergy route1 = new RouteEnergy(listLoc, 40);
        RouteEnergy route2 = new RouteEnergy(listLoc, 50);
        RouteEnergy route3 = new RouteEnergy(listLoc, 60);
        list.add(route);
        list.add(route1);
        list.add(route2);
        list.add(route3);

        List<RouteEnergy> listExp = new LinkedList<>();
        listExp.add(route);
        listExp.add(route1);
        listExp.add(route2);

        assertEquals(instance.getListWithMaxRoutes(list, 3), listExp);
    }

    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        
        when(parkAPI.getParkByCoord(park1.getLatitude(), park1.getLongitude())).thenReturn(park1);
        when(parkAPI.getParkByCoord(park2.getLatitude(), park2.getLongitude())).thenReturn(park2);
        when(parkAPI.getParkByCoord(park3.getLatitude(), park3.getLongitude())).thenReturn(park3);
        when(pointOfInterestAPI.getPoiByCoord(poi1.getLatitude(), poi1.getLongitude())).thenReturn(poi1);
        when(pointOfInterestAPI.getPoiByCoord(poi2.getLatitude(), poi2.getLongitude())).thenReturn(poi2);

        assertEquals(energyEfficientRouteController.getLocation(10, 10), park1);
    }
}
