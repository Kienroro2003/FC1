package luyen_thi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListShape listShape = new ListShape();
        listShape.add();
        listShape.display();
        System.out.println("Enter name to search: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        listShape.findShapeByName(name);
        System.out.println("Enter name to remove: ");
        String nameRemove = scanner.nextLine();
        listShape.removeShapeByName(nameRemove);
        listShape.display();
        int main = 10;
    }
}
