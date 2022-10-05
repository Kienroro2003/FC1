package lab08_interface.lab02;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BillList {
    private static Bill[] bills;
    private int n;
    Scanner scanner = new Scanner(System.in);

    static {
        bills = new Bill[5];
        bills[0] = new Bill(1,"1",2,10);
        bills[1] = new Bill(2,"1",2,10);
        bills[2] = new Bill(3,"1",2,10);
        bills[3] = new Bill(4,"1",2,10);
        bills[4] = new Bill(5,"1",2,10);
    }

    public BillList() {
//        System.out.println("Enter n: ");
//        this.n = scanner.nextInt();
//        this.bills = new Bill[n];
//        for (int i = 0; i < n; i++) {
//            bills[i] = new Bill();
//            bills[i].input();
//        }
    }

    void display(){
        for (int i = 0; i < bills.length; i++) {
            System.out.println(bills[i]);
        }
    }

    public void total(){
        float result = 0;
        System.out.println("Enter type: ");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        for (int i = 0; i < this.n; i++) {
            if(bills[i].getCustomerType().equals(type)){
                result += bills[i].payment();
            }
        }
        System.out.println("Total: " + NumberFormat.getInstance().format(result));
    }

    public void remove(){
        display();
        System.out.println("Enter id remove: ");
        int idRemove = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < bills.length; i++) {
            if(bills[i].getIdCustomer() == idRemove){
                Bill[] cloneBills = new Bill[bills.length - 1];
                for (int j = 0, k = 0; j < bills.length; j++) {
                    if(j == i)continue;
                    cloneBills[k++] = bills[j];
                }
                bills = cloneBills;
                break;
            }
        }
        display();
    }

    public void maxPayment(){
        Bill result = bills[0];
        for (int i = 1; i < n; i++) {
            if(result.payment() < bills[i].payment()){
                result = bills[i];
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        BillList billList = new BillList();
        billList.total();
        billList.maxPayment();
        billList.remove();
    }
}
