package frame.jlist_jcombobox.color_panel;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class GUI extends JFrame {
    public static final int WIDTH = 505;
    public static final int HEIGHT = 230;

    public GUI(String title) {
        initGUI(title);
        addEvents();
        addComps();
    }

    private void addComps() {
        MainPanel mainPanel = new MainPanel();
        add(mainPanel);
    }

    private void addEvents() {
    }

    private void initGUI(String title) {
        setTitle(title);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new CardLayout());
        try {
            UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI("Color");
        gui.setVisible(true);
    }
}
