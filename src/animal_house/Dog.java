package animal_house;

import java.util.Scanner;

public class Dog extends Animal{
    private String type;

    public Dog() {
    }

    public Dog(String food, float weight, String type) {
        super(food, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type: ");
        this.type = scanner.nextLine();
    }

    @Override
    public void output() {
        System.out.println("Hello! Tôi là chó. Tôi là giống chó " + this.type + ", tôi ăn " + this.food +" và cân nặng của tôi là " + this.weight +" kg");
    }
}
