package abstract_class;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        for(int i = 0 ; i < 2 ;i++){
            if(i == 0){
                Student student = new Student();
                student.input();
                people.add(student);
            }else{
                Employee employee = new Employee();
                employee.input();
                people.add(employee);
            }
        }
        for(int i = 0 ;i < 2; i++){
            people.get(i).output();
        }
    }
}
