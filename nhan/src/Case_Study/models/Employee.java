package Case_Study.models;

import java.util.Scanner;

public class Employee extends Person {
    private int level;
    private String location;
    private double salary;

    public Employee() {
    }

    public Employee(int idCode, String name, int dateOfBirth, String gender, int phoneNumber, String email, int level, String location, double salary) {
        super(idCode, name, dateOfBirth, gender, phoneNumber, email);
        this.level = level;
        this.location = location;
        this.salary = salary;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.println("Nhap vao trinh do: ");
        this.level = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vao vi tri: ");
        this.location = scanner.nextLine();
        System.out.println("Nhap vao trinh luong: ");
        this.salary = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "level=" + level +
                ", location='" + location + '\'' +
                ", salary=" + salary +
                ", idCode='" + idCode + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
