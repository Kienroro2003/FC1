package frame.checkbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainPanel extends JPanel {
    private JCheckBox red, blue, green;
    private MouseAdapter mouseAdapter;

    public MainPanel(){
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {
        red = new JCheckBox();
        red.setBounds(20,20,100,30);
        red.setText("Red");
        red.setForeground(Color.RED);
        red.addMouseListener(mouseAdapter);

        green = new JCheckBox();
        green.setBounds(20,50,100,30);
        green.setText("Green");
        green.setForeground(Color.GREEN);
        green.addMouseListener(mouseAdapter);


        blue = new JCheckBox();
        blue.setBounds(20,80,100,30);
        blue.setText("Blue");
        blue.setForeground(Color.BLUE);
        blue.addMouseListener(mouseAdapter);

        add(red);
        add(green);
        add(blue);
    }

    private void addEvents() {
        mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                doClickCheckBox();
            }
        };
    }

    private void doClickCheckBox() {
        int r = 0;
        int b = 0;
        int g = 0;
        if(red.isSelected()){
            r = 255;
        }
        if(blue.isSelected()){
            b = 255;
        }
        if(green.isSelected()){
            g = 255;
        }
        if(r == 0 && b == 0 && g == 0){
            r = b = g = 255;
        }
        setBackground(new Color(r,g,b));
        red.setBackground(new Color(r,g,b));
        green.setBackground(new Color(r,g,b));
        blue.setBackground(new Color(r,g,b));
    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }
}
