package hw00;
public class Place {
    private String zip;
    private String town;
    private String state;

    public Place(String zip, String town, String state) {
        this.zip = zip;
        this.town = town;
        this.state = state;
    }
    public String getZip() {
        return zip;
    }
    public String getTown() {
        return town;
    }
    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return town + " " + state;
    }
}