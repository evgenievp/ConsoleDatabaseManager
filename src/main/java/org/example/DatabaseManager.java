package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/JPARelations";
    private static final String USER = "evgenievp";
    private static final String PASSWORD = "123456";

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();

        String sql = "SELECT id, name, position FROM player";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Player p = new Player(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("position")
                );
                players.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return players;
    }
    public void addPlayer(String name, String position) {
        String sql = "INSERT INTO player (name, position, team_id) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, position);
            stmt.setLong(3, 1); // тук задаваме team_id = 1 за простота

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println(" Player added successfully.");
            } else {
                System.out.println(" Player not added.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
