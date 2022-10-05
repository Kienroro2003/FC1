package lab08_interface.lab03;

import com.sun.org.apache.xerces.internal.impl.xs.util.XSObjectListImpl;

import java.util.Scanner;

public class Professor extends Person {
    private String department;

    public Professor(String code, String name, int rank, String department) {
        super(code, name, rank);
        this.department = department;
    }

    public Professor() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Description: " + description());
        System.out.println("Department: " + this.department);
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        super.input();
        System.out.println("Nhap vao phong ban: ");
        this.department = scanner.nextLine();
    }


    @Override
    public String description() {
        String desProfessor = "";
        switch (this.getRank()) {
            case 0: {
                desProfessor = "None";
                break;
            }
            case 1: {
                desProfessor = "Assistant Professor";
                break;
            }
            case 2: {
                desProfessor = "Associate Professor";
                break;
            }
            case 3: {
                desProfessor = "Professor";
                break;
            }
            case 4: {
                desProfessor = "Assistant Teaching Professor";
                break;
            }
            case 5: {
                desProfessor = "Associate Teaching Professor";
                break;
            }
            case 6: {
                desProfessor = "Teaching Professor";
                break;
            }
        }
        return desProfessor;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", description: " + description() +
                ", department='" + department + '\'' +
                '}';
    }


}
