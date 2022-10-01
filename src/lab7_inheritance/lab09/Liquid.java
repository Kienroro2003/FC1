package lab7_inheritance.lab09;

public class Liquid extends Food{
    private float viscosity;

    public Liquid() {
    }

    public Liquid(String description, double calo, float viscosity) {
        super(description, calo);
        this.viscosity = viscosity;
    }

    public float getViscosity() {
        return viscosity;
    }

    public void setViscosity(float viscosity) {
        this.viscosity = viscosity;
    }

    @Override
    public double calculateCalories(int servings) {
        return 0;
    }

    @Override
    public String toString() {
        return "Liquid{" +
                "description='" + description + '\'' +
                ", calo=" + calo +
                ", viscosity=" + viscosity +
                '}';
    }
}
