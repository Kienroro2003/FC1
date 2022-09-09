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
            points[i] = new Point(new Random().nextInt(10), new Random().nextInt(10));
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

    public double calAreaPolygon(){
        double sumXY = 0;
        double sumYX = 0;
        for (int i = 0; i < this.points.length - 1; i++) {
            sumXY += points[i].getX() * points[i + 1].getY();
            sumYX += points[i].getY() * points[i + 1].getX();
        }
        sumXY += points[points.length - 1].getX() * points[0].getY();
        sumYX += points[points.length - 1].getY() * points[0].getX();
        double result = (sumYX + sumXY) / 2;
        return result;
    }

    public Point maxPointYX(){
        Point max = points[0];
        for (int i = 1; i < points.length; i++){
            if(max.getY() < points[i].getY()){
                max = points[i];
            }else if(max.getY() == points[i].getY() && max.getX() < points[i].getX()){
                max = points[i];
            }
        }
        return max;
    }

    public void sortPoints(){
        for (int i = 0; i < this.points.length - 1; i++) {
            for (int j = i + 1; j <  this.points.length; j++) {
                if(points[i].getX() < points[j].getX() || points[i].getX() == points[j].getX() && points[i].getY() < points[j].getY()){
                    Point temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
    }

    public void displayTest(){
        Vector vector1 = new Vector(new Point(1,9), new Point(1,6));
        Vector vector2 = new Vector(new Point(1,6), new Point(2,4));
        Vector vector3 = new Vector(new Point(1,6), new Point(1,2));
        System.out.println("He so goc 1: " + vector1.calAngle(vector2));
        System.out.println("He so goc 2: " + vector1.calAngle(vector3));
    }


    public static void main(String[] args) {
        SequencePoint sequencePoint = new SequencePoint();
//        sequencePoint.display();
//        sequencePoint.maxDistance();
//        sequencePoint.maxAreaTriangle();
//        sequencePoint.displayTest();
        sequencePoint.display();
        sequencePoint.sortPoints();
        System.out.println("----------------------------------- ");
        sequencePoint.display();
    }
}
