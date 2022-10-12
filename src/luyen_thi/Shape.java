package luyen_thi;

import java.util.Objects;
import java.util.Scanner;

public abstract class Shape implements IShape{
    protected String name;

    public Shape() {
    }

    public Shape(String name) {
        this.name = name;
    }

    public void input() {
        System.out.println("Enter name shape: ");
        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(name, shape.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public abstract String toString();
}
