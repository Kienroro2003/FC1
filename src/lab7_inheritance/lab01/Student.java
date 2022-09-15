package lab7_inheritance.lab01;

import java.util.Scanner;

public class Student extends Person{
    private String status;

    public Student() {
    }

    public Student(String name, String address, String phoneNumber, String addressEmail, String status) {
        super(name, address, phoneNumber, addressEmail);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.print("Status: ");
        final String[] s = {"Freshman", "Sophomore", "Junior", "Senior"};
        for (int i = 0 ; i < 4; i++){
            System.out.println((i + 1) + " " + s[i]);
        }
        System.out.print("Enter choose: ");
        int choose = scanner.nextInt();
        while(choose > 4 || choose < 1){
            System.out.print("Enter again choose: ");
            choose = scanner.nextInt();
        }
        this.status = s[choose - 1];
    }

    @Override
    public void output() {
        super.output();
        System.out.println("Status: " + this.status);
    }
}
