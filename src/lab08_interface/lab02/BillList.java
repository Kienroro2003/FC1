package lab08_interface.lab02;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BillList {
    private Bill[] bills;
    private int n;
    Scanner scanner = new Scanner(System.in);

    public BillList() {
        System.out.println("Enter n: ");
        this.n = scanner.nextInt();
        this.bills = new Bill[n];
        for (int i = 0; i < n; i++) {
            bills[i] = new Bill();
            bills[i].input();
        }
    }

    public void total(){
        float result = 0;
        for (int i = 0; i < this.n; i++) {
            result += bills[i].payment();
        }
        System.out.println("Total: " + NumberFormat.getInstance().format(result));
    }

    public void remove(){
        System.out.println("Enter id remove: ");
        String idRemove = scanner.nextLine();
        for (int i = 0; i < bills.length; i++) {
            if(idRemove == bills[i].getIdCustomer()){
                bills =(Bill[]) IntStream.range(0, bills.length).filter(j -> j != Integer.parseInt(idRemove)).mapToObj(j -> bills[j]).toArray();
            }
        }
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
