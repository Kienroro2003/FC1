package frame.exercise2;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 250;

    public GUI()  {
        setTitle("Sort");
        init();
        addComps();
    }

    private void addComps() {
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
    }

    private void init() {
        setSize(WIDTH, HEIGHT);
        getContentPane().setBackground(Color.WHITE);
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
