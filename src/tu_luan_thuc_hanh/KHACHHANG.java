package tu_luan_thuc_hanh;

import java.util.Scanner;

public abstract class KHACHHANG implements ITIENDIEN {
    protected int id;
    protected String name;
    protected String date;
    protected int amount;
    protected float price;

    public KHACHHANG() {
    }

    public KHACHHANG(int id, String name, String date, int cost, float price) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = cost;
        this.price = price;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id: ");
        this.id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        this.name = scanner.nextLine();
        System.out.println("Enter date: ");
        this.date = scanner.nextLine();
        System.out.println("Enter amount: ");
        this.amount = scanner.nextInt();
        System.out.println("Enter price: ");
        this.price = scanner.nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "KHACHHANG{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", cost=" + amount +
                ", price=" + price +
                '}';
    }
}
