package frame.exercise2;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(){
        initPanel();
        addComps();
    }

    private void addComps() {
        SortPanel sortPanel = new SortPanel();
        add(sortPanel);
    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(new CardLayout());
    }
}
