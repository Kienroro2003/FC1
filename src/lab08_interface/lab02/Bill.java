package lab08_interface.lab02;

import java.util.Scanner;

public class Bill {
    private int idCustomer;
    private String customerType;
    private float oldWater;
    private float newWater;

    public Bill() {
    }

    public Bill(int idCustomer, String customerType, float oldWater, float newWater) {
        this.idCustomer = idCustomer;
        this.customerType = customerType;
        this.oldWater = oldWater;
        this.newWater = newWater;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public float getOldWater() {
        return oldWater;
    }

    public void setOldWater(float oldWater) {
        this.oldWater = oldWater;
    }

    public float getNewWater() {
        return newWater;
    }

    public void setNewWater(float newWater) {
        this.newWater = newWater;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id customer: ");
        this.idCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter customer type: ");
        this.customerType = scanner.nextLine();
        System.out.println("Enter old water: ");
        this.oldWater= Float.parseFloat(scanner.nextLine());
        System.out.println("Enter new water: ");
        this.newWater = Float.parseFloat(scanner.nextLine());
    }

    public int price(){
        if(this.customerType.equals("Resident"))return 500;
        else if(this.customerType.equals("Business") || this.customerType.equals("Organization"))return 400;
        return 300;
    }

    public float payment(){
        return this.price() * (this.newWater - this.oldWater);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "idCustomer='" + idCustomer + '\'' +
                ", customerType='" + customerType + '\'' +
                ", oldWater=" + oldWater +
                ", newWater=" + newWater +
                '}';
    }
}
