package dev.patika.plus.java.week7.gui;

import dev.patika.plus.java.week7.helper.Config;
import dev.patika.plus.java.week7.helper.Helper;
import dev.patika.plus.java.week7.model.Instructor;
import dev.patika.plus.java.week7.model.Operator;
import dev.patika.plus.java.week7.model.Student;
import dev.patika.plus.java.week7.model.User;

import javax.swing.*;

public class LoginGui extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JButton btn_register;


    /*
Öğrenciler giriş ekranı sırasında üyelikleri yok ise sisteme kayıt olabilirler.

Kayıt ol ekranı tasarlanmalı ve sadece öğrenciler sisteme kayıt yapabilmeli.

Sistemdeki operatörleri yazılımcı (Yani sizler) eklemeli, eğitmenleride sadece operatörler ekleyebilmeli.
     */

    public LoginGui() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setResizable(false);
        setVisible(true);

        initAdmins();

        btn_login.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_username, fld_password)) Helper.showMessage("fill");
            else {
                User user = User.checkCredentials(fld_username.getText(), fld_password.getPassword());
                if (user == null) {
                    Helper.showMessage("User not found or your login credentials are invalid.");
                }
                else {
                    switch (user.getType()) {
                        case "operator" -> {
                            OperatorGui operatorGui = new OperatorGui((Operator) user);
                        }

                        case "instructor" -> {
                            InstructorGui instructorGui = new InstructorGui((Instructor) user);
                            // user);
                        }

                        case "student" -> {
                            StudentGui studentGui = new StudentGui((Student) user);
                        }
                    }
                    dispose();
                }
            }
        });

        btn_register.addActionListener(e -> {
            RegisterGui registerGui = new RegisterGui();
        });
    }

    private void initAdmins() {
        Operator.add("admin", "admin", "admin", "operator");
    }

    public static void main(String[] args) {
        new LoginGui();
    }
}
