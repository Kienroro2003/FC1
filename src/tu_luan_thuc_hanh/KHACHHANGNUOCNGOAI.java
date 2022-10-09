package tu_luan_thuc_hanh;

import java.util.Scanner;

public class KHACHHANGNUOCNGOAI extends KHACHHANG{
    private String nationality;

    public KHACHHANGNUOCNGOAI() {
    }

    public KHACHHANGNUOCNGOAI(int id, String name, String date, int cost, float price, String nationality) {
        super(id, name, date, cost, price);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nationality: ");
        this.nationality = scanner.nextLine();
    }

    @Override
    public float tinhThanhTien() {
        return this.amount * this.price;
    }

    @Override
    public String toString() {
        return "KHACHHANGNUOCNGOAI{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
