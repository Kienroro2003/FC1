package frame.jlist_jcombobox.color_combobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends JPanel {
    private JComboBox<ItemColor> listColor;
    private JButton btPha;
    private JPanel plBackground;
    public ColorPanel(){
        initPanel();
        addComps();
        addEvents();
    }

    private void addEvents() {
        btPha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = ((ItemColor)listColor.getSelectedItem()).getColor();
                plBackground.setBackground(color);
            }
        });
    }

    private void addComps() {
        DefaultComboBoxModel<ItemColor> colorModel = new DefaultComboBoxModel<>();
        colorModel.addElement(new ItemColor(Color.RED,"Red"));
        colorModel.addElement(new ItemColor(Color.GREEN,"Green"));
        colorModel.addElement(new ItemColor(Color.BLUE,"Blue"));
        colorModel.addElement(new ItemColor(Color.MAGENTA,"Magenta"));
        colorModel.addElement(new ItemColor(Color.YELLOW,"Yellow"));
        colorModel.addElement(new ItemColor(Color.PINK,"Pink"));
        listColor = new JComboBox<>();
        listColor.setModel(colorModel);
        listColor.setSelectedIndex(0);
        listColor.setPopupVisible(false);
        listColor.setBounds(0,0,200,60);
        btPha = new JButton("Pha mau");
        btPha.setBounds(50,60,100,40);
        plBackground = new JPanel();
        plBackground.setBackground(Color.GREEN);
        plBackground.setBounds(0,100,205,80);
        add(listColor);
        add(btPha);
        add(plBackground);
    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }
}
