import aufgabe2.controller.ClubController;
import aufgabe2.controller.PlayerController;
import aufgabe2.model.Club;
import aufgabe2.model.Player;
import aufgabe2.repository.ClubRepository;
import aufgabe2.repository.PlayerRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        ClubRepository clubRepository = new ClubRepository();
        PlayerController playerController = new PlayerController(playerRepository);
        ClubController clubController = new ClubController(clubRepository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Football Club Management ---");
            System.out.println("1. Add Club");
            System.out.println("2. Edit Club");
            System.out.println("3. Delete Club");
            System.out.println("4. Display All Clubs");
            System.out.println("5. Add Player");
            System.out.println("6. Edit Player");
            System.out.println("7. Delete Player");
            System.out.println("8. Display All Players");
            System.out.println("9. Display Players in Club");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Club ID: ");
                    int clubId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Club Name: ");
                    String clubName = scanner.nextLine();
                    System.out.print("Enter Club City: ");
                    String city = scanner.nextLine();
                    clubController.addClub(new Club(clubId, clubName, city));
                    System.out.println("Club added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Club ID to Edit: ");
                    int editClubId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Club Name: ");
                    String newClubName = scanner.nextLine();
                    System.out.print("Enter New Club City: ");
                    String newCity = scanner.nextLine();
                    clubController.updateClub(new Club(editClubId, newClubName, newCity));
                    System.out.println("Club updated successfully!");
                    break;

                case 3:
                    System.out.print("Enter Club ID to Delete: ");
                    int deleteClubId = scanner.nextInt();
                    clubController.deleteClub(deleteClubId);
                    System.out.println("Club deleted successfully!");
                    break;

                case 4:
                    System.out.println("All Clubs:");
                    for (Club c : clubController.getAllClubs()) {
                        System.out.println(c);
                    }
                    break;

                case 5:
                    System.out.print("Enter Player ID: ");
                    int playerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Player Name: ");
                    String playerName = scanner.nextLine();
                    System.out.print("Enter Player Age: ");
                    int playerAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Player Position: ");
                    String playerPosition = scanner.nextLine();
                    System.out.print("Enter Player Market Value: ");
                    double marketValue = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Club ID for the Player: ");
                    int playerClubId = scanner.nextInt();
                    scanner.nextLine();

                    Club clubForPlayer = clubController.findClubById(playerClubId);
                    if (clubForPlayer != null) {
                        Player player = new Player(playerId, playerName, playerAge, playerPosition, marketValue);
                        clubForPlayer.addPlayer(player);
                        playerController.addPlayer(player);
                        System.out.println("Player added successfully!");
                    } else {
                        System.out.println("Club not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Player ID to Edit: ");
                    int editPlayerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Player Name: ");
                    String newPlayerName = scanner.nextLine();
                    System.out.print("Enter New Player Age: ");
                    int newPlayerAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Player Position: ");
                    String newPlayerPosition = scanner.nextLine();
                    System.out.print("Enter New Player Market Value: ");
                    double newMarketValue = scanner.nextDouble();
                    scanner.nextLine();

                    Player playerToEdit = playerController.findPlayerById(editPlayerId);
                    if (playerToEdit != null) {
                        playerToEdit.setName(newPlayerName);
                        playerToEdit.setAge(newPlayerAge);
                        playerToEdit.setPosition(newPlayerPosition);
                        playerToEdit.setMarketValue(newMarketValue);
                        playerController.updatePlayer(playerToEdit);
                        System.out.println("Player updated successfully!");
                    } else {
                        System.out.println("Player not found!");
                    }
                    break;

                case 7:
                    System.out.print("Enter Player ID to Delete: ");
                    int deletePlayerId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Club ID of the Player: ");
                    int clubIdForDeletion = scanner.nextInt();
                    scanner.nextLine();

                    Club clubWithPlayer = clubController.findClubById(clubIdForDeletion);
                    if (clubWithPlayer != null) {
                        Player playerToDelete = playerController.findPlayerById(deletePlayerId);
                        if (playerToDelete != null) {
                            clubWithPlayer.removePlayer(playerToDelete);
                            playerController.deletePlayer(deletePlayerId);
                            System.out.println("Player deleted successfully!");
                        } else {
                            System.out.println("Player not found!");
                        }
                    } else {
                        System.out.println("Club not found!");
                    }
                    break;

                case 8:
                    System.out.println("All Players:");
                    for (Player p : playerController.getAllPlayers()) {
                        System.out.println(p);
                    }
                    break;

                case 9:
                    System.out.print("Enter Club ID: ");
                    int clubIdForDisplay = scanner.nextInt();
                    scanner.nextLine();
                    Club clubToDisplay = clubController.findClubById(clubIdForDisplay);
                    if (clubToDisplay != null) {
                        System.out.println("Players in Club " + clubToDisplay.getName() + ":");
                        for (Player p : clubToDisplay.getPlayers()) {
                            System.out.println(p);
                        }
                    } else {
                        System.out.println("Club not found!");
                    }
                    break;



                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
