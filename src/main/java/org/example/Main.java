package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Console DB Manager ===");
            System.out.println("1. List all players");
            System.out.println("2. Add new player");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    List<Player> players = db.getAllPlayers();
                    for (Player p : players) {
                        System.out.println(p);
                    }
                }
                case 2 -> {
                    System.out.print("Enter player name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter player position: ");
                    String position = scanner.nextLine();
                    db.addPlayer(name, position);
                }
                case 3 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }
}
