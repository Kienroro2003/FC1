package frame.checkbox;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH_FRAME = 300;
    public static final  int HEIGHT_FRAME = 200;

    public GUI(String title){
        initGUI(title);
        addComponents();
    }

    private void addComponents(){
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
    }

    private void initGUI(String title){
        setTitle(title);
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        getContentPane().setBackground(Color.BLUE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());
    }

    public static void main(String[] args) {
        GUI gui = new GUI("Checkbox color");
        gui.setVisible(true);
    }


}
