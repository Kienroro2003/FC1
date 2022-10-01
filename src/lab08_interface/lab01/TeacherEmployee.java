package lab08_interface.lab01;

public class TeacherEmployee implements Comparable{
    private  int age;

    public TeacherEmployee(int age) {
        this.age = age;
    }

    public TeacherEmployee() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int compareTo(TeacherEmployee employee){
        if(this.age > employee.age)return 1;
        else if (this.age < employee.age) return -1;
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return compareTo(0);
    }

    @Override
    public String toString() {
        return "TeacherEmployee{" +
                "age=" + age +
                '}';
    }
}
