import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DriverHW02 {
    static class SearchRequest {
        String flag;
        String name;
        SearchRequest(String flag, String name) {
            this.flag = flag;
            this.name = name;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 0) {
            System.out.println("Usage: java DriverHW02 [flags and names] [file names]");
            return;
        }
        int i = 0;
        int numRequests = 0;
        while(i < args.length && args[i].startsWith("-")) {
            i += 2;
            numRequests++;
        }
        SearchRequest[] requests = new SearchRequest[numRequests];
        for(int j = 0, k = 0; j < i; j += 2, k++) {
            requests[k] = new SearchRequest(args[j], args[j+1]);
        }
        if(i >= args.length) {
            System.out.println("No input files provided.");
            return;
        }
        NameLL maleLL = new NameLL();
        NameLL femaleLL = new NameLL();
        for(; i < args.length; i++) {
            String fileName = args[i];
            File file = new File(fileName);
            if(!file.exists()) {
                System.out.println("File not found: " + fileName);
                continue;
            }
            String baseName = file.getName();
            int year = 0;
            try {
                year = Integer.parseInt(baseName.substring(5,9));
            } catch(Exception e) {
                System.out.println("Could not extract year from file name: " + fileName);
                continue;
            }
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if(parts.length < 5) continue;
                int rank = Integer.parseInt(parts[0].trim());
                String maleName = parts[1].trim();
                int maleNumber = Integer.parseInt(parts[2].trim());
                String femaleName = parts[3].trim();
                int femaleNumber = Integer.parseInt(parts[4].trim());
                maleLL.insertOrUpdate(maleName, year, rank, maleNumber);
                femaleLL.insertOrUpdate(femaleName, year, rank, femaleNumber);
            }
            sc.close();
        }
        for(int j = 0; j < requests.length; j++) {
            SearchRequest req = requests[j];
            NameLL list = req.flag.equals("-m") ? maleLL : femaleLL;
            int idx = list.index(req.name);
            if(idx == -1) {
                System.out.println("That name isn't in our data.");
            } else {
                System.out.println(idx);
                for(int year = 1990; year <= 2017; year++) {
                    double[] stats = list.yearStats(req.name, year);
                    if(stats != null) {
                        System.out.println(year);
                        System.out.printf("%s: %d, %d, %.6f\n", req.name, (int)stats[0], (int)stats[1], stats[2]);
                    }
                }
                double[] total = list.totalStats(req.name);
                if(total != null) {
                    System.out.println("Total");
                    System.out.printf("%s: %d, %d, %.6f\n", req.name, (int)total[0], (int)total[1], total[2]);
                }
            }
            System.out.println();
        }
    }
}
