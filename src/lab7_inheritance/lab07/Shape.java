package lab7_inheritance.lab07;

public abstract class Shape {
    protected final float PI = 3.14f;

    public Shape() {
    }

    public float getPI() {
        return PI;
    }

    public abstract double area();

    public abstract double perimeter();
}
