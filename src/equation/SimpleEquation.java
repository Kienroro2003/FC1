package equation;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SimpleEquation {
    protected int numberB;
    protected int numberC;

    public SimpleEquation() {
    }

    public SimpleEquation(int numberB, int numberC) {
        this.numberB = numberB;
        this.numberC = numberC;
    }

    public int getNumberB() {
        return numberB;
    }

    public void setNumberB(int numberB) {
        this.numberB = numberB;
    }

    public int getNumberC() {
        return numberC;
    }

    public void setNumberC(int numberC) {
        this.numberC = numberC;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số a: ");
        this.numberC = scanner.nextInt();
        System.out.println("Nhập vào số b: ");
        this.numberC = scanner.nextInt();
    }

    public void solveSimpleEquation(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");    // làm tròn đến 2 chữ số thập phân
        System.out.println("Phương trình bạn vừa nhập vào là: " + this.numberB + "x + " + this.numberC + " = 0.");
        if (this.numberC == 0) {
            if (this.numberC == 0) {
                System.out.println("Phương trình này có vô số nghiệm.");
            } else {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            double result = (double) -this.numberC / this.numberB;   // ép kiểu để cho ra kết quả chính xác
            System.out.println("Phương trình có nghiệm x = " + decimalFormat.format(result) + ".");
        }
    }
}
