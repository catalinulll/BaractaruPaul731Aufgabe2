package aufgabe2.controller;

import aufgabe2.model.Club;
import aufgabe2.model.Player;
import aufgabe2.repository.ClubRepository;

import java.util.Comparator;
import java.util.List;

public class ClubController {
    private ClubRepository repository;

    public ClubController(ClubRepository repository) {
        this.repository = repository;
    }

    public void addClub(Club club) {
        repository.addClub(club);
    }

    public void updateClub(Club club) {
        repository.updateClub(club);
    }

    public void deleteClub(int clubId) {
        repository.deleteClub(clubId);
    }

    public Club findClubById(int clubId) {
        return repository.findClubById(clubId);
    }

    public List<Club> getAllClubs() {
        return repository.getAllClubs();
    }

    public List<Player> getPlayersInClub(int clubId) {
        Club club = repository.findClubById(clubId);
        if (club != null) {
            return club.getPlayers();
        }
        return null;
    }

    public List<Player> getPlayersSortedByMarketValue(int clubId, boolean ascending) {
        Club club = repository.findClubById(clubId);
        if (club != null) {
            List<Player> players = club.getPlayers();
            players.sort(Comparator.comparingDouble(Player::getMarketValue));
            if (!ascending) {
                players.sort(Comparator.comparingDouble(Player::getMarketValue).reversed());
            }
            return players;
        }
        return null;
    }
}


