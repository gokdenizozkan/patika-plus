package dev.patika.plus.week7.gui;

import dev.patika.plus.week7.helper.Config;
import dev.patika.plus.week7.helper.Helper;

import javax.swing.*;

public class StudentGui extends JFrame {
    private JPanel wrapper;

    public StudentGui() {
        add(wrapper);
        setSize(400, 400);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setResizable(false);
        setVisible(true);
    }
}
