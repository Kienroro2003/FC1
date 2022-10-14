package frame.exercise3.gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 250;

    private MainPanel ptb2Panel;

    public GUI(){
        setTitle("Font weight");
        initGUI();
        addEvents();
        addComps();
    }

    private void addComps() {
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);

    }

    private void addEvents() {

    }

    private void initGUI() {
        this.setSize(WIDTH, HEIGHT);
        getContentPane().setBackground(Color.CYAN);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new CardLayout());
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setVisible(true);
    }
}
