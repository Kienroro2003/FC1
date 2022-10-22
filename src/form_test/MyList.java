package form_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyList {
    private List<Person> personList;
    private Scanner scanner;

    public MyList() {
        personList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("1. Display all");
            System.out.println("2. Create");
            System.out.println("3. Edit");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Find by id");
            System.out.println("7. Sort");
            System.out.println("7. Exit");
            System.out.println("Enter choose: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1: {
                    System.out.println("===============DISPLAY ALL===============");
                    displayAll();
                    break;
                }
                case 2: {
                    System.out.println("===============ADD===============");
                    add();
                    break;
                }
                case 3: {
                    System.out.println("===============EDIT===============");
                    break;
                }
                case 4: {
                    System.out.println("===============DELETE===============");
                    System.out.println("Enter id: ");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    Person person = findPersonById(idDelete);
                    deletePerson(person);
                    break;
                }
                case 5: {
                    System.out.println("===============FIND BY ID===============");
                    System.out.println("Enter id: ");
                    int idFind = Integer.parseInt(scanner.nextLine());
                    System.out.println(findPersonById(idFind));
                    break;
                }
                case 6: {
                    System.out.println("===============SORT===============");
                    break;
                }
                case 7:{
                    System.exit(0);
                }
                default: {
                    System.err.println("Your selection is not on the list. Please choose selection again");
                }
            }
        }
    }

    private void displayAll() {
        for (Person person : this.personList) {
            System.out.println(person);
        }
    }

    private Person create() {
        System.out.println("1. Student");
        System.out.println("2. Professor");
        Person person = null;
        int chooseObject = Integer.parseInt(scanner.nextLine());
        switch (chooseObject) {
            case 1: {
                person = new Student();
                person.input();
                break;
            }
            case 2: {
                person = new Professor();
                person.input();
                break;
            }
        }
        return person;
    }

    private void add() {
        boolean isContinue = true;
        do {
            Person person = create();
            this.personList.add(person);
            System.out.println("Are you stop(Y/N)?");
            String statusWhile = scanner.nextLine();
            if (statusWhile.equalsIgnoreCase("Y")) {
                isContinue = false;
            }
        } while (isContinue);
    }

    public Person findPersonById(int id) {
        for (Person person : this.personList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void deletePerson(Person person){
        if(person == null){
            System.out.println("Not found!");
        }else{
            System.out.println("Are you sure deleted person has name " + person.getName() + " and ID " + person.id);
            System.out.println("Are you sure(Y/N)?");
            String statusWhile = scanner.nextLine();
            if (statusWhile.equalsIgnoreCase("Y")) {
                this.personList.remove(person);
                System.out.println("Delete success!");
            }
        }
    }

}
