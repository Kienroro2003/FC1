package point_sequence;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calDistance(Point param){
        double result = Math.sqrt(Math.pow((this.x - param.y),2) + Math.pow(this.y - param.y, 2));
        return result;
    }

    @Override
    public String toString() {
        return "\nPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
