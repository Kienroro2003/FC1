package frame.jlist_jcombobox.student_panel;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public GUI() throws HeadlessException {
        init();
        addComps();
    }

    private void addComps() {
        StudentPanel studentPanel = new StudentPanel();
        add(studentPanel);

    }

    private void init() {
        setTitle("JList");
        setSize(500, 250);
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}
