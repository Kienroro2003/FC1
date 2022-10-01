package Case_Study.util;

import Case_Study.models.Customer;
import Case_Study.models.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCustomer {
    LinkedList<Customer> customerLinkedList;
    public LinkedList<Customer> readCustomer(String filePath){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(filePath);
            ois = new ObjectInputStream(fis);
            customerLinkedList = (LinkedList<Customer>)  ois.readObject();
        } catch (EOFException e) {
            System.out.println("Day la loi EOF" + e);
            this.customerLinkedList = new LinkedList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return customerLinkedList;
    }
    public void writeCustomer(LinkedList<Customer>customerLinkedList,String filePath){
        try {
            FileOutputStream fos=new FileOutputStream(filePath);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(customerLinkedList);
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
