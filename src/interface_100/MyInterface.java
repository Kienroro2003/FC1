package interface_100;

interface printable{
    void print();
}

interface info{
    void display();
}


interface showable extends printable, info{
    void show();
}

class A implements showable{
    static {
        System.out.println("Hello static A");

    }

    @Override
    public void print() {
        System.out.println("print");
    }

    @Override
    public void show() {
        System.out.println("Welcome");
    }

    @Override
    public void display() {

    }
}


public class MyInterface {
    public static void main(String[] args) {
        A obj = new A();
        printable printable = new A();
        printable.print();
        obj.print();
        obj.show();
    }

}
