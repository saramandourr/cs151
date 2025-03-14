package hw00;

import java.io.*;
import java.util.*;

public class LookupZip {
    public static Place parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            return null;
        }
        return new Place(parts[0], parts[1], parts[2]);
    }
    public static Place[] readZipCodes(String filename, int numEntries) throws FileNotFoundException {
        Place[] places = new Place[numEntries];
        Scanner scanner = new Scanner(new File(filename));
        scanner.nextLine();

        int index = 0;
        while (scanner.hasNextLine() && index < numEntries) {
            Place place = parseLine(scanner.nextLine());
            if (place != null) {
                places[index++] = place;
            }
        }
        scanner.close();
        return places;
    }

    public static Place lookupZip(Place[] places, String zip) {
        for (Place place : places) {
            if (place != null && place.getZip().equals(zip)) {
                return place;
            }
        }
        return null;
    }
}