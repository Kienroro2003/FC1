package frame.jlist_jcombobox.color_panel;


import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    private ColorPanel colorPanel;

    public MainPanel(){
        initPanel();
        addEvents();
        addComps();

    }

    private void addComps() {
        colorPanel = new ColorPanel();
        add(colorPanel);
    }

    private void addEvents() {
    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(new CardLayout());
    }
}
