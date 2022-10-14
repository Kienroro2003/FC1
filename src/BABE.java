import java.io.*;
import java.util.Scanner;

public class BABE {
    static int count_divisors(int num){
        int total = 0;
        for(int i = 1; i < num; i++){
            if(num % i == 0){
                total += i;
            }
        }
        return total;
    }
    public static void main(String[] args) throws FileNotFoundException {
        if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
            System.setIn(new FileInputStream(new File("input.txt")));
            System.setOut(new PrintStream(new File("output.txt")));
        }
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        int a = in.nextInt();
        int b = in.nextInt();
        if(count_divisors(a) == b && a ==  count_divisors(b)){
            out.print("YES");
        }else{
            out.print("NO");
        }
    }
}
