public class CSStudent extends Human {
    public CSStudent() {
        super();
    }

    @Override
    public String getName() {
        return "CSStudent";
    }

    @Override
    public void speak() {
        System.out.print("I love programming!");
    }
}

