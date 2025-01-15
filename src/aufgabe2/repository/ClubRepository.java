package aufgabe2.repository;


import aufgabe2.model.Club;

import java.util.ArrayList;
import java.util.List;

public class ClubRepository {
    private List<Club> clubs;

    public ClubRepository() {
        this.clubs = new ArrayList<>();
    }

    public void addClub(Club club) {
        clubs.add(club);
    }

    public void updateClub(Club updatedClub) {
        for (Club club : clubs) {
            if (club.getId() == updatedClub.getId()) {
                club.setName(updatedClub.getName());
                club.setCity(updatedClub.getCity());
                return;
            }
        }
    }

    public void deleteClub(int clubId) {
        clubs.removeIf(club -> club.getId() == clubId);
    }

    public Club findClubById(int clubId) {
        return clubs.stream().filter(club -> club.getId() == clubId).findFirst().orElse(null);
    }

    public List<Club> getAllClubs() {
        return clubs;
    }
}
