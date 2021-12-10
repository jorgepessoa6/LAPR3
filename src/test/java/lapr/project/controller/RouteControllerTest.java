/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import lapr.project.model.Location;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.Poi;
import lapr.project.utils.Utils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author rickropes
 */
public class RouteControllerTest {

    public RouteControllerTest() {
    }

    /**
     * Test of shortestRoutePOI method, of class RouteController.
     */
    @Test
    public void testShortestRoutePOI() {
        System.out.println("shortestRoutePOI");
        Park orig = new Park("park1", "desc1", 0, 0, 0, 0, 0, 0, 0);
        Park dest = new Park("park2", "desc2", 0, 0, 100, 100, 0, 0, 0);
        
        List<Park> parks = new ArrayList<Park>();
        parks.add(orig);
        parks.add(dest);
        
        
        Poi p1 = new Poi(10, 10, 0, "desc1");
        Poi p2 = new Poi(20, 20, 0, "desc2");
        Poi p3 = new Poi(30, 30, 0, "desc3");
        Poi p4 = new Poi(40, 40, 0, "desc4");

        Path ph1 = new Path(0, 0, 0, 10, 10, 0, 0, 0);
        Path ph2 = new Path(1, 10, 10, 20, 20, 0, 0, 0);
        Path ph3 = new Path(2, 20, 20, 30, 30, 0, 0, 0);
        Path ph4 = new Path(3, 30, 30, 40, 40, 0, 0, 0);
        Path ph5 = new Path(4, 40, 40, 100, 100, 0, 0, 0);
        Path ph6 = new Path(5, 0, 0, 100, 100, 0, 0, 0);

        List<Poi> pontosEscolhidos = new ArrayList<Poi>();
        pontosEscolhidos.add(p1);
        pontosEscolhidos.add(p2);

        List<Poi> pois = new ArrayList<Poi>();
        pois.add(p1);
        pois.add(p2);
        pois.add(p3);
        pois.add(p4);

        List<Path> paths = new ArrayList<Path>();;
        paths.add(ph1);
        paths.add(ph2);
        paths.add(ph3);
        paths.add(ph4);
        paths.add(ph5);
        paths.add(ph6);

        RouteController instance = new RouteController();
        List<LinkedList<Location>> ls = new ArrayList<LinkedList<Location>>();
        double res = instance.shortestRoutePOI(3, orig, dest, pontosEscolhidos, pois, paths, parks, ls);

        LinkedList<Location> result = ls.get(0);
        assertEquals(orig, result.get(0));
        assertEquals(p1, result.get(1));
        assertEquals(p2, result.get(2));
        assertEquals(p3, result.get(3));
        assertEquals(dest, result.get(result.size() - 1));
        assertEquals(6, result.size());

        double res2 = instance.shortestRoutePOI(0, orig, dest, null, pois, paths, parks, ls);
        LinkedList<Location> result2 = ls.get(0);
        assertEquals(orig, result2.get(0));
        assertEquals(dest, result2.get(result2.size() - 1));
        assertEquals(2, result2.size());
    }

    /**
     * Test of shortestRouteBetweenTwoParks method, of class RouteController.
     */
    @Test
    public void testShortestRouteBetweenTwoParks() {
        System.out.println("shortestRouteBetweenTwoParks");
        
        List<Park> parks = new ArrayList<Park>();
        Park orig = new Park("park1", "desc1", 0, 0, 100, 100, 0, 0, 0);
        Park dest = new Park("park2", "desc2", 0, 0, 0, 130, 0, 0, 0);
        
        parks.add(orig);
        parks.add(dest);
        
        List<Poi> pois = new ArrayList<Poi>();
        Poi poi1 = new Poi(50, 120, 0, "desc1");
        Poi poi2 = new Poi(50, 60, 0, "desc2");
        Poi poi3 = new Poi(30, 80, 0, "desc3");
        pois.add(poi1);
        pois.add(poi2);
        pois.add(poi3);
        
        List<Path> paths = new ArrayList<Path>();
        Path ph1 = new Path(0, 100, 100, 50, 120, 0, 0, 0);
        Path ph2 = new Path(1, 50, 120, 0, 130, 0, 0, 0);
        Path ph3 = new Path(2, 100, 100, 50, 60, 0, 0, 0);
        Path ph4 = new Path(3, 50, 60, 30, 80, 0, 0, 0);
        Path ph5 = new Path(4, 30, 80, 50, 120, 0, 0, 0);
        paths.add(ph1);
        paths.add(ph2);
        paths.add(ph3);
        paths.add(ph4);
        paths.add(ph5);
        
        RouteController instance = new RouteController();
        List<Location> t = new ArrayList<>();
        List<List<Location>> expResult = new ArrayList<List<Location>>();
        t.add(orig);
        t.add(poi1);
        t.add(dest);
        expResult.add(t);
        List<List<Location>> result = instance.shortestRouteBetweenTwoParks(orig, dest, 1, pois, paths, parks);
        System.out.println(result.size());
        assertEquals(expResult, result);
    }

}
