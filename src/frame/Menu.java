package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu extends JPanel {
    private MainPanel mainPanel;

    public Menu(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public Menu(){
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {
    }

    private void addEvents() {
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                mainPanel.showPlayGame();
            }
        };
        addMouseListener(mouseListener);
    }

    private void initPanel() {

        setBackground(Color.CYAN);
        setLayout(null);
    }
}
