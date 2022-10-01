package lab7_inheritance.lab09;

public abstract class Food {
    protected String description;
    protected double calo;

    public Food() {
    }

    public Food(String description, double calo) {
        this.description = description;
        this.calo = calo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalo() {
        return calo;
    }

    public void setCalo(double calo) {
        this.calo = calo;
    }

    public abstract double calculateCalories(int servings);

    @Override
    public String toString() {
        return "Food{" +
                "description='" + description + '\'' +
                ", calo=" + calo +
                '}';
    }
}
