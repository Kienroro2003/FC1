package tu_luan_thuc_hanh;

import java.util.*;

public class DSKHACHHANG {
    private KHACHHANG[] array;
    private int n;

    public DSKHACHHANG() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        this.n = scanner.nextInt();
        this.array = new KHACHHANG[n];
        for(int i= 0; i < n ; i++){
            System.out.println("1/2");
            System.out.println("Enter choose: ");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:{
                    this.array[i] = new KHACHHANGVIETNAM();
                    this.array[i].input();
                    break;
                }
                case 2:{
                    this.array[i] = new KHACHHANGNUOCNGOAI();
                    this.array[i].input();
                    break;
                }
            }
        }
    }

    public void displayAll(){
        for (int i = 0; i < this.n; i++) {
            System.out.println(array[i]);
        }
    }

    public KHACHHANG findByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id search: ");
        int id = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if(array[i].getId() == id){
                return array[i];
            }
        }
        return null;
    }

    public void updateName(){
        KHACHHANG khachhang = findByID();
        Scanner scanner = new Scanner(System.in);
        if(khachhang == null){
            System.out.println("Khong tim thay khach hang");
        }else{
            System.out.println("Enter name: ");
            khachhang.setName(scanner.nextLine());
        }

    }

    public void sort(){
        Arrays.sort(array, Comparator.comparing(KHACHHANG::tinhThanhTien));
    }

    public static void main(String[] args) {
        DSKHACHHANG dskhachhang = new DSKHACHHANG();
        dskhachhang.displayAll();
        dskhachhang.updateName();
        System.out.println("=========================UPDATE NAME=========================");
        dskhachhang.displayAll();
        System.out.println("=========================SORT=========================");
        dskhachhang.sort();
        dskhachhang.displayAll();
    }
}


