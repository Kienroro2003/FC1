import com.sun.org.apache.xpath.internal.operations.Number;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class A {
    int i = 9;

    A() {
        this.setI(20);
        System.out.println("i from A is " + i);
    }

    public void setI(int i) {
        this.i = i * 3;
    }
}

class B extends A {
    B() {
        System.out.println("i from A is " + i);
    }

    public void setI(int i) {
        this.i = 4 * i;
    }


}

public class Main {
    public static void main(String[] args) {
        B b = new B();
    }

}
