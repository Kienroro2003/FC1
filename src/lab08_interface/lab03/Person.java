package lab08_interface.lab03;

public abstract class Person {
    protected String code;
    protected String name;
    protected int rank;

    public Person() {
    }

    public Person(String code, String name, int rank) {
        this.code = code;
        this.name = name;
        this.rank = rank;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public abstract String description();

    public void display(){
        System.out.println("Employee code: " + code);
        System.out.println("Employee name: " + name);
        System.out.println("Rank: " + rank);
    }
}
