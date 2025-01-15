package aufgabe2.controller;

import aufgabe2.model.Player;
import aufgabe2.repository.PlayerRepository;

import java.util.List;

public class PlayerController {
    private PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    public void addPlayer(Player player) {
        repository.addPlayer(player);
    }

    public void updatePlayer(Player player) {
        repository.updatePlayer(player);
    }

    public void deletePlayer(int playerId) {
        repository.deletePlayer(playerId);
    }

    public Player findPlayerById(int playerId) {
        return repository.findPlayerById(playerId);
    }

    public List<Player> getAllPlayers() {
        return repository.getAllPlayers();
    }
}

