package frame.exercise3.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxPanel extends JPanel {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 210;

    private static final String BOLD = "bold";
    private static final String ITALIC = "italic";
    private static final  String PLAIN = "plain";

    private MainPanel mainPanel;

    private JCheckBox bold;
    private JCheckBox italic;
    private JCheckBox plain;

    private JButton button;

    public CheckBoxPanel() {
        initPanel();
        addComps();
    }

    private void addComps() {
        bold = new JCheckBox();
        italic = new JCheckBox();
        plain = new JCheckBox();
        button = new JButton();
        bold.setBackground(Color.WHITE);
        bold.setText("Bold");
        bold.setFont(new Font("Arial",Font.PLAIN, 16));
        bold.setBounds(0,0,100,40);
        add(bold);

        italic.setBackground(Color.WHITE);
        italic.setText("Italic");
        italic.setFont(new Font("Arial",Font.PLAIN, 16));
        italic.setBounds(0,50,100,40);
        add(italic);

        plain.setBackground(Color.WHITE);
        plain.setText("Plain");
        plain.setFont(new Font("Arial",Font.PLAIN, 16));
        plain.setBounds(0,100,100,40);
        add(plain);

        button.setText("Apply");
        button.setBounds(0,160,100,50);
        button.setForeground(Color.RED);
        button.setBackground(Color.BLUE);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = "";
                if(bold.isSelected()){
                    select = BOLD;
                }
                if(italic.isSelected()){
                    select = ITALIC;
                }
                if(plain.isSelected()){
                    select = PLAIN;
                }
                mainPanel.setFontWeight(select);
            }
        });
        add(button);
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    private void initPanel() {
        setSize(WIDTH,HEIGHT);
        setBackground(Color.ORANGE);
    }
}
