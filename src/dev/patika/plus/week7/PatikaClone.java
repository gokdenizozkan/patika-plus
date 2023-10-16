package dev.patika.plus.week7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatikaClone extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fieldUsername;
    private JPasswordField fieldPassword;
    private JButton buttonSubmit;

    protected PatikaClone() {
        add(wrapper);
        setSize(400, 300);
        setTitle("Patika Dev");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        double x = (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getSize().getWidth()) / 2;
        double y = (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getSize().getHeight()) / 2;

        setLocation((int) x, (int) y);
        setVisible(true);
        buttonSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fieldUsername.getText().length() == 0 || fieldPassword.getPassword().length == 0) {
                    JOptionPane.showConfirmDialog(null, "Please fill out every text field to login.");
                }
            }
        });
    }
}
