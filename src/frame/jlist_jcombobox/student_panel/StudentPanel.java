package frame.jlist_jcombobox.student_panel;

import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {
    private JList<Student> studentJList;

    public StudentPanel() {
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {

    }

    private void addEvents() {
        DefaultListModel<Student> studentModel = new DefaultListModel<>();
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
        this.studentJList = new JList<>();
        this.studentJList.setVisibleRowCount(5);
        this.studentJList.setModel(studentModel);
        this.studentJList.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.studentJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(this.studentJList);
        scrollPane.setBounds(0,0,200,200);
        add(scrollPane);
    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }

    public static void main(String[] args) {
        StudentPanel studentPanel = new StudentPanel();
        studentPanel.setVisible(true);
    }
}
