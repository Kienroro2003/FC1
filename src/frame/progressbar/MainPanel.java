package frame.progressbar;

import frame.Menu;
import frame.PlayGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainPanel extends JPanel {
    private  JProgressBar progressBar;
    public MainPanel(){
        initPanel();
        addEvents();
        adComps();
    }

    private void adComps() {
        progressBar  = new JProgressBar();
        progressBar.setBackground(Color.BLUE);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.blue);
        UIManager uiManager = new UIManager();
        uiManager.put("JProgressBar.selectionForeground", Color.GREEN);
        progressBar.setFont(new Font("Arial", Font.BOLD, 16));
        progressBar.setMaximum(1000);
        progressBar.setMinimum(0);
        progressBar.setValue(100);
        progressBar.setBounds(20,20,250,30);
        progressBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                progressBar.setValue(progressBar.getValue() + 100);
            }
        });
        add(progressBar);
    }

    private void addEvents() {

    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }
}
