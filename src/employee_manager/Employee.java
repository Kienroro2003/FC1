//package employee_manager;
//
//import java.text.NumberFormat;
//import java.util.Scanner;
//
//public class Employee {
//    protected String name;
//    protected double coefficientsSalary;
//
//    public Employee() {
//    }
//
//    public Employee(String name, float coefficientsSalary) {
//        this.name = name;
//        this.coefficientsSalary = coefficientsSalary;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getCoefficientsSalary() {
//        return coefficientsSalary;
//    }
//
//    public void setCoefficientsSalary(double coefficientsSalary) {
//        this.coefficientsSalary = coefficientsSalary;
//    }
//
//    public void input(){
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter name: ");
//        this.name = scanner.nextLine();
//        System.out.println("Enter coefficients salary: ");
//        this.coefficientsSalary = Double.parseDouble(scanner.nextLine());
//    }
//
//    public void output(){
//        System.out.println("Name: " + this.name);
//        System.out.println("Coefficients salary: " + this.coefficientsSalary);
//        System.out.println("Salary without: " + NumberFormat.getInstance().format(this.calculateSalary()));
//    }
//
//    public double calculateSalary(){
//        return this.coefficientsSalary * 1500000;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + name + '\'' +
//                ", coefficientsSalary=" + coefficientsSalary +
//                '}';
//    }
//
//
//}
