package Case_Study.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public abstract class Facility implements Serializable {
    protected String serviceName;
    protected double area;
    protected double rentalCost;
    protected int maxPeople;
    protected String rentalType;

    public Facility() {
        this.serviceName = "";
    }

    public Facility(String serviceName, double area, double rentalCost, int maxPeople, String rentalType) {
        this.serviceName = serviceName;
        this.area=area;
        this.rentalCost = rentalCost;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao ten dich vu: ");
        this.serviceName = scanner.nextLine();
        System.out.println("Nhap vao dien tich su dung: ");
        this.area = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap vao thue: ");
        this.rentalCost = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap vao so nguoi toi da:");
        this.maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap vao kieu thue: ");
        this.rentalType = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "serviceName='" + serviceName + '\'' +
                ", Area=" + area +
                ", rentalCost=" + rentalCost +
                ", maxPeople=" + maxPeople +
                ", rentalType=" + rentalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return this.toString().equals(facility.toString());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
