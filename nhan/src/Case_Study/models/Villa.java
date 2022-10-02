package Case_Study.models;

import java.util.Scanner;

public class Villa extends Facility {
    private String roomStandard;
    private double lakeArea;
    private int floor;

    public Villa() {
    }

    public Villa(String serviceName, double area, double rentalCost, int maxPeople, String rentalType, String roomStandard, double lakeArea, int floor) {
        super(serviceName, area, rentalCost, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.lakeArea = lakeArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getLakeArea() {
        return lakeArea;
    }

    public void setLakeArea(double lakeArea) {
        this.lakeArea = lakeArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * public Villa infoVilla() {
     * System.out.println("Nhap vao ten dich vu: ");
     * String serviceName = scanner.nextLine();
     * System.out.println("Nhap vao dien tich su dung: ");
     * double usableArea = Double.parseDouble(scanner.nextLine());
     * System.out.println("Nhap vao thue: ");
     * double rentalCost = Double.parseDouble(scanner.nextLine());
     * System.out.println("Nhap vao so nguoi toi da:");
     * int maxPeople = Integer.parseInt(scanner.nextLine());
     * System.out.println("Nhap vao kieu thue: ");
     * String rentalType = scanner.nextLine();
     * System.out.println("Nhap vao tieu chuan phong: ");
     * String roomStandard = scanner.nextLine();
     * System.out.println("Nhap vao dien tich ho boi: ");
     * double lakeArea = Double.parseDouble(scanner.nextLine());
     * System.out.println("Nhap vao so tang: ");
     * int floor = Integer.parseInt(scanner.nextLine());
     * return new Villa(serviceName, usableArea, rentalCost, maxPeople, rentalType, roomStandard, lakeArea, floor);
     * }
     */
    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao tieu chuan phong: ");
        this.roomStandard = scanner.nextLine();
        System.out.println("Nhap vao dien tich ho boi: ");
        this.lakeArea = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhap vao so tang: ");
        this.floor = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandard='" + roomStandard + '\'' +
                ", lakeArea=" + lakeArea +
                ", floor=" + floor +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", rentalCost=" + rentalCost +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
