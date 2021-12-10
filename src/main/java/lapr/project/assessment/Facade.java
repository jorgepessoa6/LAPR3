package lapr.project.assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import lapr.project.controller.EnergyEfficientRouteController;
import lapr.project.controller.NearestParksController;
import lapr.project.data.*;
import lapr.project.model.Location;
import lapr.project.model.Park;
import lapr.project.model.Path;
import lapr.project.model.User;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import lapr.project.controller.RouteController;
import lapr.project.controller.AssignPointsController;
import lapr.project.controller.ReportVehiclesNonBatteryToTravelController;
import lapr.project.model.Bicycle;
import lapr.project.model.Report;
import static lapr.project.model.Report.calculateLoadEstimate;
import lapr.project.model.Invoice;
import lapr.project.model.Poi;
import lapr.project.model.RouteEnergy;
import lapr.project.model.Scooter;
import lapr.project.model.Trip;
import lapr.project.utils.Utils;

public class Facade implements Serviceable {

    public Facade() {

        String pathJar = Bootable.class.getProtectionDomain().getCodeSource().getLocation().toString();
        String baseDir = pathJar.replace("/target/ride-sharing-1.0-SNAPSHOT.jar!/", "");
        baseDir = baseDir.replace("jar:file:/", "");
        baseDir = baseDir.replace("lapr3-2019-assessment/../", "");
        System.out.println(baseDir);

        try {
            Properties properties
                    = new Properties(System.getProperties());
            InputStream input = new FileInputStream(baseDir + "/target/classes/application.properties");
            properties.load(input);
            input.close();
            System.setProperties(properties);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("START DATA BASE");
            Bootable b = new Bootable();
            b.createTables(baseDir + "/sql/createTables.sql");
            System.out.println("START DATA BASE FINISH");
        } catch (Exception e) {
            System.out.println("START ERROR");
        }
    }

    @Override
    public int addBicycles(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getBicycles(info);
        int num = 0;

        VehicleAPI vapi = new VehicleAPI();

        boolean check = vapi.addBike(place);
        if (check) {
            num = place.size();
        }

        return num;
    }

    @Override
    public int addEscooters(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getEscooters(info);
        int num = 0;

        VehicleAPI vapi = new VehicleAPI();

        boolean check = vapi.addScooter(place);
        if (check) {
            num = place.size();
        }
        return num;
    }

    @Override
    public int addParks(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getParks(info);
        int num = 0;
        ParkAPI papi = new ParkAPI();

        boolean check = papi.addPark(place);
        if (check) {
            num = place.size();
        }
        return num;
    }

