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

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
        public String toString() {
            return "[" + id + "] " + name + " - " + position;
        }

}
