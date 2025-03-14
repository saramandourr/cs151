public class Mammal {
    private String name;
    private String sound;
    private static ExpandableArray<Mammal> mammals = new ExpandableArray<>();

    public Mammal(String name, String sound) {
        this.name = name;
        this.sound = sound;
        mammals.insert(this);
    }

    public String getName() { return name; }
    public String getSound() { return sound; }

    public void speak() { System.out.print(sound); }
    public boolean laysEggs() { return false; }
    public boolean livesInWater() { return false; }

    public static ExpandableArray<Mammal> getMammals() {
        return mammals;
    }
}
