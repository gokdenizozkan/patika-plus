package dev.patika.plus.week7.gui;

import dev.patika.plus.week7.helper.Config;
import dev.patika.plus.week7.helper.Helper;
import dev.patika.plus.week7.model.Path;

import javax.swing.*;

public class UpdatePathGui extends JFrame {
    private JPanel wrapper;
    private JTextField fld_pathName;
    private JButton btn_update;
    private final Path path;

    public UpdatePathGui(Path path) {
        this.path = path;
        add(wrapper);
        setSize(300, 150);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setVisible(true);

        fld_pathName.setText(path.getName());
        btn_update.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_pathName)) {
                Helper.showMessage("fill");
            }
            else {
                if (Path.update(path.getId(), fld_pathName.getText())) {
                    dispose();
                }
                else {
                    Helper.showMessage("error");
                }
            }
        });
    }
}
