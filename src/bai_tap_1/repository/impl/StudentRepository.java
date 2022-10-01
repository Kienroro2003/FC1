package bai_tap_1.repository.impl;

import bai_tap_1.model.Student;
import bai_tap_1.repository.IStudentRepository;
import bai_tap_1.util.ReadAndWriteStudent;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private ReadAndWriteStudent readAndWriteStudent = new ReadAndWriteStudent();
    private List<Student> studentList = readAndWriteStudent.readStudent(FILE_NAME);

//    public StudentRepository() {
//        this.studentList = readAndWriteStudent.readStudent(FILE_NAME);
//    }

    @Override
    public void add(Student student) {
        this.studentList.add(student);
        readAndWriteStudent.writeStudent(this.studentList,FILE_NAME);
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }
}
