package lab08_interface.lab01;

public class Employee implements Comparable<Employee>{
    private int age;

    public Employee() {
    }

    public Employee(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        if(this.age > o.age)return 1;
        else if(this.age < o.age) return -1;
        return 0;
    }
}
