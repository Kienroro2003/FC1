package bai_tap_1.util;

import bai_tap_1.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteStudent {
    public List<Student> readStudent(String filePath) {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (IOException e) {
            System.out.println("Loi file");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }
    public void writeStudent(List<Student>studentList, String filePath){
        try {
            FileOutputStream fos=new FileOutputStream(filePath);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
            oos.close();
        }catch (IOException e){
            System.out.println("loi file");
        }
    }
}
