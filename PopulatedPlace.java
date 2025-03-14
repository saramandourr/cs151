//package hw01;

public class PopulatedPlace extends LocatedPlace {
    private int population;

    public PopulatedPlace(String zip, String city, String state, double lat, double lon, int population) {
        super(zip, city, state, lat, lon);
        this.population = population;
    }

    public int getPopulation() { return population; }

    @Override
    public String toString() {
        return super.toString() + " " + population;
    }
}
