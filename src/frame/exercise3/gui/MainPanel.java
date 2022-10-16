package frame.exercise3.gui;

import frame.exercise3.model.PTB2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    private TextAreaPanel textAreaPanel;
    private CheckBoxPanel checkBoxPanel;

    public MainPanel(){
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {
        textAreaPanel = new TextAreaPanel();
        textAreaPanel.setMainPanel(this);
        checkBoxPanel = new CheckBoxPanel();
        checkBoxPanel.setMainPanel(this);
        add(textAreaPanel);
        add(checkBoxPanel);
    }

    private void addEvents() {

    }

    private void initPanel() {
        setBackground(Color.CYAN);
        setLayout(null);

    }

    public void setFontWeight(String style){
        Font font = null;
        switch (style){
            case "bold":{
                font = new Font("Arial",Font.BOLD,16);
                break;
            }
            case "italic":{
                font = new Font("Arial",Font.ITALIC,16);
                break;
            }
            case "plain":{
                font = new Font("Arial",Font.PLAIN,16);
                break;
            }
        }
        this.textAreaPanel.setFontWeightArea(font);
    }
}
