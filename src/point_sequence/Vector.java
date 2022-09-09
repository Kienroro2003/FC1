package point_sequence;

public class Vector {
    private Point head;
    private Point tail;

    private int headA;
    private int tailB;

    public Vector() {
    }

    public Vector(Point head, Point tail) {
        this.head = head;
        this.tail = tail;
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public Point getTail() {
        return tail;
    }

    public void setTail(Point tail) {
        this.tail = tail;
    }

    public int getHeadA() {
        return headA;
    }

    public void setHeadA(int headA) {
        this.headA = headA;
    }

    public int getTailB() {
        return tailB;
    }

    public void setTailB(int tailB) {
        this.tailB = tailB;
    }

    private int calHeadA(){
        this.headA = tail.getX() - head.getX();
        return this.headA;
    }

    private int calTailB(){
        this.tailB = tail.getY() - head.getY();
        return this.tailB;
    }

    public double calAngle(Vector vector){
        double result = ((this.calHeadA() * vector.calHeadA()) + (this.calTailB() * vector.calTailB())) / (Math.sqrt(Math.pow(this.calHeadA(),2) + Math.pow(this.calTailB(),2)) * Math.sqrt(Math.pow(vector.calHeadA(),2) + Math.pow(vector.calTailB(),2)));
        return result;
    }



}
