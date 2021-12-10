package lapr.project.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
    /**
     * Lê um ficheiro
     *
     * @param text
     * @return lista com cada linha
     */
    public static ArrayList<String> readFile(String text) {
        ArrayList<String> list = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(text));

            while (sc.hasNextLine()) {
                String temp = sc.nextLine();
                if(temp.trim().charAt(0) != '#'){
                    list.add(temp.replace(',', '.'));
                }
            }
            System.out.println(list);
            return list;
        } catch (FileNotFoundException fnfe) {
            System.out.println("Ficheiro Não Encontrado");
        }
        return null;
    }
    
    public static ArrayList<String[]> getBicycles(ArrayList<String> list){
        ArrayList<String[]> res = new ArrayList<>();
        int[] pos = new int[7];
        String start[] = list.get(0).split(";");
        
        pos[0] = Arrays.asList(start).indexOf("bicycle description");
        pos[1] = Arrays.asList(start).indexOf("weight");
        pos[2] = Arrays.asList(start).indexOf("park latitude");
        pos[3] = Arrays.asList(start).indexOf("park longitude");
        pos[4] = Arrays.asList(start).indexOf("aerodynamic coefficient");
        pos[5] = Arrays.asList(start).indexOf("frontal area");
        pos[6] = Arrays.asList(start).indexOf("wheel size");
        
        for(int i = 1; i < list.size(); i++){
            String[] temp = list.get(i).split(";");
            String[] place = new String[7];
            for(int j = 0; j < temp.length; j++){
                place[pos[j]] = temp[j];
            }
            res.add(place);
        }
        
        return res;
    }
    
    public static ArrayList<String[]> getEscooters(ArrayList<String> list){
        ArrayList<String[]> res = new ArrayList<>();
        int[] pos = new int[10];
        String start[] = list.get(0).split(";");
        
        pos[0] = Arrays.asList(start).indexOf("escooter description");
        pos[1] = Arrays.asList(start).indexOf("weight");
        pos[2] = Arrays.asList(start).indexOf("type");
        pos[3] = Arrays.asList(start).indexOf("park latitude");
        pos[4] = Arrays.asList(start).indexOf("park longitude");
        pos[5] = Arrays.asList(start).indexOf("max battery capacity");
        pos[6] = Arrays.asList(start).indexOf("actual battery capacity");
        pos[7] = Arrays.asList(start).indexOf("aerodynamic coefficient");
        pos[8] = Arrays.asList(start).indexOf("frontal area");
        pos[9] = Arrays.asList(start).indexOf("motor");
        
        for(int i = 1; i < list.size(); i++){
            String[] temp = list.get(i).split(";");
            String[] place = new String[9];
            for(int j = 0; j < temp.length; j++){
                place[pos[j]] = temp[j];
            }
            res.add(place);
        }
        
        return res;
    }
    
    public static ArrayList<String[]> getParks(ArrayList<String> list){
        ArrayList<String[]> res = new ArrayList<>();
        int[] pos = new int[9];
        String start[] = list.get(0).split(";");
        
        pos[0] = Arrays.asList(start).indexOf("park identification");
        pos[1] = Arrays.asList(start).indexOf("latitude");
        pos[2] = Arrays.asList(start).indexOf("longitude");
        pos[3] = Arrays.asList(start).indexOf("elevation");
        pos[4] = Arrays.asList(start).indexOf("park description");
        pos[5] = Arrays.asList(start).indexOf("max number of bicycles");
        pos[6] = Arrays.asList(start).indexOf("max number of escooters");
        pos[7] = Arrays.asList(start).indexOf("park input voltage");
        pos[8] = Arrays.asList(start).indexOf("park input current");
        
        for(int i = 1; i < list.size(); i++){
            String[] temp = list.get(i).split(";");
            String[] place = new String[9];
            for(int j = 0; j < temp.length; j++){
                place[pos[j]] = temp[j];
            }
            res.add(place);
        }
        
        return res;
    }
    
    public static ArrayList<String[]> getPaths(ArrayList<String> list){
        ArrayList<String[]> res = new ArrayList<>();
        int[] pos = new int[7];
        String start[] = list.get(0).split(";");
        
        pos[0] = Arrays.asList(start).indexOf("latitudeA");
        pos[1] = Arrays.asList(start).indexOf("longitudeA");
        pos[2] = Arrays.asList(start).indexOf("latitudeB");
        pos[3] = Arrays.asList(start).indexOf("longitudeB");
        pos[4] = Arrays.asList(start).indexOf("kinetic coefficient");
        pos[5] = Arrays.asList(start).indexOf("wind direction");
        pos[6] = Arrays.asList(start).indexOf("wind speed");
        
        for(int i = 1; i < list.size(); i++){
            String[] temp = list.get(i).split(";");
            String[] place = new String[7];
            for(int j = 0; j < temp.length; j++){
                place[pos[j]] = temp[j];
            }
            res.add(place);
        }
        
        return res;
    }
    
    public static ArrayList<String[]> getPois(ArrayList<String> list){
        ArrayList<String[]> res = new ArrayList<>();
        int[] pos = new int[4];
        String start[] = list.get(0).split(";");
        
        pos[0] = Arrays.asList(start).indexOf("latitude");
        pos[1] = Arrays.asList(start).indexOf("longitude");
        pos[2] = Arrays.asList(start).indexOf("elevation");
        pos[3] = Arrays.asList(start).indexOf("poi description");
        
        System.out.println(list);
        
        for(int i = 1; i < list.size(); i++){
            String[] temp = list.get(i).split(";");
            String[] place = new String[4];
            System.out.println(temp);
            for(int j = 0; j < temp.length; j++){
                place[pos[j]] = temp[j];
            }
            res.add(place);
        }
        
        return res;
    }
    
    public static ArrayList<String[]> getUsers(ArrayList<String> list){
        ArrayList<String[]> res = new ArrayList<>();
        int[] pos = new int[8];
        String start[] = list.get(0).split(";");
        
        pos[0] = Arrays.asList(start).indexOf("username");
        pos[1] = Arrays.asList(start).indexOf("email");
        pos[2] = Arrays.asList(start).indexOf("height");
        pos[3] = Arrays.asList(start).indexOf("weight");
        pos[4] = Arrays.asList(start).indexOf("cycling average speed");
        pos[5] = Arrays.asList(start).indexOf("visa");
        pos[6] = Arrays.asList(start).indexOf("gender");
        pos[7] = Arrays.asList(start).indexOf("password");
        
        for(int i = 1; i < list.size(); i++){
            String[] temp = list.get(i).split(";");
            String[] place = new String[8];
            for(int j = 0; j < temp.length; j++){
                place[pos[j]] = temp[j];
            }
            res.add(place);
        }
        
        return res;
    }
    
    
}
