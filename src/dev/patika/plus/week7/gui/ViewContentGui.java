package dev.patika.plus.week7.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dev.patika.plus.week7.helper.Config;
import dev.patika.plus.week7.helper.Helper;
import dev.patika.plus.week7.model.Content;
import dev.patika.plus.week7.model.Path;
import dev.patika.plus.week7.model.Course;

public class ViewContentGui extends JFrame {

    private JPanel wrapper;
    private JTable tbl_contents;
    private JScrollPane scrl_contents;
    private JComboBox cmb_courses;
    private DefaultTableModel mdl_contents;
    private Object[] row_contents;
    private JPopupMenu contentsTabMenu;
    private JMenuItem viewContentMenuItem;
    private final Path path;
    private Course selectedCourse;

    public ViewContentGui(Path path) {
        this.path = path;
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setResizable(false);
        setVisible(true);

        // init
        initContentsTable();
        initPopupMenus();
        initComboListener();
        initCourseSelection();
        configureTableActions();
    }

    private void initComboListener() {
        cmb_courses.addActionListener(e -> {
            String selectedCourseName = (String) cmb_courses.getSelectedItem();
            Course selectedCourse = Course.fetchBy(selectedCourseName);
            mdl_contents.setRowCount(0);
            this.selectedCourse = selectedCourse;
            loadContents();
        });
    }

    private void initCourseSelection() {
        cmb_courses.removeAllItems();
        for (Course course : Course.getList(path)) {
            cmb_courses.addItem(course.getName());
        }
    }

    private void initContentsTable() {
        String[] header = {"ID", "Title", "Description", "Youtube Link", "Quiz Questions"};

        mdl_contents = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };

        tbl_contents.setModel(mdl_contents);
        tbl_contents.getTableHeader().setReorderingAllowed(false);
        tbl_contents.setComponentPopupMenu(contentsTabMenu);
        tbl_contents.getColumnModel().getColumn(0).setMaxWidth(75);

        row_contents = new Object[header.length];
    }

    private void loadContents() {
        mdl_contents.setRowCount(0);
        for (Content content : Content.getList(selectedCourse.getId())) {
            row_contents[0] = content.getId();
            row_contents[1] = content.getTitle();
            row_contents[2] = content.getDescription();
            row_contents[3] = content.getYoutubeLink();
            row_contents[4] = content.getQuizQuestionsAsSingleString();
            mdl_contents.addRow(row_contents);
        }
    }

    private void initPopupMenus() {
        contentsTabMenu = new JPopupMenu();
        viewContentMenuItem = new JMenuItem("Review");
        contentsTabMenu.add(viewContentMenuItem);
    }

    private void configureTableActions() {
        // right click on table should show popup menu and select "Review" should open a new window of ReviewContentGui
        viewContentMenuItem.addActionListener(e -> {
            int selectedRow = tbl_contents.getSelectedRow();
            int selectedContentId = (int) tbl_contents.getValueAt(selectedRow, 0);
            Content selectedContent = Content.fetchBy(selectedContentId);
            new ReviewContentGui(selectedContent);
        });
    }
}
