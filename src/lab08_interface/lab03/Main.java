package lab08_interface.lab03;

public class Main {
    public static void main(String[] args) {
        PersonList personList = new PersonList();
        personList.displayAll();
        System.out.println("========================");
        personList.average();
        System.out.println("========================");
        personList.maxRank();
        System.out.println("========================");
        personList.removePerson();
        personList.displayAll();
    }
}
