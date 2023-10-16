package dev.patika.plus.week7.gui;

import dev.patika.plus.week7.helper.Config;
import dev.patika.plus.week7.helper.Helper;
import dev.patika.plus.week7.helper.Item;
import dev.patika.plus.week7.model.Course;
import dev.patika.plus.week7.model.Operator;
import dev.patika.plus.week7.model.Path;
import dev.patika.plus.week7.model.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class OperatorGui extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_userList;
    private JScrollPane scrl_userList;
    private JTable tbl_userList;
    private JPanel pnl_userForm;
    private JTextField fld_changeName;
    private JTextField fld_changeUsername;
    private JPasswordField fld_changePassword;
    private JComboBox cmb_changeType;
    private JButton btn_changeSubmit;
    private JButton btn_userIdToDelete;
    private JTextField fld_userIdToDelete;
    private JTextField fld_findName;
    private JTextField fld_findUsername;
    private JComboBox cmb_findType;
    private JButton btn_find;
    private JPanel pnl_paths;
    private JScrollPane scrl_pathList;
    private JTable tbl_pathList;
    private JPanel pnl_addPath;
    private JTextField fld_pathName;
    private JButton btn_addPath;
    private JPanel pnl_courses;
    private JTable tbl_courseList;
    private JScrollPane scrl_courseList;
    private JTextField fld_courseName;
    private JTextField fld_courseLang;
    private JButton btn_courseAdd;
    private JComboBox cmb_coursePath;
    private JComboBox cmb_courseUser;
    private DefaultTableModel mdl_userList;
    private Object[] row_userList;
    private DefaultTableModel mdl_courseList;
    private Object[] row_courseList;

    // path
    private DefaultTableModel mdl_pathList;
    private Object[] row_pathList;
    private JPopupMenu pathMenu;
    private final Operator operator;
    public OperatorGui(Operator operator) {
        this.operator = operator;
        add(wrapper);
        setSize(1000, 500);
        int x = Helper.screenCenter("x", getSize());
        int y = Helper.screenCenter("y", getSize());
        setLocation(x, y);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setVisible(true);

        lbl_welcome.setText(operator.getName() + ", welcome!");

        // Model USER LIST
        mdl_userList = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] col_userList = {"ID", "Name", "Username", "Password", "Type"};
        mdl_userList.setColumnIdentifiers(col_userList);

        row_userList = new Object[col_userList.length];
        loadUserModel();

        tbl_userList.setModel(mdl_userList);
        tbl_userList.getTableHeader().setReorderingAllowed(false);

         //// PATH LIST
        mdl_pathList = new DefaultTableModel();
        Object[] col_pathList = {"ID", "Path Name"};
        mdl_pathList.setColumnIdentifiers(col_pathList);
        row_pathList = new Object[col_pathList.length];

        loadPathModel();

        tbl_pathList.setModel(mdl_pathList);
        tbl_pathList.setComponentPopupMenu(pathMenu);
        tbl_pathList.getTableHeader().setReorderingAllowed(false);
        tbl_pathList.getColumnModel().getColumn(0).setMaxWidth(75);

        // COURSE LIST
        mdl_courseList = new DefaultTableModel();
        Object[] col_courseList = {"ID", "COURSE NAME", "LANGUAGE", "PATH", "INSTRUCTOR"};
        mdl_courseList.setColumnIdentifiers(col_courseList);
        row_courseList = new Object[col_courseList.length];

        loadCourseModel();

        tbl_courseList.setModel(mdl_courseList);
        tbl_courseList.getColumnModel().getColumn(0).setMaxWidth(75);
        tbl_courseList.getTableHeader().setReorderingAllowed(false);

        loadPathCombo();
        loadInstructorCombo();



        // selection
        tbl_userList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    String selectedId = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 0).toString();
                    fld_userIdToDelete.setText(selectedId);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        tbl_userList.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int userId = Integer.parseInt(tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 0).toString());
                String name = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 1).toString();
                String username = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 2).toString();
                String password = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 3).toString();
                String type = tbl_userList.getValueAt(tbl_userList.getSelectedRow(), 4).toString();

                if (User.update(userId, name, username, password, type)) {
                    Helper.showMessage("done");
                } else {
                    Helper.showMessage("error");
                }
                loadUserModel();
                loadInstructorCombo();
            }
        });

        // PATH PANEL

        // right click menu
        pathMenu = new JPopupMenu();
        JMenuItem pathMenuUpdate = new JMenuItem("Update");
        JMenuItem pathMenuDelete = new JMenuItem("Delete");
        pathMenu.add(pathMenuUpdate);
        pathMenu.add(pathMenuDelete);
        // update
        pathMenuUpdate.addActionListener(e -> {
            int selectedId = Integer.parseInt(tbl_pathList.getValueAt(tbl_pathList.getSelectedRow(), 0).toString());
            UpdatePathGui updatePathGui = new UpdatePathGui(Path.fetchBy(selectedId));
            updatePathGui.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    loadPathModel();
                    loadPathCombo();
                    loadCourseModel();
                }
            });
        });
        // delete
        pathMenuDelete.addActionListener(e -> {
            if (Helper.confirm("deletion")) {
                int selectedId = Integer.parseInt(tbl_pathList.getValueAt(tbl_pathList.getSelectedRow(), 0).toString());
                if (Path.delete(selectedId)) {
                    Helper.showMessage("done");
                    loadPathModel();
                    loadPathCombo();
                    loadCourseModel();
                } else {
                    Helper.showMessage("error");
                }
            }
        });
        tbl_pathList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tbl_pathList.rowAtPoint(point);
                tbl_pathList.setRowSelectionInterval(selectedRow, selectedRow);

                //super.mousePressed(e);
            }
        });
        btn_changeSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Helper.isFieldEmpty(fld_changeName) || Helper.isFieldEmpty(fld_changeUsername) || Helper.isFieldEmpty(fld_changePassword)) {
                    Helper.showMessage("fill");
                }
                else {
                    String name = fld_changeName.getText();
                    String username = fld_changeUsername.getText();
                    String password = String.copyValueOf(fld_changePassword.getPassword());
                    String type = cmb_changeType.getSelectedItem().toString();

                    if (User.add(name, username, password, type)) {
                        loadUserModel();
                        loadInstructorCombo();
                        fld_changeName.setText(null);
                        fld_changeUsername.setText(null);
                        fld_changePassword.setText(null);
                        Helper.showMessage("done");
                    }
                }
            }
        });
        btn_userIdToDelete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_userIdToDelete)) Helper.showMessage("fill");
            else {
                int id = Integer.parseInt(fld_userIdToDelete.getText());
                if (User.deleteById(id)) {
                    Helper.showMessage("done");
                    loadUserModel();
                    loadInstructorCombo();
                    loadCourseModel();
                }
                else Helper.showMessage("error");
            }
        });
        btn_find.addActionListener(e -> {
            String name = fld_findName.getText();
            String username = fld_findUsername.getText();
            String type = cmb_findType.getSelectedItem().toString();

            String query = User.filterQuery(name, username, type);
            ArrayList<User> filtered = User.filterUserList(query);

            loadUserModel(filtered);
        });

        btn_logout.addActionListener(e -> {
            dispose();
            new LoginGui();
        });
        btn_addPath.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_pathName)) Helper.showMessage("fill");
            else {
                if(Path.add(fld_pathName.getText())) {
                    Helper.showMessage("done");
                    loadPathCombo();
                    loadPathModel();
                    fld_pathName.setText(null);
                }
                else {
                    Helper.showMessage("error");
                }
            }
        });
        btn_courseAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item pathItem = (Item) cmb_coursePath.getSelectedItem();
                Item userItem = (Item) cmb_courseUser.getSelectedItem();
                if (Helper.isFieldEmpty(fld_courseName, fld_courseLang)) Helper.showMessage("fill");
                else {
                    if (Course.add(userItem.getKey(), pathItem.getKey(), fld_courseName.getText(),
                            fld_courseLang.getText())) {
                        Helper.showMessage("done");
                        fld_courseLang.setText(null);
                        fld_courseName.setText(null);
                    }
                    else {
                        Helper.showMessage("error");
                    }
                    loadCourseModel();
                }
            }
        });
    }

    public static void main(String[] args) {
        Operator op = new Operator();
        op.setId(1);
        op.setName("Mustafa Çetindağ");
        op.setPassword("1234");
        op.setType("operator");
        op.setUsername("mustafa");
        OperatorGui opGui = new OperatorGui(op);
    }

    public void loadUserModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);


        for (User user : User.getList()) {
            int i = 0;
            row_userList[i++] = user.getId();
            row_userList[i++] = user.getName();
            row_userList[i++] = user.getUsername();
            row_userList[i++] = user.getPassword();
            row_userList[i++] = user.getType();
            mdl_userList.addRow(row_userList);
        }
    }

    public void loadUserModel(ArrayList<User> userList) {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_userList.getModel();
        clearModel.setRowCount(0);

        for (User user : userList) {
            int i = 0;
            row_userList[i++] = user.getId();
            row_userList[i++] = user.getName();
            row_userList[i++] = user.getUsername();
            row_userList[i++] = user.getPassword();
            row_userList[i++] = user.getType();
            mdl_userList.addRow(row_userList);
        }
    }

    public void loadPathModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_pathList.getModel();
        clearModel.setRowCount(0);

        for (Path path : Path.getList()) {
            int i = 0;
            row_pathList[i++] = path.getId();
            row_pathList[i++] = path.getName();
            mdl_pathList.addRow(row_pathList);
        }
    }

    public void loadCourseModel() {
        DefaultTableModel clearModel = (DefaultTableModel) tbl_courseList.getModel();
        clearModel.setRowCount(0);

        for (Course course : Course.getList()) {
            int i = 0;
            row_courseList[i++] = course.getId();
            row_courseList[i++] = course.getName();
            row_courseList[i++] = course.getLang();
            row_courseList[i++] = course.getPath().getName();
            row_courseList[i++] = course.getInstructor().getName();
            mdl_courseList.addRow(row_courseList);
        }
    }

    public void loadPathCombo() {
        cmb_coursePath.removeAllItems();
        for (Path path : Path.getList()) {
            cmb_coursePath.addItem(new Item(path.getId(), path.getName()));
        }
    }

    public void loadInstructorCombo() {
        cmb_courseUser.removeAllItems();
        for (User user : User.getList("instructor")) {
            cmb_courseUser.addItem(new Item(user.getId(), user.getName()));
        }
    }
}
