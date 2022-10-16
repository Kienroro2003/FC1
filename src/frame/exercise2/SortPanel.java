package frame.exercise2;

import frame.form.model.PTB2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortPanel extends JPanel {
    private JLabel  textInput, textOutput;
    private JButton btKQ;
    private JTextField input, output;

    public SortPanel(){
        initPanel();
        addEvents();
        addComps();
    }

    private void addComps() {
        this.textInput = new JLabel();
        this.textInput.setText("Day so: ");
        this.textInput.setBounds(20,20,300,50);
        this.textInput.setForeground(Color.BLUE.darker());
        this.textInput.setFont(new Font("Arial",Font.PLAIN,16));
        add(this.textInput);

        this.textOutput = new JLabel();
        this.textOutput.setText("Ket qua: ");
        this.textOutput.setBounds(20,60,300,50);
        this.textOutput.setForeground(Color.BLUE.darker());
        this.textOutput.setFont(new Font("Arial",Font.PLAIN,16));
        add(this.textOutput);

        this.input = new JTextField();

        this.input.setBounds(100,20,300,30);
        this.input.setForeground(Color.BLUE.darker());
        this.input.setFont(new Font("Tohoma",Font.PLAIN,16));
        add(this.input);

        this.output = new JTextField();

        this.output.setBounds(100,60,300,30);
        this.output.setForeground(Color.BLUE.darker());
        this.output.setFont(new Font("Tohoma",Font.PLAIN,16));
        add(this.output);

        this.btKQ = new JButton();
        this.btKQ.setText("Giai phuong trinh");
        this.btKQ.setBounds(220,90,100,30);
        this.btKQ.setForeground(Color.BLUE.darker());
        this.btKQ.setFont(new Font("Arial",Font.PLAIN,16));
        this.btKQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sort sort = new Sort();
                sort.setItemSort(input.getText());
                output.setText(sort.sort().toString().replace(","," "));
            }
        });
        add(this.btKQ);
    }

    private void addEvents() {

    }

    private void initPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
    }
}
