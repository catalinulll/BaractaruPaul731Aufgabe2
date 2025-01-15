package aufgabe2.model;


import java.util.ArrayList;
import java.util.List;

public class Club {
    private int id;
    private String name;
    private String city;
    private List<Player> players;

    public Club(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.players = new ArrayList<>();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Vereine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stadt='" + city + '\'' +
                ", spielerListe=" + players +
                '}';
    }
}
