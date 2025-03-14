public class Main {
    public static void main(String[] args) {
    
        new Dolphin();
        new Platypus();
        new Human();
        new CSStudent();

        ExpandableArray<Mammal> mammals = Mammal.getMammals();

        for (int i = 0; i < mammals.size(); i++) {
            Mammal m = mammals.get(i);
            System.out.print("Generally, a " + m.getName());
            System.out.print(" can be found ");
            if (!m.livesInWater()) {
                System.out.print("on land, ");
            } else {
                System.out.print("in water, ");
            }

            System.out.print("it can ");
            if (!m.laysEggs()) {
                System.out.print("not ");
            }
            System.out.print("lay eggs, and is often overheard saying '");
            m.speak();
            System.out.println("'");
        }
    }
}
