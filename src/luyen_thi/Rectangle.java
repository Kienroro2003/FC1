package luyen_thi;

import java.util.Scanner;

public class Rectangle extends Shape{
    private float width;
    private float height;

    public Rectangle() {
    }

    public Rectangle(String name, float width, float height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        this.width = Float.parseFloat(scanner.nextLine());
        System.out.println("Enter height: ");
        this.height = Float.parseFloat(scanner.nextLine());
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public float getArea() {
        return this.width * this.height;
    }

    @Override
    public float getPerimeter() {
        return (this.height + this.width) * 2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", name='" + name + '\'' +
                ", area='" + this.getArea() + '\'' +
                ", perimeter='" + this.getPerimeter() + '\'' +
                '}';
    }
}
