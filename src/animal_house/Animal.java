package animal_house;

import java.util.Scanner;

public abstract class Animal {
    protected String food;
    protected float weight;

    public Animal() {
    }

    public Animal(String food, float weight) {
        this.food = food;
        this.weight = weight;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter food: ");
        this.food = scanner.nextLine();
        System.out.println("Enter weight: ");
        this.weight = Float.parseFloat(scanner.nextLine());
    }

    public abstract void output();
}
