package Case_Study.Repository;

import Case_Study.models.Employee;
import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee>{
    String FILE_NAME="src/Case_Study/Data/employee.dat";

    @Override
    void add(Employee employee);

    @Override
    void display();

    void edit();
    List<Employee>findAll();
}
