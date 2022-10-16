package frame.form.gui;

import frame.form.model.PTB2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTB2Panel extends JPanel {
    private JLabel lbTitle, lbA, lbB, lbC;
    private JButton btKQ;
    private JTextField tfA, tfB, tfC;
    private JTextArea tfKQ;

    public PTB2Panel(){
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {
        this.lbTitle = new JLabel();
        this.lbTitle.setText("PTB2: ax^2 + bx + c");
        this.lbTitle.setBounds(20,20,500,50);
        this.lbTitle.setForeground(Color.BLUE.darker());
        this.lbTitle.setFont(new Font("Arial", Font.PLAIN,30));
        add(lbTitle);

        this.lbA = new JLabel();
        this.lbA.setText("He so A: ");
        this.lbA.setBounds(20,80,300,50);
        this.lbA.setForeground(Color.BLUE.darker());
        this.lbA.setFont(new Font("Arial",Font.PLAIN,16));
        add(this.lbA);

        this.lbB = new JLabel();
        this.lbB.setText("He so B: ");
        this.lbB.setBounds(20,120,300,50);
        this.lbB.setForeground(Color.BLUE.darker());
        this.lbB.setFont(new Font("Arial",Font.PLAIN,16));
        add(this.lbB);

        this.lbC = new JLabel();
        this.lbC.setText("He so C: ");
        this.lbC.setBounds(20,160,300,50);
        this.lbC.setForeground(Color.BLUE.darker());
        this.lbC.setFont(new Font("Arial",Font.PLAIN,16));
        add(this.lbC);

        this.tfA = new JTextField();

        this.tfA.setBounds(100,90,100,30);
        this.tfA.setForeground(Color.BLUE.darker());
        this.tfA.setFont(new Font("Tohoma",Font.PLAIN,16));
        add(this.tfA);

        this.tfB = new JTextField();

        this.tfB.setBounds(100,130,100,30);
        this.tfB.setForeground(Color.BLUE.darker());
        this.tfB.setFont(new Font("Tohoma",Font.PLAIN,16));
        add(this.tfB);

        this.tfC = new JTextField();

        this.tfC.setBounds(100,170,100,30);
        this.tfC.setForeground(Color.BLUE.darker());
        this.tfC.setFont(new Font("Tohoma",Font.PLAIN,16));
        add(this.tfC);

        this.btKQ = new JButton();
        this.btKQ.setText("Giai phuong trinh");
        this.btKQ.setBounds(220,90,100,30);
        this.btKQ.setForeground(Color.BLUE.darker());
        this.btKQ.setFont(new Font("Arial",Font.PLAIN,16));
        this.btKQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Integer.parseInt(tfA.getText());
                double b = Integer.parseInt(tfB.getText());
                double c = Integer.parseInt(tfC.getText());
                PTB2 ptb2 = new PTB2(a, b, c);
                ptb2.timNghiem();
                tfKQ.setText(ptb2.getAnswer());
            }
        });
        add(this.btKQ);

        this.tfKQ = new JTextArea();
        tfKQ.setBackground(Color.ORANGE.darker());
        tfKQ.setWrapStyleWord(true);
        tfKQ.setEditable(false);
        tfKQ.setForeground(Color.WHITE);
        tfKQ.setLineWrap(true);
        this.tfKQ.setFont(new Font("Tohoma",Font.PLAIN,16));
        JScrollPane jScrollBar = new JScrollPane(tfKQ);
        jScrollBar.setBounds(220,130,250,70);
        add(jScrollBar);
    }

    private void addEvents() {

    }

    private void initPanel() {

        setBackground(Color.WHITE);
        setLayout(null);
    }
}
