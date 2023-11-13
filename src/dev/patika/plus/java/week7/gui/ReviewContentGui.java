package dev.patika.plus.java.week7.gui;

import dev.patika.plus.java.week7.helper.Helper;
import dev.patika.plus.java.week7.model.Content;

import javax.swing.*;

public class ReviewContentGui extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JComboBox cmb_rating;
    private JTextArea txt_comment;
    private JButton btn_submit;
    private int rating;
    private String comment;

    ReviewContentGui(Content content) {
        initSubmitButtonListener();

        add(wrapper);
        setSize(500, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Review Content");
        setResizable(false);
        setVisible(true);

    }

    private void initSubmitButtonListener() {
        btn_submit.addActionListener(e -> {
            rating = (int) cmb_rating.getSelectedItem();
            comment = txt_comment.getText();
            System.out.println(rating);
            System.out.println(comment);
            dispose();
        });
    }
}
