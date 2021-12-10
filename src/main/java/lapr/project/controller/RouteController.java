package lapr.project.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lapr.project.graph.Graph;
import lapr.project.graph.GraphAlgorithms;
import lapr.project.model.*;
import lapr.project.utils.Utils;

/**
 *
 * @author ricar
 */
public class RouteController {

    /**
     * Calcular o caminho mais curto
     *
     * @param orig parque de origem
     * @param dest parque de destino
     * @param pois todos os pois existentes
     * @param paths todos os caminhos
     * @return
     */
    public List<List<Location>> shortestRouteBetweenTwoParks(Park orig, Park dest, int nPois, List<Poi> pois, List<Path> paths, List<Park> parks) {
        Graph<Location, Integer> map = createGraph(paths, pois, parks);

        ArrayList<LinkedList<Location>> allPaths = GraphAlgorithms.allPaths(map, orig, dest);

        LinkedList<List<Location>> routes = new LinkedList<>();

        double shortestRouteDistance = Double.MAX_VALUE;

        for (LinkedList<Location> pth : allPaths) {
            if (pth.size() >= 2 + nPois) {
                double size = 0;
                for (int i = 1; i < pth.size(); i++) {
                    size += map.getEdge(pth.get(i - 1), pth.get(i)).getWeight();
                }
                if (size < shortestRouteDistance) {
                    shortestRouteDistance = size;
                }
            }
        }

        for (LinkedList<Location> pth : allPaths) {
            double size = 0;
            for (int i = 1; i < pth.size(); i++) {
                size += map.getEdge(pth.get(i - 1), pth.get(i)).getWeight();
            }
            if (size == shortestRouteDistance) {
                routes.add(pth);
            }
        }

        return routes;
    }

    public double shortestPathBetweenTwoParks(Park orig, Park dest, List<Poi> pois, List<Path> paths, List<Park> parks, LinkedList<Location> shortPath) {
        Graph<Location, Integer> map = createGraph(paths, pois, parks);
        double dist = GraphAlgorithms.shortestPath(map, orig, dest, shortPath);

        return dist;
    }

    /**
     * Calcular o caminho mais curto
     *
     * @param num numero de pontos de interesse que deve passar
     * @param orig parque de origem
     * @param dest parque de destino
     * @param pontosEscolhidos pontos de interesse selecionados
     * @param pois todos os pois existentes
     * @param paths todos os caminhos
     * @return
     */
    public long shortestRoutePOI(int num, Park orig, Park dest, List<Poi> pontosEscolhidos, List<Poi> pois, List<Path> paths, List<Park> parks, List<LinkedList<Location>> shortestRoute) {
        Graph<Location, Integer> map = createGraph(paths, pois, parks);

        ArrayList<LinkedList<Location>> todosCaminhos = GraphAlgorithms.allPaths(map, orig, dest);
        System.out.println(todosCaminhos.size());

        double shortestRouteDistance = Double.MAX_VALUE;

        for (LinkedList<Location> ll : todosCaminhos) {
            System.out.println(ll);
            if (ll.size() >= num + 2) {
                boolean check = true;
                if (pontosEscolhidos != null) {
                    for (Poi pe : pontosEscolhidos) {
                        if (!ll.contains(pe)) {
                            check = false;
                            break;
                        }
                    }
                }
                if (check) {
                    double size = 0;
                    for (int i = 1; i < ll.size(); i++) {
                        size += map.getEdge(ll.get(i - 1), ll.get(i)).getWeight();
                    }
                    System.out.println(shortestRoute);
                    if (size < shortestRouteDistance) {
                        shortestRoute.clear();
                        shortestRoute.add(ll);
                        shortestRouteDistance = size;
                    } else if (size == shortestRouteDistance) {
                        shortestRoute.add(ll);
                    }
                }
            }
        }
        return Math.round(shortestRouteDistance*1000);
    }

    private Graph<Location, Integer> createGraph(List<Path> paths, List<Poi> pois, List<Park> parks) {
        Graph<Location, Integer> map = new Graph<>(true);
        
        for(Park p: parks){
            map.insertVertex(p);
        }
        for (Poi p : pois) {
            map.insertVertex(p);
        }

        for (Path p : paths) {
            Location tempA = getPoiMap(map, p.getLatitudeA(), p.getLongitudeA());
            Location tempB = getPoiMap(map, p.getLatitudeB(), p.getLongitudeB());

            if (tempA != null && tempB != null) {
                double distance = Utils.distance(tempA.getLatitude(), tempB.getLatitude(),
                        tempA.getLongitude(), tempB.getLongitude());
                map.insertEdge(tempA, tempB, 1, distance);
            }
        }
        return map;
    }

    private Location getPoiMap(Graph<Location, Integer> map, double latitude, double longitude) {
        for (Location p : map.vertices()) {
            if (p.getLatitude() == latitude && p.getLongitude() == longitude) {
                return p;
            }
        }
        return null;
    }
}
