package hw00;

import java.io.*;
import java.util.*;


public class Driver00 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Driver00 <filename> <numEntries>");
            return;
        }
        String filename = args[0];
        int numEntries = Integer.parseInt(args[1]);
        Place[] places;

        try {
            places = LookupZip.readZipCodes(filename, numEntries);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        Scanner scanner =  new Scanner(System.in);
        while (true) {
            System.out.print("zipcode: ");
            String zip = scanner.nextLine();
            
            if (zip.equals("00000")) {
                System.out.println("Good bye!");
                break;
            }
            Place result = LookupZip.lookupZip(places, zip);
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("No such zipcode");
            }
        } scanner.close();
    } 
}
