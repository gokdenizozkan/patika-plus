package dev.patika.plus.week7.gui;

import dev.patika.plus.week7.helper.Config;
import dev.patika.plus.week7.helper.Helper;
import dev.patika.plus.week7.model.Course;
import dev.patika.plus.week7.model.Instructor;
import dev.patika.plus.week7.model.Operator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class InstructorGui extends JFrame {
    private final Instructor instructor;
    private JPanel wrapper;
    private JTabbedPane tab_instructor;
    private JPanel pnl_assignedCourseList;
    private JScrollPane scrl_assignedCourseList;
    private JTable tbl_assignedCourseList;
    private JPanel pnl_courseContent;
    private JTable tbl_courseContent;
    private JScrollPane scrl_courseContent;
    private DefaultTableModel mdl_assignedCourseList;
    private Object[] row_assignedCourseList;

    public InstructorGui(Instructor instructor) {
        this.instructor = instructor;
        constructorConfigurations();
    }

    public InstructorGui(Operator operator) {
        this.instructor = null;
        constructorConfigurations();
    }

    private void constructorConfigurations() {
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setResizable(false);
        setVisible(true);

        initAssignedCourseList();
        configureTableActions();
    }

    private void configureTableActions() {
        tbl_assignedCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = tbl_assignedCourseList.getSelectedRow();
                    int courseId = (int) tbl_assignedCourseList.getValueAt(row, 0);
                    new EditContentGui(courseId);
                }
            }
        });
    }

    private void initAssignedCourseList() {
        String[] header = {"ID", "Name", "Lang", "Path"};
        mdl_assignedCourseList = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };
        tbl_assignedCourseList.setModel(mdl_assignedCourseList);
        tbl_assignedCourseList.getTableHeader().setReorderingAllowed(false);

        row_assignedCourseList = new Object[header.length];
        loadAssignedCourseList();
    }

    public void loadAssignedCourseList() {
        ((DefaultTableModel) tbl_assignedCourseList.getModel()).setRowCount(0);

        ArrayList<Course> courses;
        if (instructor == null) courses = Course.getList();
        else courses = Course.getList(instructor.getId());

        for (Course course : courses) {
            int i = 0;
            row_assignedCourseList[i++] = course.getId();
            row_assignedCourseList[i++] = course.getName();
            row_assignedCourseList[i++] = course.getLang();
            row_assignedCourseList[i] = course.getPath().getName();
            mdl_assignedCourseList.addRow(row_assignedCourseList);
        }
    }
}
