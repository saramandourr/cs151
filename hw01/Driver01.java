import java.io.FileNotFoundException;
import java.util.Scanner;
public class Driver01 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Driver01 uszipcodes.csv ziplocs.csv");
            return;
        }

        try {
            ExpandableArray<Place> places = LookupZip.readZipCodes(args[0], args[1]);
            Scanner input = new Scanner(System.in);

            while (true) {
                System.out.print("zipcode: ");
                String zip = input.nextLine();
                if (zip.equals("00000")) {
                    System.out.println("Good Bye!");
                    break;
                }

                Place result = LookupZip.lookupZip(places, zip);
                if (result != null) {
                    System.out.println(result);
                } else {
                    System.out.println("No such zipcode");
                }
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found");
        }
    }
}
