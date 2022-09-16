package lab7_inheritance.lab02;

public class Game {
    protected String description;

    public Game() {
    }

    public Game(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "description='" + description + '\'' +
                '}';
    }
}
