package lab7_inheritance.lab05_lab06.lab06;

import lab7_inheritance.lab05_lab06.Store;

public class Restaurant extends Store {
    private int peopleOfYear;
    private double avgPricePerson;

    public Restaurant() {
    }

    public Restaurant(String newName, int peopleOfYear, double avgPricePerson) {
        super(newName);
        this.peopleOfYear = peopleOfYear;
        this.avgPricePerson = avgPricePerson;
    }

    public int getPeopleOfYear() {
        return peopleOfYear;
    }

    public void setPeopleOfYear(int peopleOfYear) {
        this.peopleOfYear = peopleOfYear;
    }

    public double getAvgPricePerson() {
        return avgPricePerson;
    }

    public void setAvgPricePerson(double avgPricePerson) {
        this.avgPricePerson = avgPricePerson;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", peopleOfYear=" + peopleOfYear +
                ", avgPricePerson=" + avgPricePerson +
                '}';
    }
}
