package lab7_inheritance.lab01;

import java.util.Scanner;

public class Staff extends Employee{
    private String title;

    public Staff() {
    }

    public Staff(String name, String address, String phoneNumber, String addressEmail, String office, double salary, String dateHired, String title) {
        super(name, address, phoneNumber, addressEmail, office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Enter title: ");
        this.title = scanner.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Title: " + title);
    }
}
