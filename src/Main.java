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



                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
