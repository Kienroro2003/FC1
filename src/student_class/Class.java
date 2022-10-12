package student_class;

import jdk.nashorn.internal.runtime.JSType;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Class {
    private String nameClass;
    private Student[] students = new Student[100];
    private Scanner scanner = new Scanner(System.in);
    private int n = 12;

    public Class() {
    }


    public void defaultInput(){
        this.students[0] = new Student("Kien1","Quang Nam", 8);
        this.students[1] = new Student("Kien2","Hue", 9);
        this.students[2] = new Student("Kien3","Hue", 10);
        this.students[3] = new Student("Kien4","Quang Nam", 8);
        this.students[4] = new Student("Kien5","Quang Nam", 8.8f);
        this.students[5] = new Student("Kien6","Quang Tri", 9.8f);
        this.students[6] = new Student("Kien7","Quang Nam", 10);
        this.students[7] = new Student("Kien8","Quang Nam", 8);
        this.students[8] = new Student("Kien9","Hue", 8);
        this.students[9] = new Student("Kien10","Quang Nam", 6);
        this.students[10] = new Student("A","Thai Binh", 7);
        this.students[11] = new Student("Kien12","Quang Nam", 8);
        this.students[12] = new Student("Kien13","Quang Ngai", 5);
    }

    public void input(){
        System.out.println("Enter n: ");
        this.n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap sinh vien thu " + (i + 1) + ": ");
            System.out.println("Nhap ten: ");
            String name = scanner.nextLine();
            System.out.println("Nhap dia chi: ");
            String address = scanner.nextLine();
            float average = scanner.nextFloat();
            students[i] = new Student(name,address,average);
        }
    }

    public void output(){
        System.out.println("Danh sach lop");
        for (int i = 0; i < n; i++) {
            System.out.println(this.students[i]);
        }
    }

    public void sortByName(){
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if (students[i].getName().trim().toLowerCase().compareTo(students[j].getName().trim().toLowerCase()) > 0){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    public void countAddressHue(){
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(students[i].getAddress().equals("Hue")){
                count++;
            }
        }
        System.out.println("So luong hoc sinh que o Hue: " + count);
    }

    public void superStudent(){
        for (int i = 0; i < n; i++) {
            boolean lonHonTen = students[i].getAverage() + 0.3f > 10;
            if(!lonHonTen){
                students[i].setAverage(students[i].getAverage() + 0.3f);
            }
        }
    }


    public static void main(String[] args) {
        Class c = new Class();
        c.defaultInput();
        c.output();
        c.sortByName();
        c.output();
        c.countAddressHue();
        c.superStudent();
        c.output();
        Student student = new Student();

    }
}
