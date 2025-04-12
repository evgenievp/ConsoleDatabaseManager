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

}
