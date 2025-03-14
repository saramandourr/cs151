//package hw01;

public class LocatedPlace extends Place {
    private double latitude;
    private double longitude;

    public LocatedPlace(String zip, String city, String state, double lat, double lon) {
        super(zip, city, state);
        this.latitude = lat;
        this.longitude = lon;
    }

    public double getLatitude() { return latitude; }
    public double getLongitude() { return longitude; }

    @Override
    public String toString() {
        return super.toString() + " " + latitude + " " + longitude;
    }
}

