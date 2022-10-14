package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class GUI extends JFrame {
    public static final int WIDTH_FRAME = 500;
    public static final  int HEIGHT_FRAME = 300;

    public GUI(String title){
        initGUI(title);
        addEventsWindow();
        addEventsMouse();
        addEventsKey();
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
        GUI gui = new GUI("Kienroro");
        gui.setVisible(true);
    }

    private void addEventsWindow(){
        WindowListener windowListener = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Activated to the window " + new Date());
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Closing");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Closed");
            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        };
        addWindowListener(windowListener);
    }

    private void addEventsMouse(){
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Clicked");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Pressed");

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Called mouseReleased");

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Went in frame");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Went out frame");

            }
        };
        addMouseListener(mouseListener);
    }

    private void addEventsKey(){
        KeyListener keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        addKeyListener(keyListener);
        setFocusable(true);
        requestFocus();
    }


}
