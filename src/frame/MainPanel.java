package frame;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    // Define variables is JPanel1, 2, .., n
    private Menu menu;
    private PlayGame playGame;
    public MainPanel(){
        initPanel();
        addComps();
    }

    private void initPanel(){
        setBackground(Color.WHITE);
        setLayout(new CardLayout());
    }

    public void showMenuGame(){
        this.menu.setVisible(true);
    }

    public void showPlayGame(){
        this.playGame.setVisible(true);
    }

    private void addComps(){
        menu = new Menu();
        menu.setMainPanel(this);
        add(menu);
        playGame = new PlayGame();
        playGame.setMainPanel(this);
        add(playGame);
    }
}
