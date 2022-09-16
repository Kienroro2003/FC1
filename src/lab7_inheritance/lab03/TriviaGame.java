package lab7_inheritance.lab03;

import lab7_inheritance.lab02.Game;

public class TriviaGame extends Game {
    private double totalMoney;
    private int numberQuestion;

    public TriviaGame() {
    }

    public TriviaGame(String description, double totalMoney, int numberQuestion) {
        super(description);
        this.totalMoney = totalMoney;
        this.numberQuestion = numberQuestion;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "TriviaGame{" +
                "totalMoney=" + totalMoney +
                ", numberQuestion=" + numberQuestion +
                ", description='" + description + '\'' +
                '}';
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }
}
