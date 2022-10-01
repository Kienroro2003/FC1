package Case_Study.Service;

import Case_Study.models.Customer;

public interface ICustomerService extends IService{
    @Override
    void add();

    @Override
    void display();

    void edit(int id);

    Customer findById(int id);
}

