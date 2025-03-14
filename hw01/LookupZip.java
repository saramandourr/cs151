//package hw01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LookupZip {
    public static ExpandableArray<Place> readZipCodes(String filename, String filename2) throws FileNotFoundException {
        ExpandableArray<Place> places = new ExpandableArray<>();
        HashMap<String, Integer> zipIndexMap = new HashMap<>();

        Scanner scanner1 = new Scanner(new File(filename));
        if (scanner1.hasNextLine()) scanner1.nextLine(); // skip header

        while (scanner1.hasNextLine()) {
            String[] data = scanner1.nextLine().split(",", -1);
            String zip = data[0];
            String city = data[1];
            String state = data[2];
            int population = data[3].isEmpty() ? -1 : Integer.parseInt(data[3]);

            Place place;
            if (population != -1) {
                place = new PopulatedPlace(zip, city, state, 0.0, 0.0, population);
            } else {
                place = new Place(zip, city, state);
            }

            zipIndexMap.put(zip, places.size());
            places.insertAOB(place);
        }
        scanner1.close();

        Scanner scanner2 = new Scanner(new File(filename2));
        if (scanner2.hasNextLine()) scanner2.nextLine(); // skip header

        while (scanner2.hasNextLine()) {
            String[] data = scanner2.nextLine().split(",", -1);
            String zip = data[0].replace("\"", "");
            double lat = data[5].isEmpty() ? 0.0 : Double.parseDouble(data[5]);
            double lon = data[6].isEmpty() ? 0.0 : Double.parseDouble(data[6]);

            if (zipIndexMap.containsKey(zip)) {
                int index = zipIndexMap.get(zip);
                Place p = places.get(index);

                if (p instanceof PopulatedPlace) {
                    PopulatedPlace popPlace = (PopulatedPlace) p;
                    places.set(new PopulatedPlace(zip, popPlace.getCity(), popPlace.getState(), lat, lon, popPlace.getPopulation()), index);
                } else {
                    places.set(new LocatedPlace(zip, p.getCity(), p.getState(), lat, lon), index);
                }
            }
        }
        scanner2.close();
        return places;
    }

    public static Place lookupZip(ExpandableArray<Place> places, Object zip) {  
        String zipString = String.valueOf(zip); 
        for (int i = 0; i < places.size(); i++) {
            if (places.get(i).getZip().equals(zipString)) {
                return places.get(i);
            }
        }
        return null;
    }
}