    @Override
    public int removePark(String parkIdentification
    ) {
        ParkAPI parkAPI = new ParkAPI();
        if (parkAPI.removeParkAPI(parkIdentification)) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int addPOIs(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getPois(info);

        int num = 0;

        PointOfInterestAPI poiAPI = new PointOfInterestAPI();

        boolean check = poiAPI.addPoi(place);
        if (check) {
            num = place.size();
        }

        return num;
    }

    @Override
    public int addUsers(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getUsers(info);

        int num = 0;

        UserAPI userAPI = new UserAPI();

        boolean check = userAPI.addUser(place);
        if (check) {
            num = place.size();
        }

        return num;
    }

    @Override
    public int addPaths(String inputFile
    ) {
        ArrayList<String> info = FileReader.readFile(inputFile);
        List<String[]> place = FileReader.getPaths(info);

        int num = 0;

        PathAPI pathAPI = new PathAPI();

        boolean check = pathAPI.addPath(place);
        if (check) {
            num = place.size();
        }

        return num;
    }

    @Override
    public int getNumberOfBicyclesAtPark(double parkLatitudeInDegrees, double parkLongitudeInDegrees, String outputFileName
    ) {
        ParkAPI parkAPI = new ParkAPI();
        List<String> list = parkAPI.getBicyclesInParksByLatAndLon(parkLatitudeInDegrees, parkLongitudeInDegrees);
        Collections.sort(list);
        FileOutput.saveVehiclesDescription(outputFileName, list);
        return list.size();
    }

    @Override
    public int getNumberOfBicyclesAtPark(String parkIdentification, String outputFileName
    ) {
        ParkAPI parkAPI = new ParkAPI();
        List<String> list = parkAPI.getBicyclesInParksById(parkIdentification);
        Collections.sort(list);
        FileOutput.saveVehiclesDescription(outputFileName, list);
        return list.size();
    }

    @Override
    public void getNearestParks(double userLatitudeInDegrees, double userLongitudeInDegrees, String outputFileName
    ) {
        ParkAPI parkAPI = new ParkAPI();
        List<Park> allParks = parkAPI.getAllParks();
        NearestParksController nearestParksController = new NearestParksController();
        List<Park> parks = nearestParksController.getNearestParks(userLatitudeInDegrees, userLongitudeInDegrees, 1, allParks);
        FileOutput.saveNearestPark(userLatitudeInDegrees, userLongitudeInDegrees, outputFileName, parks);
    }

    @Override
    public void getNearestParks(double userLatitudeInDegrees, double userLongitudeInDegrees, String outputFileName,
            int radius
    ) {
        ParkAPI parkAPI = new ParkAPI();
        List<Park> allParks = parkAPI.getAllParks();
        NearestParksController nearestParksController = new NearestParksController();
        List<Park> parks = nearestParksController.getNearestParks(userLatitudeInDegrees, userLongitudeInDegrees, radius, allParks);
        FileOutput.saveNearestPark(userLatitudeInDegrees, userLongitudeInDegrees, outputFileName, parks);
    }

    @Override
    public int getFreeBicycleSlotsAtPark(String parkIdentification, String username
    ) {
        ParkAPI parkAPI = new ParkAPI();
        return parkAPI.getFreePlacesBicyclesInParksByIdAndUsername(parkIdentification, username);
    }

    @Override
    public int getFreeEscooterSlotsAtPark(String parkIdentification, String username
    ) {
        ParkAPI parkAPI = new ParkAPI();
        return parkAPI.getFreePlacesScootersInParksByIdAndUsername(parkIdentification, username);
    }

    @Override
    public int linearDistanceTo(double originLatitudeInDegrees, double originLongitudeInDegrees, double destinyLatitudeInDegrees, double destinyLongitudeInDegrees) {
        return (int) Math.round(Utils.distance(originLatitudeInDegrees, destinyLatitudeInDegrees, originLongitudeInDegrees, destinyLongitudeInDegrees));
    }

    @Override
    public int pathDistanceTo(double originLatitudeInDegrees, double originLongitudeInDegrees, double destinyLatitudeInDegrees, double destinyLongitudeInDegrees) {
        ParkAPI parkAPI = new ParkAPI();
        List<Park> listParks = parkAPI.getAllParks();
        Park parkOrig = parkAPI.getParkByCoord(originLatitudeInDegrees, originLongitudeInDegrees);
        Park parkDest = parkAPI.getParkByCoord(destinyLatitudeInDegrees, destinyLongitudeInDegrees);
        PointOfInterestAPI poiAPI = new PointOfInterestAPI();
        PathAPI pathAPI = new PathAPI();
        List<Path> listPaths = pathAPI.getAllPaths();
        List<Poi> listPois = poiAPI.getAllPois();
        LinkedList<Location> route = new LinkedList<>();
        RouteController routeC = new RouteController();

        return (int) Math.round(routeC.shortestPathBetweenTwoParks(parkOrig, parkDest, listPois, listPaths, listParks, route) * 1000);
    }

    @Override
    public long unlockBicycle(String bicycleDescription, String username
    ) {

        TripAPI tripAPI = new TripAPI();
        UserAPI userAPI = new UserAPI();
        VehicleAPI vehicleAPI = new VehicleAPI();
        User user = userAPI.getUserByUsername(username);
        Bicycle bike = vehicleAPI.getBicycleByDesc(bicycleDescription);
        System.out.println("test1");
        if (tripAPI.getUnfinishedTripOfUser(user.getEmail()) == null) {
            System.out.println("test2");
            tripAPI.createTrip(bike.getDescription(), user.getEmail(), bike.getIdPark());
            return System.currentTimeMillis();
        }
        return -1;
    }

    @Override
    public long unlockEscooter(String escooterDescription, String username) {
        TripAPI tripAPI = new TripAPI();
        UserAPI userAPI = new UserAPI();
        VehicleAPI vehicleAPI = new VehicleAPI();
        User user = userAPI.getUserByUsername(username);
        Scooter scooter = vehicleAPI.getScooterByDesc(escooterDescription);
        if (tripAPI.getUnfinishedTripOfUser(user.getEmail()) == null) {
            tripAPI.createTrip(scooter.getDescription(), user.getEmail(), scooter.getIdPark());
            return System.currentTimeMillis();
        }
        return -1;
    }

    @Override
    public long lockBicycle(String bicycleDescription, double parkLatitudeInDegrees, double parkLongitudeInDegrees, String username) {
        return lockVehicle(parkLatitudeInDegrees, parkLongitudeInDegrees, username);
    }

    @Override
    public long lockBicycle(String bicycleDescription, String parkIdentification, String username) {
        return lockVehicle(username, parkIdentification);
    }

    @Override
    public long lockEscooter(String escooterDescription, double parkLatitudeInDegrees, double parkLongitudeInDegrees, String username) {
        return lockVehicle(parkLatitudeInDegrees, parkLongitudeInDegrees, username);
    }

    @Override
    public long lockEscooter(String escooterDescription, String parkIdentification, String username) {
        return lockVehicle(username, parkIdentification);
    }

    private long lockVehicle(String username, String parkIdentification) {
        ParkingVehicleAPI pvapi = new ParkingVehicleAPI();
        ParkAPI parkAPI = new ParkAPI();
        EmailParkedAPI epapi = new EmailParkedAPI();
        TripAPI tapi = new TripAPI();
        UserAPI uapi = new UserAPI();
        AssignPointsController apc = new AssignPointsController();

        User user = uapi.getUserByUsername(username);
        Trip trip = tapi.getUnfinishedTripOfUser(user.getEmail());
        Park park = parkAPI.getParkById(parkIdentification);

        //email
        boolean parked = pvapi.parkVehicle(trip.getIdTrip(), park.getLatitude(), park.getLongitude());
        epapi.sendEmailStatus(trip.getIdTrip(), parked);

        try {
            Trip tripEnd = tapi.getTripByCod(trip.getIdTrip());
            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tripEnd.getTimestampStart());
            Date endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(tripEnd.getTimestampFinish());
            //pontos
            int dif = apc.calculateElevationDifference(parkAPI.getParkById(trip.getIdStartPark()).getElevation(), park.getElevation());
            double tripLength = apc.calculateTripTime(startDate, endDate);
            uapi.addPoints(user.getEmail(), dif, tripLength);
        } catch (Exception e) {
            e.printStackTrace();
        }

        long time = System.currentTimeMillis();
        return time;
    }

