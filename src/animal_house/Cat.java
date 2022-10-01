package animal_house;

import java.util.Scanner;

public class Cat extends Animal{
    private String name;
    private int age;
    private boolean gender;

    public Cat() {
    }

    public Cat(String food, float weight, String name, int age, boolean gender) {
        super(food, weight);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter age");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter gender: ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void output() {
        System.out.println("Tôi là mèo. Tên của tôi là " + this.name +", tôi ăn " + this.food +", cho nên cân nặng của tôi là " + this.weight + " kg. Năm nay tôi vừa tròn " + this.age +" tuổi, tôi có giới tính là " + (this.gender?"male":"female"));
    }


}
