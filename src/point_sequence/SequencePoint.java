package point_sequence;

import java.util.Random;
import java.util.Scanner;

public class SequencePoint {
    private Point[] points;
    private int n;
    private Scanner scanner = new Scanner(System.in);

    public SequencePoint() {
        System.out.println("Enter n: ");
        this.n = scanner.nextInt();
        points = new Point[n];
        for (int i = 0; i < this.points.length; i++) {
            points[i] = new Point(new Random().nextInt(100), new Random().nextInt(100));
        }
    }

    public void display() {
        for (int i = 0; i < this.points.length; i++) {
            System.out.println(points[i]);
        }
    }

    public void maxDistance() {
        double max = points[0].calDistance(points[1]);
        Point p1 = points[0];
        Point p2 = points[1];
        for (int i = 0; i < this.points.length - 1; i++) {
            for (int j = i + 1; j < this.points.length; j++) {
                if (max < points[i].calDistance(points[j])) {
                    max = points[i].calDistance(points[j]);
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }
        System.out.println("Khoang cach lon nhat: " + max);
        System.out.println(p1);
        System.out.println(p2);
    }

    public double calAreaTriangle(Point p1, Point p2, Point p3) {
        double result = Math.abs((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY()));
        return result;
    }

    public void maxAreaTriangle() {
        double max = this.calAreaTriangle(points[0], points[1], points[2]);
        Point p1 = points[0];
        Point p2 = points[1];
        Point p3 = points[2];
        for (int i = 0; i < this.points.length - 2; i++) {
            for (int j = i + 1; j < this.points.length - 1; j++) {
                for (int k = j + 1; k < this.points.length; k++) {
                    double temp = calAreaTriangle(points[i], points[j], points[k]);
                    if (max < temp) {
                        max = temp;
                        p1 = points[i];
                        p2 = points[j];
                        p3 = points[k];
                    }
                }
            }
        }
        System.out.println("Dien tich tam giac lon nhat: " + max);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

    public static void main(String[] args) {
        SequencePoint sequencePoint = new SequencePoint();
        sequencePoint.display();
        sequencePoint.maxDistance();
        sequencePoint.maxAreaTriangle();
    }
}