    private long lockVehicle(double parkLatitudeInDegrees, double parkLongitudeInDegrees, String username) {
        ParkingVehicleAPI pvapi = new ParkingVehicleAPI();
        ParkAPI parkAPI = new ParkAPI();
        EmailParkedAPI epapi = new EmailParkedAPI();
        TripAPI tapi = new TripAPI();
        UserAPI uapi = new UserAPI();
        AssignPointsController apc = new AssignPointsController();

        User user = uapi.getUserByUsername(username);
        Trip trip = tapi.getUnfinishedTripOfUser(user.getEmail());
        Park park = parkAPI.getParkByCoord(parkLatitudeInDegrees, parkLongitudeInDegrees);

        //email
        boolean parked = pvapi.parkVehicle(trip.getIdTrip(), parkLatitudeInDegrees, parkLongitudeInDegrees);
        epapi.sendEmailStatus(trip.getIdTrip(), parked);

        if (parked) {
            //pontos
            int dif = apc.calculateElevationDifference(parkAPI.getParkById(trip.getIdStartPark()).getElevation(), park.getElevation());
            double tripLength = apc.calculateTripTime(tapi.getStartDate(trip.getIdTrip()), tapi.getEndDate(trip.getIdTrip()));
            uapi.addPoints(user.getEmail(), dif, tripLength);
        }

        long time = System.currentTimeMillis();
        return time;
    }

