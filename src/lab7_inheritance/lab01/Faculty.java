package lab7_inheritance.lab01;

import java.util.Scanner;

public class Faculty extends Person{
    private String officeHours;
    private int rank;

    public Faculty() {
    }

    public Faculty(String name, String address, String phoneNumber, String addressEmail, String officeHours, int rank) {
        super(name, address, phoneNumber, addressEmail);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Enter office hours: ");
        this.officeHours = scanner.nextLine();
        System.out.print("Enter rank: ");
        this.rank = scanner.nextInt();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Office hours: " + this.officeHours);
        System.out.println("Rank: " + this.rank);
    }
}
