package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();

        System.out.println("=== All Players ===");
        List<Player> players = db.getAllPlayers();
        for (Player p : players) {
            System.out.println(p);
        }
    }
}