    @Override
    public long mostEnergyEfficientRouteBetweenTwoParks(String originParkIdentification, String destinationParkIdentification,
            String typeOfVehicle, String vehicleSpecs, String username, String outputFileName) {
        EnergyEfficientRouteController energyEfficientRouteController = new EnergyEfficientRouteController();
        double dist = 0;
        ParkAPI parkAPI = new ParkAPI();
        UserAPI userAPI = new UserAPI();
        PathAPI pathAPI = new PathAPI();
        Park originPark = parkAPI.getParkById(originParkIdentification);
        Park destinationPark = parkAPI.getParkById(destinationParkIdentification);
        User user = userAPI.getUserByUsername(username);
        if (user == null || destinationPark == null || originPark == null) {
            return Math.round(dist);
        }

        List<Path> listPaths = pathAPI.getAllPaths();

        RouteEnergy routeEnergy = energyEfficientRouteController.mostEnergyEfficientRouteBetweenTwoParks(originPark, destinationPark, user, listPaths);

        int elevationDif = originPark.getElevation() - destinationPark.getElevation();
        dist = FileOutput.saveEnergyPath(elevationDif, routeEnergy, 1, outputFileName);

        System.out.println(dist);

        return Math.round(dist * 1000);
    }

    @Override
    public int getNumberOfEscootersAtPark(double d, double d1, String string
    ) {
        ParkAPI parkAPI = new ParkAPI();
        List<String> list = parkAPI.getEscootersInParksByLatAndLon(d, d1);
        Collections.sort(list);
        FileOutput.saveVehiclesDescription(string, list);
        return list.size();
    }

    @Override
    public int getNumberOfEScootersAtPark(String string, String string1
    ) {
        ParkAPI parkAPI = new ParkAPI();
        List<String> list = parkAPI.getEscootersInParksById(string);
        Collections.sort(list);
        FileOutput.saveVehiclesDescription(string1, list);
        return list.size();
    }

    @Override
    public int getFreeSlotsAtParkForMyLoanedVehicle(String string, String string1
    ) {
        ParkAPI parkAPI = new ParkAPI();
        return parkAPI.getFreePlacesVehiclesInParks(string, string1);
    }

