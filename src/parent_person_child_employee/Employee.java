package parent_person_child_employee;

import java.util.Scanner;

public class Employee extends Person{
    private int salary;

    public Employee() {
    }

    public Employee(String name, int age, String address, int salary) {
        super(name, age, address);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    void inputEmployee(){
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.println("Enter salary: ");
        this.salary = scanner.nextInt();
    }

    void outputEmployee(){
        output();
        System.out.println("Salary: " + salary);
    }
}
