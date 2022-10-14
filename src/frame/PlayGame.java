package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayGame extends JPanel {
    private MainPanel mainPanel;

    public PlayGame(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public PlayGame() {
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
                mainPanel.showMenuGame();
            }
        };
        addMouseListener(mouseListener);
    }

    private void initPanel() {
        setBackground(Color.BLUE);
        setLayout(null);
    }


}