    @Override
    public long unlockAnyEscooterAtPark(String string, String string1,
            String string2
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long unlockAnyEscooterAtParkForDestination(String string, String string1,
            double d, double d1, String string2
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getUserCurrentDebt(String string, String string1
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getUserCurrentPoints(String string, String string1) {

        TripAPI tApi = new TripAPI();
        List<Integer> trips = tApi.getTripsByUser(string);
        ParkAPI pApi = new ParkAPI();
        AssignPointsController aPoints = new AssignPointsController();

        Map<Integer, List<String>> infoMap = new HashMap<>();

        List<String> info = new ArrayList<>();

        int points = 0;

        for (Integer idTrip : trips) {
            String pIdStart = tApi.getParkIdStart(idTrip);
            String vehicle_desc = tApi.getVehicleDesc(idTrip);
            int unlockTime = 0;
            int lockTime = 0;
            float latitudeS = pApi.getLatitudeById(pIdStart);
            float longitudeS = pApi.getLongitudeById(pIdStart);
            int elevationS = pApi.getParkElevation(pIdStart);
            float latitudeE = tApi.getLatitudeEnd(idTrip);
            float longitudeE = tApi.getLongitudeEnd(idTrip);
            Park parkE = pApi.getParkByCoord(latitudeE, longitudeE);
            int elevationE = parkE.getElevation();
            int elevDiff = aPoints.calculateElevationDifference(elevationS, elevationE);
            //points = aPoints.AssignPointsToUser(pIdStart, idTrip);

            info.add(vehicle_desc);
            info.add(String.format("%.2f", unlockTime));
            info.add(String.format("%.2f", lockTime));
            info.add(String.format("%.2f", latitudeS));
            info.add(String.format("%.2f", longitudeS));
            info.add(String.format("%.2f", elevationS));
            info.add(String.format("%.2f", latitudeE));
            info.add(String.format("%.2f", longitudeE));
            info.add(String.format("%.2f", elevationE));
            info.add(String.format("%.2f", elevDiff));
            info.add(String.format("%.2f", points));

            infoMap.put(idTrip, info);

        }

        Report rT = new Report();
        rT.constructPointsReport(string1, infoMap);

        return (double) points;
    }

    @Override
    public double calculateElectricalEnergyToTravelFromOneLocationToAnother(double d, double d1, double d2, double d3, String string) {
        Location loc1 = new Location(d, d1, 0);
        Location loc2 = new Location(d2, d3, 0);
        return Utils.calculateEnergy(loc1, loc2, null, null);
    }

    @Override
    public long shortestRouteBetweenTwoParksForGivenPOIs(String originParkIdentification,
            String destinationParkIdentification,
            String inputPOIs,
            String outputFileName) {
        ParkAPI papi = new ParkAPI();
        Park pInit = papi.getParkById(originParkIdentification);
        Park pFim = papi.getParkById(destinationParkIdentification);
        return shortestRouteBetweenTwoParksForGivenPOIs(pInit, pFim, inputPOIs, outputFileName);
    }

    @Override
    public long shortestRouteBetweenTwoParksForGivenPOIs(double d, double d1, double d2, double d3, String string, String string1) {
        ParkAPI papi = new ParkAPI();
        Park pInit = papi.getParkByCoord(d, d1);
        Park pFim = papi.getParkByCoord(d2, d3);
        return shortestRouteBetweenTwoParksForGivenPOIs(pInit, pFim, string, string1);
    }

    private long shortestRouteBetweenTwoParksForGivenPOIs(Park pInit, Park pFim, String inputPOIs, String outputFileName) {
        PathAPI phapi = new PathAPI();
        ParkAPI papi = new ParkAPI();
        PointOfInterestAPI poiapi = new PointOfInterestAPI();
        RouteController rc = new RouteController();

        ArrayList<String> info = FileReader.readFile(inputPOIs);
        List<String[]> place = FileReader.getPois(info);
        List<Poi> lista = new ArrayList<Poi>();

        for (String[] s : place) {
            Poi temp = poiapi.getPoiByCoord(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
            lista.add(temp);
        }
        List<LinkedList<Location>> res = new ArrayList<LinkedList<Location>>();
        long dist = rc.shortestRoutePOI(lista.size(), pInit, pFim, lista, poiapi.getAllPois(), phapi.getAllPaths(), papi.getAllParks(), res);

        FileOutput.shortestRouteBetweenTwoParks(res, outputFileName);

        return dist;
    }

    @Override
    public long getParkChargingReport(String string, String string1) {

        long numberEscootersUnloaded = 0;

        VehicleAPI vehicleApi = new VehicleAPI();

        ParkAPI parkApi = new ParkAPI();

        Park park = parkApi.getParkById(string);

        Float latitude = parkApi.getLatitudeById(string);

        Float longitude = parkApi.getLongitudeById(string);

        int max_scooters = parkApi.getMaxScooters(latitude, longitude);

        List<String> descs_vehicles = vehicleApi.getDescVehiclesByPark(park);

        Map<String, Double> map_cods = vehicleApi.getActuallyBatery(descs_vehicles);

        List<Double> loadEstim = calculateLoadEstimate(descs_vehicles, max_scooters);

        List<String> eTypes = vehicleApi.getEscootersTypes(descs_vehicles);

        Report report = new Report();

        numberEscootersUnloaded = report.constructOutputFile(string1, loadEstim, map_cods, eTypes);

        return numberEscootersUnloaded;
    }

    @Override
    public int suggestRoutesBetweenTwoLocations(String string, String string1,
            String string2, String string3,
            String string4, int i, boolean bln, String string5,
            String string6, String string7
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getInvoiceForMonth(int i, String string,
            String string1
    ) {
        Invoice in = new Invoice();
        in.writeInvoice(string, Integer.toString(i), string1);
        InvoiceAPI api = new InvoiceAPI();
        return Math.round((api.getValue(string, Integer.toString(i))) * 100.0) / 100.0;
    }

    @Override
    public int registerUser(String string, String string1, String string2, String string3, int i, int i1, BigDecimal bd, String string4) {
        UserAPI userApi = new UserAPI();
        int bool = userApi.createUser(string, string1, i, i1, bd.doubleValue(), Integer.parseInt(string3), string4, string2);
        return bool;
    }

    @Override
    public long shortestRouteBetweenTwoParks(String originParkIdentification, String destinationParkIdentification, int numberOfPOIs, String outputFileName) {
        RouteController routeController = new RouteController();

        double dist = 0;

        ParkAPI parkAPI = new ParkAPI();
        PathAPI pathAPI = new PathAPI();
        PointOfInterestAPI poiAPI = new PointOfInterestAPI();
        Park originPark = parkAPI.getParkById(originParkIdentification);
        Park destinationPark = parkAPI.getParkById(destinationParkIdentification);

        List<Path> listPaths = pathAPI.getAllPaths();
        List<Poi> listPois = poiAPI.getAllPois();
        List<Park> listParks = parkAPI.getAllParks();

        List<List<Location>> routes = routeController.shortestRouteBetweenTwoParks(originPark, destinationPark, numberOfPOIs, listPois, listPaths, listParks);

        int elevationDif = originPark.getElevation() - destinationPark.getElevation();
        dist = FileOutput.saveShortestPath(elevationDif, routes, outputFileName);

        return Math.round(dist);
    }

    @Override
    public int suggestEscootersToGoFromOneParkToAnother(String parkIdentification, String username, double destinationParkLatitudeInDegrees, double destinationParkLongitudeInDegrees, String outputFileName) {
        VehicleAPI vehicleAPI = new VehicleAPI();
        ParkAPI parkAPI = new ParkAPI();
        ReportVehiclesNonBatteryToTravelController rvnvttc = new ReportVehiclesNonBatteryToTravelController();
        Park park = parkAPI.getParkById(parkIdentification);
        List<Scooter> list = new ArrayList<>();
        List<Scooter> disponiveis = new ArrayList<>();
        list = vehicleAPI.getAllScooters();
        disponiveis = rvnvttc.ReportVehiclesBatteryToTravel(list, (int) Utils.distance(park.getLatitude(), park.getLongitude(), destinationParkLongitudeInDegrees, destinationParkLongitudeInDegrees));
        FileOutput.saveSuggestEscooter(disponiveis, outputFileName);

        return disponiveis.size();
    }

    @Override
    public long forHowLongAVehicleIsUnlocked(String vehicleDescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long shortestRouteBetweenTwoParks(double originLatitudeInDegrees, double originLongitudeInDegrees, double destinationLatitudeInDegrees, double destinationLongitudeInDegrees, int numberOfPOIs, String outputFileName) {
        RouteController routeController = new RouteController();

        double dist = 0;

        ParkAPI parkAPI = new ParkAPI();
        PathAPI pathAPI = new PathAPI();
        PointOfInterestAPI poiAPI = new PointOfInterestAPI();
        Park originPark = parkAPI.getParkByCoord(originLatitudeInDegrees, originLongitudeInDegrees);
        Park destinationPark = parkAPI.getParkByCoord(destinationLatitudeInDegrees, destinationLongitudeInDegrees);

        List<Path> listPaths = pathAPI.getAllPaths();
        List<Poi> listPois = poiAPI.getAllPois();
        List<Park> listParks = parkAPI.getAllParks();

        List<List<Location>> routes = routeController.shortestRouteBetweenTwoParks(originPark, destinationPark, numberOfPOIs, listPois, listPaths, listParks);

        int elevationDif = originPark.getElevation() - destinationPark.getElevation();
        dist = FileOutput.saveShortestPath(elevationDif, routes, outputFileName);

        return Math.round(dist);
    }

}
