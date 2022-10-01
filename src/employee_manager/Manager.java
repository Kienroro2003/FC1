//package employee_manager;
//
//import java.text.NumberFormat;
//import java.util.Scanner;
//
//public class Manager extends Employee {
//    private String office;
//    private double subsidiesSalary;
//
//    public Manager() {
//    }
//
//    public Manager(String name, float coefficientsSalary, String office, double subsidiesSalary) {
//        super(name, coefficientsSalary);
//        this.office = office;
//        this.subsidiesSalary = subsidiesSalary;
//    }
//
//    public String getOffice() {
//        return office;
//    }
//
//    public void setOffice(String office) {
//        this.office = office;
//    }
//
//    public double getSubsidiesSalary() {
//        return subsidiesSalary;
//    }
//
//    public void setSubsidiesSalary(double subsidiesSalary) {
//        this.subsidiesSalary = subsidiesSalary;
//    }
//
//    @Override
//    public void input() {
//        super.input();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter office: ");
//        this.office = scanner.nextLine();
//        System.out.println("Enter subsidies salary: ");
//        this.subsidiesSalary = scanner.nextDouble();
//    }
//
//    @Override
//    public void output() {
//        super.output();
//        System.out.println("Office: " + this.office);
//        System.out.println("Subsidies salary: " + this.subsidiesSalary);
//        System.out.println("Salary: " + NumberFormat.getInstance().format(this.calculateSalary()));
//    }
//
//    @Override
//    public double calculateSalary() {
//        return super.calculateSalary() + this.subsidiesSalary;
//    }
//
//    @Override
//    public String toString() {
//        return "Manager{" +
//                "name='" + name + '\'' +
//                ", coefficientsSalary=" + coefficientsSalary +
//                ", office='" + office + '\'' +
//                ", subsidiesSalary=" + subsidiesSalary +
//                '}';
//    }
//
//
//}
