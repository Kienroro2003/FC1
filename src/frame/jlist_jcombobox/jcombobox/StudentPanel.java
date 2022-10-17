package frame.jlist_jcombobox.jcombobox;

import frame.jlist_jcombobox.student_panel.Student;

import javax.swing.*;
import java.awt.*;


public class StudentPanel extends JPanel {
    private JComboBox<Student> jComboBox;

    public StudentPanel() {
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {

    }

    private void addEvents() {
        DefaultComboBoxModel<Student> studentModel = new DefaultComboBoxModel<>();
        studentModel.addElement(new Student("Thanh",23));
        studentModel.addElement(new Student("Lan",21));
        studentModel.addElement(new Student("Huong",25));
        studentModel.addElement(new Student("Tuan",21));
        studentModel.addElement(new Student("Hung",23));
        studentModel.addElement(new Student("Mai",24));
        studentModel.addElement(new Student("Linh",26));
        studentModel.addElement(new Student("Hang",18));
        studentModel.addElement(new Student("Ha",17));
        studentModel.addElement(new Student("Ngoc",22));
        studentModel.addElement(new Student("Anh",29));
        this.jComboBox = new JComboBox<>();
        this.jComboBox.setModel(studentModel);
        this.jComboBox.setBounds(0,0,200,50);
        add(jComboBox);
    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }

}
