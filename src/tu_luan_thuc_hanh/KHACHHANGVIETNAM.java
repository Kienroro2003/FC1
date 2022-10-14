package tu_luan_thuc_hanh;

import java.util.Scanner;

public class KHACHHANGVIETNAM extends KHACHHANG{
    private int dinhMuc;
    private String dtKhachHang;

    public KHACHHANGVIETNAM() {
    }

    public KHACHHANGVIETNAM(int id, String name, String date, int cost, float price, int dinhMuc, String dtKhachHang) {
        super(id, name, date, cost, price);
        this.dinhMuc = dinhMuc;
        this.dtKhachHang = dtKhachHang;
    }

    public int getDinhMuc() {
        return dinhMuc;
    }

    public void setDinhMuc(int dinhMuc) {
        this.dinhMuc = dinhMuc;
    }

    public String getDtKhachHang() {
        return dtKhachHang;
    }

    public void setDtKhachHang(String dtKhachHang) {
        this.dtKhachHang = dtKhachHang;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("enter dinh muc: ");
        Scanner scanner = new Scanner(System.in);
        this.dinhMuc = Integer.parseInt(scanner.nextLine());
        System.out.println("Dt khach hang: ");
        this.dtKhachHang = scanner.nextLine();
    }

    @Override
    public float tinhThanhTien() {
        if(this.amount < this.dinhMuc){
            return this.amount * this.price;
        }else{
            return this.price * this.amount * this.dinhMuc + (this.dinhMuc - this.amount) * this.price * 2.5f;
        }
    }

    @Override
    public String toString() {
        return "KHACHHANGVIETNAM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", dinhMuc=" + dinhMuc +
                ", dtKhachHang='" + dtKhachHang + '\'' +
                '}';
    }
}
