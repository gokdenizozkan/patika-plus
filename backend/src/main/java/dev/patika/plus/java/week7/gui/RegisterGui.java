package dev.patika.plus.java.week7.gui;

import dev.patika.plus.java.week7.helper.Config;
import dev.patika.plus.java.week7.helper.Helper;
import dev.patika.plus.java.week7.model.User;

import javax.swing.*;

public class RegisterGui extends JFrame {
    private JPanel wrapper;
    private JTextField fld_name;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_submit;

    public RegisterGui() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setResizable(false);
        setVisible(true);

        btn_submit.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_name, fld_username, fld_password)) Helper.showMessage("fill");
            else {
                if (User.fetchBy("username", fld_username.getText()) != null) {
                    Helper.showMessage("Username is taken.");
                }
                else {
                    if (User.add(fld_name.getText(), fld_username.getText(), fld_password.getText(), "student")) {
                        Helper.showMessage("done");
                        dispose();
                    }
                }
            }
        });
    }
}
