package lab08_interface.lab03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonList {
    Person[] people;
    int n = 7;

    public PersonList() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter n: ");
//        this.n = scanner.nextInt();
        this.people = new Person[n];
        this.people[0] = new Professor("1","a",1,"na");
        this.people[1] = new Professor("4","d",5,"na");
        this.people[2] = new Professor("2","b",2,"wer");
        this.people[3] = new Professor("3","a",4,"nwer");
        this.people[4] = new Student("5","r",2,"LA",2021);
        this.people[5] = new Student("8","r",6,"LA",2021);
        this.people[6] = new Student("7","r",3,"LA",2021);
    }
    public void displayAll(){
        for (int i = 0; i < n; i++) {
            System.out.println("-----------------------Person " + (i + 1) + "-----------------------");
            this.people[i].display();
        }
    }
    public void average(){
        int total=0;
        for (int i = 0; i < n; i++) {
            total += people[i].getRank();
        }
        System.out.println("Average rank: "+ ((float)total / n));
    }

    public void maxRank(){
        Person max = people[0];
        for (Person person:people){
            if(max.rank < person.rank){
                max= person;
            }
        }
        System.out.println("Nguoi co rank cao nhat: ");
        max.display();
    }

    public void removePerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id: ");
        String code = scanner.nextLine();
        Person[] tempPerson = new Person[people.length - 1];
        for (int i = 0, k = 0; i < this.people.length; i++) {
            if(this.people[i].getCode().equals(code))continue;
            tempPerson[k++] = this.people[i];
        }
        this.people = tempPerson;
        n--;
    }
}
