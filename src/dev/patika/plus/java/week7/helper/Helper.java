package dev.patika.plus.java.week7.helper;

import javax.swing.*;
import java.awt.*;

public class Helper {
    public static int screenCenter(String axis, Dimension size) {
        return switch (axis) {
            case "x" -> (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - size.getWidth()) / 2;
            case "y" -> (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - size.getHeight()) / 2;
            default -> throw new IllegalStateException("Unexpected value: " + axis);
        };
    }

    public static boolean isFieldEmpty(JTextField field) {
        return field.getText().trim().isEmpty();
    }

    public static boolean isFieldEmpty(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void showMessage(String dialogue, String... buttonText) {
        String msg;
        String title;

        switch (dialogue) {
            case "fill" -> {
                msg = "Please fill all fields.";
                title = "An error occured";
                setButtonText("Okay");
            }
            case "done" -> {
                msg = "Process finished successfully.";
                title = "Successful";
                setButtonText("Done");
            }
            case "error" -> {
                msg = "Something went wrong.";
                title = "An error occured";
                setButtonText("Okay");
            }
            default -> {
                msg = dialogue;
                title = "Dialogue Window";
                setButtonText(buttonText.length > 0 ? buttonText[0] : "Okay");
            }
        }

        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String process) {
        setButtonText("Proceed");
        int i = JOptionPane.showConfirmDialog(null, "You are about to do " + process + ".\n Would you like to proceed?",
                "Warning", JOptionPane.YES_NO_OPTION);
        return i == 0;
    }

    public static void setButtonText(String text) {
        UIManager.put("OptionPane.okButtonText", text);
    }
}
