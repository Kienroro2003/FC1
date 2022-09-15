package lab7_inheritance.lab01;

import java.util.Scanner;

public class Employee extends Person{
   protected String office;
   protected double salary;
   protected String dateHired;

    public Employee() {
    }

    public Employee(String name, String address, String phoneNumber, String addressEmail, String office, double salary, String dateHired) {
        super(name, address, phoneNumber, addressEmail);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Enter office: ");
        this.office = scanner.nextLine();
        System.out.print("Enter salary: ");
        this.salary = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter date hired: ");
        this.dateHired = scanner.nextLine();
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Office: " + this.office);
        System.out.println("Salary: " + this.salary);
        System.out.println("Date hired: " + this.dateHired);
    }
}
