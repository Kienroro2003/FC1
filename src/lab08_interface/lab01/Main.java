package lab08_interface.lab01;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TeacherEmployee[] employees = new TeacherEmployee[10];
        System.out.println("First: ");
        for (int i = 0; i < 10; i++) {
            employees[i] = new TeacherEmployee(new Random().nextInt(100));
            System.out.println(employees[i]);
        }
        System.out.println("Last: ");
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 10; j++) {
                if(employees[i].compareTo(employees[j]) == 1){
                    TeacherEmployee temp = employees[i];
                    employees[i] = employees[j];
                    employees[j] = temp;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(employees[i]);
        }
    }
}
