package point_sequence;

import java.util.*;

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
        Stack<Point> pointStack = new Stack<>();
        for(Point p : points){
            pointStack.push(p);
        }
        this.convexHull(pointStack);
        System.out.println(pointStack);
        pointStack.push(pointStack.get(0));
        System.out.println(pointStack);
        int sumXY = 0;
        int sumYX = 0;
        for (int i = 0; i < pointStack.size() - 1; i++) {
            sumXY += pointStack.get(i).getX() * pointStack.get(i+1).getY();
            sumYX += pointStack.get(i).getY() * pointStack.get(i+1).getX();
        }
        double area = (sumXY - sumYX) /2f;
        return area;
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
                if((points[i].getX() > points[j].getX()) || (points[i].getX() == points[j].getX() && points[i].getY() > points[j].getY())){
                    Point temp = points[i];
                    points[i] = points[j];
                    points[j] = temp;
                }
            }
        }
    }

    private boolean cw (Point a, Point b, Point c) { // a -> b -> c đi theo thứ tự xuôi chiều kim đồng hồ
        return a.getX()*(b.getY()-c.getY())+b.getX()*(c.getY()-a.getY())+c.getX()*(a.getY()-b.getY()) < 0;
    }

    private boolean ccw (Point a, Point b, Point c) { // a -> b -> c đi theo thứ tự ngược chiều kim đồng hồ
        return a.getX()*(b.getY()-c.getY())+b.getX()*(c.getY()-a.getY())+c.getX()*(a.getY()-b.getY()) > 0;
    }

    public void convexHull(Stack<Point> pointStack) {
        if (pointStack.size() == 1) { // chỉ có 1 điểm
            return;
        }

        // Sắp xếp các điểm theo tọa độ x, nếu bằng nhau sắp xếp theo y
        Collections.sort(pointStack, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.getX() > o2.getX() || o1.getX() == o2.getX() && o1.getY() > o2.getY()){
                    return 1;
                }
                return -1;
            }
        });
        System.out.println(pointStack);

        Point head = pointStack.get(0),  tail = pointStack.peek();

        Stack<Point> upperHull = new Stack<>();
        Stack<Point> lowerHull = new Stack<>();
        upperHull.push(head);
        lowerHull.push (head);

        for (int i=1; i<pointStack.size(); ++i) {
            if (i==pointStack.size()-1 || cw (head, pointStack.get(i), tail)) {
                while (upperHull.size()>=2 && !cw (upperHull.get(upperHull.size()-2), upperHull.get(upperHull.size()-1), pointStack.get(i)))
                    upperHull.pop();
                upperHull.push (pointStack.get(i));
            }

            if (i==pointStack.size()-1 || ccw (head, pointStack.get(i), tail)) {
                while (lowerHull.size()>=2 && !ccw (lowerHull.get(lowerHull.size()-2), lowerHull.get(lowerHull.size()-1), pointStack.get(i)))
                    lowerHull.pop();
                lowerHull.push(pointStack.get(i));
            }
        }

        pointStack.clear();
        for (int i=0; i<upperHull.size(); ++i)
            pointStack.push(upperHull.get(i));
        for (int i=lowerHull.size()-2; i>0; --i)
            pointStack.push(lowerHull.get(i));
    }


    public static void main(String[] args) {
        SequencePoint sequencePoint = new SequencePoint();
//        sequencePoint.display();
//        sequencePoint.max()Distance();
//        sequencePoint.maxAreaTriangle();
//        sequencePoint.displayTest();
//        sequencePoint.display();
//        sequencePoint.sortPoints();
//        System.out.println("----------------------------------- ");
//        sequencePoint.display();
        System.out.println(sequencePoint.calAreaPolygon());
        System.out.println("Hello");
    }
}
