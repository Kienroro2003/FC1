package abstract_class;

import java.util.Scanner;

public class Person {
    private Scanner scanner = new Scanner(System.in);
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String addressEmail;

    public Person() {
    }

    public Person(String name, String address, String phoneNumber, String addressEmail) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.addressEmail = addressEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddressEmail() {
        return addressEmail;
    }

    public void setAddressEmail(String addressEmail) {
        this.addressEmail = addressEmail;
    }

    public void input(){
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter address: ");
        this.address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        this.phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        this.addressEmail = scanner.nextLine();
    }

    public void output(){
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Email address: " + addressEmail);
    }
}
