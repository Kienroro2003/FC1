package luyen_thi;

import java.util.Scanner;

public class Circle extends Shape{
    private float radius;

    public Circle() {
    }

    public Circle(String name, float radius) {
        super(name);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Enter radius: ");
        Scanner scanner = new Scanner(System.in);
        this.radius = Float.parseFloat(scanner.nextLine());
    }

    @Override
    public float getArea() {
        return this.radius * this.radius * PI;
    }

    @Override
    public float getPerimeter() {
        float diameter = this.radius * 2;
        return diameter * PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", name='" + name + '\'' +
                ", area='" + this.getArea() + '\'' +
                ", perimeter='" + this.getPerimeter() + '\'' +
                '}';
    }
}
