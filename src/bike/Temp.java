package bike;

abstract class Bike {
    int limit = 30;
    abstract void run();

    public Bike() {
        System.out.println("Constructor is invoked");
    }

    void getDetail(){
        System.out.println();
    }

    void changeGear() {
        System.out.println("gear change");
    }
}

class Honda extends Bike {

    @Override
    void run() {
        System.out.println("running");
    }
}

public class Temp {
    public static void main(String[] args) {
        Bike obj = new Honda();
        obj.run();
        obj.changeGear();
    }
}
