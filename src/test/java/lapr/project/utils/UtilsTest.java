/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Location;
import lapr.project.model.Path;
import lapr.project.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

/**
 *
 * @author rickropes
 */
public class UtilsTest {

    public UtilsTest() {
    }

    /**
     * Test of distance method, of class Utils.
     */
    @Test
    public void testDistance() {
        System.out.println("distance");
        assertEquals(Utils.distance(0d, 0d, 0d, 0d), 0, 0.0);
        assertEquals(Utils.distance(1d, 2d, 3d, 4d), 157.2254320380729d, 0.0);
        assertEquals(Utils.distance(1d, 0d, 1d, 0d), 157.24938127194397, 0.0);
        assertEquals(Utils.distance(0d, 1d, 0d, 1d), 157.24938127194397, 0.0);
    }

    @Test
    public void testDistanceElevation() {
        System.out.println("distanceElevation");
        assertEquals(Utils.distanceElevation(10, 10, 10, 20, 20, 20), 1544757.5610619772, 0.0);
    }

    @Test
    public void testWind() {
        System.out.println("calculateWind");
        assertEquals(Utils.calculateWind(10, 10, 10, 10, 20, 20), 1.7179789106053989, 0.0);
    }

    @Test
    public void testCreateArray() {
        System.out.println("createArray");
        assertNotEquals(Utils.createArray(2), Utils.createArray(1));
    }

    @Test
    public void TestPermute() {
        System.out.println("permute");
        List<List<Integer>> exp = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(0);
        exp.add(list1);
        exp.add(list2);
        int[] arr = new int[2];
        arr[0] = 0;
        arr[1] = 1;
        assertEquals(Utils.permute(arr), exp);
    }
    
    @Test
    public void TestCalculateEnergy(){
        System.out.println("calculateEnergy");
        Location location1 = new Location(41.15227, -8.60929,104);
        Location location2 = new Location(41.14063,-8.61118,25);
        Path path = new Path(1, 10, 10, 20, 20, 0.5, 1, 10);
        User user = new User("email", "username", 180, 70, 0, "F", 10, 10, "password");
        assertEquals(Utils.calculateEnergy(location1, location2, path, user), 193.08068386575974, 0.0);
        assertEquals(Utils.calculateEnergy(location2, location2, path, user), 0.0, 0.0);
    }

}
