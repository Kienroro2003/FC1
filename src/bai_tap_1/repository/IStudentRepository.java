package bai_tap_1.repository;

import bai_tap_1.model.Student;
import bai_tap_1.model.Teacher;

import java.util.List;

public interface IStudentRepository {
    String FILE_NAME="/Users/kienroro2003/Documents/My MacOS/DuyTan/Fundamentals of Computing/FC1/src/bai_tap_1/data/data.dat";
    void add(Student student);
    List<Student>getAll();

}
