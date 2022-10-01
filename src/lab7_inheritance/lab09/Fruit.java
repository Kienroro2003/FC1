package lab7_inheritance.lab09;

public class Fruit extends Food{
private String season;

    public Fruit(String season) {
        this.season = season;
    }

    public Fruit(String description, double calo, String season) {
        super(description, calo);
        this.season = season;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public double calculateCalories(int servings) {
        return 0;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "description='" + description + '\'' +
                ", calo=" + calo +
                ", season='" + season + '\'' +
                '}';
    }
}
