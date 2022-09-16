package parent_person_child_employee;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter age: ");
        this.age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter address: ");
        this.address = scanner.nextLine();
    }

    public void output(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}
