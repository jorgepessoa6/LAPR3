/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lapr.project.data.ParkAPI;
import lapr.project.data.PointOfInterestAPI;
import lapr.project.graph.Graph;
import lapr.project.graph.GraphAlgorithms;
import lapr.project.model.Location;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.RouteEnergy;
import lapr.project.model.User;
import lapr.project.utils.Utils;

/**
 *
 * @author Jorge Pessoa
 */
public class EnergyEfficientRouteController {

    private final ParkAPI parkApi;
    private final PointOfInterestAPI poiApi;

    public EnergyEfficientRouteController() {
        parkApi = new ParkAPI();
        poiApi = new PointOfInterestAPI();
    }

    public EnergyEfficientRouteController(ParkAPI parkAPI,PointOfInterestAPI poiApi) {
        this.parkApi = parkAPI;
        this.poiApi = poiApi;
    }

    public RouteEnergy mostEnergyEfficientRouteBetweenTwoParks(Park originPark, Park destinationPark, User user, List<Path> paths) {
        LinkedList<Location> route = new LinkedList<>();
        Location loc = originPark;
        Location loc2 = destinationPark;
        Graph<Location, Double> graph = createGraph(user, paths);
        double energy = GraphAlgorithms.shortestPath(graph, loc, loc2, route);
        System.out.println(route);
        return new RouteEnergy(route, energy);
    }

    public List<RouteEnergy> mostEnergyEfficientRouteBetweenTwoParksWithPois(Park originPark, Park destinationPark, User user, List<Path> paths, List<Location> pois, int maxRoutes, String sortCriteria) {
        List<RouteEnergy> route;
        Graph<Location, Double> graph = createGraph(user, paths);
        int[] arr = Utils.createArray(pois.size());
        List<List<Integer>> list = Utils.permute(arr);
        route = getShortestsPathByList(list, pois, originPark, destinationPark, graph);
        if (sortCriteria.equalsIgnoreCase("ascending")) {
            route = sortListAscending(route);
        } else {
            route = sortListDescending(route);
        }
        return getListWithMaxRoutes(route, maxRoutes);
    }

    public Graph<Location, Double> createGraph(User user, List<Path> paths) {
        Graph<Location, Double> graph = new Graph<>(true);
        for (Path path : paths) {
            Location location1 = getLocation(path.getLatitudeA(), path.getLongitudeA());
            if (location1 != null) {
                graph.insertVertex(location1);
            }
            Location location2 = getLocation(path.getLatitudeB(), path.getLongitudeB());
            if (location2 != null) {
                graph.insertVertex(location2);
            }
            if (location1 != null && location2 != null) {
                double energy = Utils.calculateEnergy(location1, location2, path, user);
                graph.insertEdge(location1, location2, energy, energy);
            }
        }
        return graph;
    }

    @SuppressWarnings("unchecked")
    public List<RouteEnergy> getShortestsPathByList(List<List<Integer>> arrayPermut, List<Location> pois, Park originPark, Park destinationPark, Graph<Location, Double> graph) {
        double energy;
        List<RouteEnergy> listRouteEnergy = new ArrayList<>();
        LinkedList<Location> finalPath = new LinkedList<>();
        LinkedList<Location> path = new LinkedList<>();
        LinkedList<Location> shortPath = new LinkedList<>();
        Location location;
        Location location2 = null;
        Location locationDest = destinationPark;
        for (List<Integer> list : arrayPermut) {
            location = originPark;
            path.clear();
            energy = 0;
            for (int i = 0; i < list.size(); i++) {
                location2 = pois.get(list.get(i));
                energy += GraphAlgorithms.shortestPath(graph, location, location2, shortPath);
                shortPath.removeLast();
                path.addAll(shortPath);
                shortPath.clear();
                location = location2;
            }
            energy += GraphAlgorithms.shortestPath(graph, location2, locationDest, shortPath);
            path.addAll(shortPath);
            shortPath.clear();
            finalPath.clear();
            finalPath = (LinkedList<Location>) path.clone();
            listRouteEnergy.add(new RouteEnergy(finalPath, energy));
            path.clear();
        }
        return listRouteEnergy;
    }

    public List<RouteEnergy> sortListAscending(List<RouteEnergy> list) {
        List<RouteEnergy> listF = new ArrayList<>(list);
        listF.sort((RouteEnergy t, RouteEnergy t1) -> {
            int i;
            i = Double.compare(t.getEnergy(), t1.getEnergy());
            return i;
        });
        return listF;
    }

    public List<RouteEnergy> sortListDescending(List<RouteEnergy> list) {
        List<RouteEnergy> listF = new ArrayList<>(list);
        listF.sort((RouteEnergy t, RouteEnergy t1) -> {
            int i;
            i = Double.compare(t.getEnergy(), t1.getEnergy());
            return -i;
        });
        return listF;
    }

    public List<RouteEnergy> getListWithMaxRoutes(List<RouteEnergy> list, int maxRoutes) {
        List<RouteEnergy> listF = new LinkedList<>();
        for (int i = 0; i < maxRoutes; i++) {
            listF.add(list.get(i));
        }
        return listF;
    }

    public Location getLocation(double latitude, double longitude) {
        Location loc1;
        loc1 = parkApi.getParkByCoord(latitude, longitude);
        if (loc1 == null) {
            loc1 = poiApi.getPoiByCoord(latitude, longitude);
        }
        return loc1;
    }
}
