package dev.patika.plus.java.week7.gui;

import dev.patika.plus.java.week7.helper.Config;
import dev.patika.plus.java.week7.helper.Helper;
import dev.patika.plus.java.week7.model.Path;
import dev.patika.plus.java.week7.model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentGui extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_paths;
    private JPanel pnl_enrolled;
    private JTable tbl_paths;
    private JScrollPane scrl_paths;
    private JTable tbl_enrolled;
    private JScrollPane scrl_enrolled;
    private DefaultTableModel mdl_paths;
    private DefaultTableModel mdl_enrolled;
    private Object[] row_paths;
    private Object[] row_enrolled;
    private JPopupMenu pathsTabMenu;
    private JPopupMenu enrolledTabMenu;
    private JMenuItem enrollMenuItem;
    private JMenuItem unenrollMenuItem;
    private Student student;

    public StudentGui(Student student) {
        this.student = student;
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setResizable(false);
        setVisible(true);

        if(!this.student.isRegistered()) this.student.register();

        // init
        initPopupMenus();
        initPathsTable();
        initEnrolledPathsTable();
        configureTableActions();
    }

    private void initPathsTable() {
        String[] header = {"ID", "Name"};

        mdl_paths = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        tbl_paths.setModel(mdl_paths);
        tbl_paths.getTableHeader().setReorderingAllowed(false);
        tbl_paths.setComponentPopupMenu(pathsTabMenu);
        tbl_paths.getColumnModel().getColumn(0).setMaxWidth(75);

        row_paths = new Object[header.length];
        loadPaths();
    }

    private void initEnrolledPathsTable() {
        String[] header = {"ID", "Name"};

        mdl_enrolled = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        tbl_enrolled.setModel(mdl_enrolled);
        tbl_enrolled.getTableHeader().setReorderingAllowed(false);
        tbl_enrolled.setComponentPopupMenu(enrolledTabMenu);
        tbl_enrolled.getColumnModel().getColumn(0).setMaxWidth(75);

        row_enrolled = new Object[header.length];
        loadEnrolledPaths();
    }

    private void initPopupMenus() {
        // right click menu
        pathsTabMenu = new JPopupMenu();
        enrolledTabMenu = new JPopupMenu();
        enrollMenuItem = new JMenuItem("Enroll");
        unenrollMenuItem = new JMenuItem("Unenroll");

        pathsTabMenu.add(enrollMenuItem);
        enrolledTabMenu.add(unenrollMenuItem);
    }

    private void configureTableActions() {
        // enroll
        enrollMenuItem.addActionListener(e -> {
            int selectedId = (int) tbl_paths.getValueAt(tbl_paths.getSelectedRow(), 0);
            if (this.student.enroll(selectedId)) Helper.showMessage("done");
            else Helper.showMessage("error");
            loadEnrolledPaths();
        });

        // uneroll
        unenrollMenuItem.addActionListener(e -> {
            if (Helper.confirm("unenroll from path")) {
                int row = tbl_enrolled.getSelectedRow();
                if (row == -1) return; // if no row selected (index -1)

                int selectedId = (int) tbl_enrolled.getValueAt(row, 0);
                if (this.student.unenroll(selectedId)) Helper.showMessage("done");
                else Helper.showMessage("error");
                loadEnrolledPaths();
            }
        });

        // double click
        tbl_enrolled.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2 && tbl_enrolled.getSelectedRow() != -1) {
                    int selectedId = (int) tbl_enrolled.getValueAt(tbl_enrolled.getSelectedRow(), 0);
                    Path path = Path.fetchBy(selectedId);
                    new ViewContentGui(path);
                }
            }
        });
    }

    private void loadPaths() {
        ((DefaultTableModel) tbl_paths.getModel()).setRowCount(0);

        for (Path path : Path.getList()) {
            int i = 0;
            row_paths[i++] = path.getId();
            row_paths[i] = path.getName();
            mdl_paths.addRow(row_paths);
        }
    }

    private void loadEnrolledPaths() {
        ((DefaultTableModel) tbl_enrolled.getModel()).setRowCount(0);

        String enrolledPathsString = this.student.getEnrolledPaths();
        if (enrolledPathsString.isEmpty()) return;
        String[] enrolledPaths = enrolledPathsString.split(",");

        for (String pathIdString : enrolledPaths) {
            int pathId = Integer.parseInt(pathIdString);
            Path path = Path.fetchBy(pathId);

            int i = 0;
            assert path != null;
            row_enrolled[i++] = path.getId();
            row_enrolled[i] = path.getName();
            mdl_enrolled.addRow(row_enrolled);
        }
    }
}
