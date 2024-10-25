package ui;

import java.util.Scanner;
import model.Controller;

public class Main {
    private static Controller controller = new Controller();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Tournament Management System:");
            System.out.println("1. Add Player");
            System.out.println("2. Add Referee");
            System.out.println("3. Display People");
            System.out.println("4. Show Top Scorer");
            System.out.println("5. Call Foul (Central Referee)");
            System.out.println("6. Raise Flag (Assistant Referee)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPlayer();
                case 2 -> addReferee();
                case 3 -> displayPeople();
                case 4 -> showTopScorer();
                case 5 -> callFoul();
                case 6 -> raiseFlag();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
        System.out.println("Exiting Tournament Management System.");
    }

    private static void addPlayer() {
        System.out.print("Enter player's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter player's country: ");
        String country = scanner.nextLine();
        System.out.print("Enter player's number: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter player's position (Goalkeeper, Defender, Midfielder, Forward): ");
        String position = scanner.nextLine();

        controller.addPlayer(name, country, number, position);
        System.out.println("Player added successfully.");
    }

    private static void addReferee() {
        System.out.print("Enter referee's ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter referee's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter referee's country: ");
        String country = scanner.nextLine();
        System.out.print("Enter referee's type (Central, Assistant): ");
        String type = scanner.nextLine();

        controller.addReferee(id, name, country, type);
        System.out.println("Referee added successfully.");
    }

    private static void displayPeople() {
        System.out.println(controller.displayPeople());
    }

    private static void showTopScorer() {
        String topScorer = controller.getTopScorer();
        System.out.println("Top Scorer: " + topScorer);
    }

    private static void callFoul() {
        System.out.print("Enter Central Referee ID: ");
        String refereeId = scanner.nextLine();
        System.out.print("Enter foul level (0 = Verbal, 1 = Yellow, 2 = Red): ");
        int level = scanner.nextInt();
        scanner.nextLine();

        String result = controller.refereeCallFoul(refereeId, level);
        System.out.println(result);
    }

    private static void raiseFlag() {
        System.out.print("Enter Assistant Referee ID: ");
        String refereeId = scanner.nextLine();
        System.out.print("Enter foul type: ");
        String foulType = scanner.nextLine();

        boolean result = controller.assistantRefereeRaiseFlag(refereeId, foulType);
        if (result) {
            System.out.println("Flag raised successfully.");
        } else {
            System.out.println("Failed to raise flag.");
        }
    }
}
