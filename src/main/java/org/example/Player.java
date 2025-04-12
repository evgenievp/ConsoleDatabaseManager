package org.example;

public class Player {
    private long id;
    private String name;
    private String position;

    public Player(){}

    public Player(long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;

    }



        @Override
        public String toString() {
            return "[" + id + "] " + name + " - " + position;
        }

}
