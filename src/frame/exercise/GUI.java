package frame.exercise;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int WIDTH = 550;
    private static final int HEIGHT = 550;

    public GUI(String title) {
        init(title);
        addComponents();
    }

    private void addComponents() {
//        for(int i = 0 ;i < 3; i++){
//            for(int j = 0; j < 3; j++){
                Box box = new Box();
                box.setLocation(400, 400);
                box.setBackground(Color.orange);
                add(box);
//            }
//        }
    }

    private void init(String title) {
        setTitle(title);
        setSize(WIDTH,HEIGHT);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }

    public static void main(String[] args) {
        GUI gui = new GUI("Box");
        gui.setVisible(true);
    }
}
