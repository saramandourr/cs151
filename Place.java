//package hw01;

public class Place {
    protected String zip;
    protected String city;
    protected String state;

    public Place(String zip, String city, String state) {
        this.zip = zip;
        this.city = city;
        this.state = state;
    }

    public String getZip() { return zip; }
    public String getCity() { return city; }
    public String getState() { return state; }
    
    public String getTown() {
        return getCity();
    }

    @Override
    public String toString() { 
        return city + ", " + state; 
    }
}
