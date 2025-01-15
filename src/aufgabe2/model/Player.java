package aufgabe2.model;

public class Player {
    private int id;
    private String name;
    private int age;
    private String position;
    private double marketValue;

    public Player(int id, String name, int age, String position, double marketValue) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.marketValue = marketValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Position: " + position + ", Market Value: " + marketValue;
    }
}

