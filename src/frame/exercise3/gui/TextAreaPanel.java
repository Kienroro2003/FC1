package frame.exercise3.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaPanel extends JPanel {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 210;

    private MainPanel mainPanel;
    private JTextArea textArea;

    public TextAreaPanel() {
        initPanel();
        addComps();
    }

    private void addComps() {
        textArea = new JTextArea();
        textArea.setBackground(Color.BLUE);
        textArea.setText("Hello world");
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);
        textArea.setForeground(Color.WHITE);
        textArea.setLineWrap(true);
        this.textArea.setFont(new Font("Tohoma", Font.BOLD, 16));
        JScrollPane jScrollBar = new JScrollPane(textArea);
        jScrollBar.setBounds(0, 0, 400, 210);
        add(jScrollBar);
    }

    public void setFontWeightArea(Font font) {
        textArea.setFont(font);
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void initPanel() {
        setSize(WIDTH, HEIGHT);
        setBackground(Color.WHITE);
        setLocation(100, 0);
        setLayout(null);

    }
}