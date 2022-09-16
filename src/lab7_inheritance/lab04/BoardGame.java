package lab7_inheritance.lab04;

import lab7_inheritance.lab02.Game;

public class BoardGame extends Game {
    private int minimumPlayers;
    private boolean limitTime;

    public BoardGame() {
    }

    public BoardGame(String description, int minimumPlayers, boolean limitTime) {
        super(description);
        this.minimumPlayers = minimumPlayers;
        this.limitTime = limitTime;
    }

    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(int minimumPlayers) {
        this.minimumPlayers = minimumPlayers;
    }

    public boolean isLimitTime() {
        return limitTime;
    }

    public void setLimitTime(boolean limitTime) {
        this.limitTime = limitTime;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "minimumPlayers=" + minimumPlayers +
                ", limitTime=" + limitTime +
                ", description='" + description + '\'' +
                '}';
    }
}
