package aufgabe2.repository;



import aufgabe2.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    private List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void updatePlayer(Player updatedPlayer) {
        for (Player player : players) {
            if (player.getId() == updatedPlayer.getId()) {
                player.setName(updatedPlayer.getName());
                player.setAge(updatedPlayer.getAge());
                player.setPosition(updatedPlayer.getPosition());
                player.setMarketValue(updatedPlayer.getMarketValue());
                return;
            }
        }
    }

    public void deletePlayer(int playerId) {
        players.removeIf(player -> player.getId() == playerId);
    }

    public Player findPlayerById(int playerId) {
        return players.stream().filter(player -> player.getId() == playerId).findFirst().orElse(null);
    }

    public List<Player> getAllPlayers() {
        return players;
    }
}


