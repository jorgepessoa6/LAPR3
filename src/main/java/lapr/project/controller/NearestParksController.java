/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Park;
import lapr.project.model.ParkForBST;
import lapr.project.tree.BST;
import lapr.project.utils.Utils;

/**
 * @author Jorge Pessoa
 */
public class NearestParksController {

    public NearestParksController() {
        //empty constructor
    }

    public List<Park> getNearestParks(double userLatitude, double userLongitude, int range, List<Park> listParks) {

        BST<ParkForBST> tree = new BST<>();
        for (Park parkTmp : listParks) {
            double dist = Utils.distance(userLatitude, parkTmp.getLatitude(), userLongitude, parkTmp.getLongitude());
            tree.insert(new ParkForBST(parkTmp, dist));
        }
        List<Park> parks = new ArrayList<>();
        for (ParkForBST parkforbst : tree.inOrder()) {
            addNearestPark(parkforbst, range, parks);
        }
        return parks;
    }

    public void addNearestPark(ParkForBST parkforbst, int range, List<Park> parks) {
        if (parkforbst.getDistance() < range) {
            parks.add(parkforbst.getPark());
        }
    }
}
