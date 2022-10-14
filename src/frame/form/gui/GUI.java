package frame.form.gui;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 250;

    private PTB2Panel ptb2Panel;

    public GUI(){
        setTitle("PTB@");
        initGUI();
        addEvents();
        addComps();
    }

    private void addComps() {
        this.ptb2Panel = new PTB2Panel();
        add(ptb2Panel);

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
}
