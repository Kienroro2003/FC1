package test;

class A{
    A(){
//        System.out.println("A");
    }
    String mess(){
        return "A";
    }
    void out(){
        System.out.println(mess());
    }
}

class B extends A{
    B(){
//        System.out.println("B");
    }
    String mess(){
        return "B";
    }
}

public class test {
    public static void main(String[] args) {
        new A().out();
        new B().out();

    }
}
