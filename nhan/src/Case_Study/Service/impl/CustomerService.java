package Case_Study.Service.impl;

import Case_Study.Repository.ICustomerRepository;
import Case_Study.Repository.impl.CustomerRepository;
import Case_Study.Service.ICustomerService;
import Case_Study.models.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    ICustomerRepository iCustomerRepository = new CustomerRepository();
    List<Customer> customerList = iCustomerRepository.findAll();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        Customer customer = new Customer();
        customer.input();
        iCustomerRepository.add(customer);
    }

    @Override
    public void display() {
        LinkedList<Customer> customerLinkedList = iCustomerRepository.findAll();
        if (customerLinkedList.isEmpty()) {
            System.out.println("Khong co du lieu");
        } else {
            for (Customer customer : customerLinkedList) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void edit(int id) {
        LinkedList<Customer> customerLinkedList = iCustomerRepository.findAll();
        for (Customer customer : customerLinkedList) {
            if (customer.getIdCode() == (id)) {
                do {
                    System.out.println("1.Sua id.");
                    System.out.println("2.Sua ten.");
                    System.out.println("3.Sua ngay sinh.");
                    System.out.println("4.Sua gioi tinh.");
                    System.out.println("5.Sua so dien thoai.");
                    System.out.println("6.Sua so email.");
                    System.out.println("7.Sua trinh do.");
                    System.out.println("8.Sua vi tri.");
                    System.out.println("9.Quay lai:");
                    System.out.println("Nhap vao lua chon:");
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
//                        case 1: {
//                            System.out.println("Nhap vao id:");
//                            String idCode = scanner.nextLine();
//                            customer.setIdCode(idCode);
//                            break;
//                        }
                        case 2: {
                            System.out.println("Nhap vao ten:");
                            String name = scanner.nextLine();
                            customer.setName(name);
                            break;
                        }
                        case 3: {
                            System.out.println("Nhap vao ngay sinh:");
                            int dayOfBirth = Integer.parseInt(scanner.nextLine());
                            customer.setDateOfBirth(dayOfBirth);
                            break;
                        }
                        case 4: {
                            System.out.println("Nhap vao gioi tinh:");
                            String gender = scanner.nextLine();
                            customer.setGender(gender);
                            break;
                        }
                        case 5: {
                            System.out.println("Nhap vao so dien thoai:");
                            int phoneNumber = Integer.parseInt(scanner.nextLine());
                            customer.setPhoneNumber(phoneNumber);
                            break;
                        }
                        case 6: {
                            System.out.println("Nhap vao email:");
                            String email = scanner.nextLine();
                            customer.setEmail(email);
                            break;
                        }
                        case 7: {
                            System.out.println("Nhap vao loai khach:");
                            String customerType = scanner.nextLine();
                            customer.setCustomerType(customerType);
                            break;
                        }
                        case 8: {
                            System.out.println("Nhap vao dia chi:");
                            String address = scanner.nextLine();
                            customer.setAddress(address);
                            break;
                        }
                        case 9: {
                            return;
                        }
                    }
                } while (true);
            }

        }
    }

    @Override
    public Customer findById(int id) {
        LinkedList<Customer> customerLinkedList = this.iCustomerRepository.findAll();
        for (Customer c :
                customerLinkedList) {
            if (c.getIdCode() == id) {
                return c;
            }
        }
        return null;
    }
}
