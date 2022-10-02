package Case_Study.models;

import java.util.Scanner;

public class Room extends Facility {
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, double area, double rentalCost, int maxPeople, String rentalType, String freeService) {
        super(serviceName, area, rentalCost, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao dich vu mien phi di kem: ");
        this.freeService = scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", area=" + area +
                ", rentalCost=" + rentalCost +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
