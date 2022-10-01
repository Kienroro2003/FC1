package arraylist_linkedlist_java;

import java.util.*;

import java.util.Scanner;

public class Class {
    private String nameClass;
    private static List<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int n = 12;

    public Class() {
    }


    static {
        students.add(new Student("Kien1", "Quang Nam", 8));
        students.add(new Student("Kien2", "Hue", 9));
        students.add(new Student("Kien3", "Hue", 10));
        students.add(new Student("Kien4", "Quang Nam", 8));
        students.add(new Student("Kien5", "Quang Nam", 8.8f));
        students.add(new Student("Kien6", "Quang Tri", 9.8f));
        students.add(new Student("Kien7", "Quang Nam", 10));
        students.add(new Student("Kien8", "Quang Nam", 8));

    }

    public void add() {
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.println("Nhap dia chi: ");
        String address = scanner.nextLine();
        float average = scanner.nextFloat();
        students.add(new Student(name, address, average));
    }

    public void output() {
        System.out.println("Danh sach lop");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }

    public void sortByNameComparable() {
        Collections.sort(students);
    }

    public void sortByNameComparatorComparing() {
        students.sort(Comparator.comparing(Student::getName));
    }

    public void sortByNameTwoObject() {
        students.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
    }

    public void countAddressHue() {
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAddress().equals("Hue")) {
                count++;
            }
        }
        System.out.println("So luong hoc sinh que o Hue: " + count);
    }

    public void sortByNameTwoFor() {
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if(students.get(i).getName().equals(students.get(j).getName())){
                    Student temp = students.get(i);
                    students.set(i,students.get(j));
                    students.set(j, temp);
                }
            }
        }

    }

    public void superStudent() {
        for (int i = 0; i < students.size(); i++) {
            boolean lonHonTen = students.get(i).getAverage() + 0.3f > 10;
            if (!lonHonTen && students.get(i).getAddress().equals("Quang Nam")) {
                students.get(i).setAverage(students.get(i).getAverage() + 0.3f);
            }
        }
    }


    public static void main(String[] args) {
        Class c = new Class();
        c.output();
        c.sortByNameComparable();
        c.output();
        c.countAddressHue();
        c.superStudent();
        c.output();
    }

}
