package exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 1000000000; i++) {
            integers.add(i);
        }
        
        System.out.println("Hello world");
    }
}
