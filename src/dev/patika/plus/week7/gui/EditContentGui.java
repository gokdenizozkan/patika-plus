package dev.patika.plus.week7.gui;

import dev.patika.plus.week7.helper.Config;
import dev.patika.plus.week7.helper.Helper;
import dev.patika.plus.week7.model.Content;
import dev.patika.plus.week7.model.Course;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class EditContentGui extends JFrame {
    private JPanel wrapper;
    private JScrollPane scrl_contentList;
    private JTable tbl_contentList;
    private JTextField fld_title;
    private JTextField fld_description;
    private JTextField fld_youtubeLink;
    private JTextField fld_quizQuestions;
    private JButton btn_add;
    private JLabel lbl_courseName;
    private JTextField fld_contentId;
    private JButton btn_delete;
    private JTextField fld_filter;
    private JButton btn_filter;
    private DefaultTableModel mdl_contentList;
    private Object[] row_contentList;
    private final int courseId;
    private final Course course;

    public EditContentGui(int courseId) {
        this.courseId = courseId;
        this.course = Course.fetchBy(courseId);
        add(wrapper);
        setSize(1000, 500);
        setLocation(Helper.screenCenter("x", getSize()), Helper.screenCenter("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROGRAM_TITLE);
        setVisible(true);

        lbl_courseName.setText("Course: " + course.getName());

        initAddButton();
        initContentList();
        initListSelectionListener();
        initDeleteButton();
        initFilterButton();
    }

    private void initFilterButton() {
        btn_filter.addActionListener(e -> loadContentList(
                Content.filterContentList(fld_filter.getText(), courseId)));
    }

    private void initDeleteButton() {
        btn_delete.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_contentId)) Helper.showMessage("fill");
            else {
                if (Content.delete(Integer.parseInt(fld_contentId.getText()))) {
                    Helper.showMessage("done");
                    fld_contentId.setText("");
                    loadContentList();
                } else Helper.showMessage("error");
            }
        });
    }

    private void initListSelectionListener() {
        tbl_contentList.getModel().addTableModelListener(e -> {
            if (e.getType() == TableModelEvent.UPDATE) {
                int id = (int) tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(), 0);
                String title = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(), 1).toString();
                String description = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(), 2).toString();
                String youtubeLink = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(), 3).toString();
                String quizQuestions = tbl_contentList.getValueAt(tbl_contentList.getSelectedRow(), 4).toString();

                if (Content.update(id, title, description, youtubeLink, quizQuestions, courseId)) Helper.showMessage("done");
                else Helper.showMessage("error");

                loadContentList();
            }
        });
    }

    private void initContentList() {
        String[] header = {"ID", "Title", "Description", "Youtube Link", "Quiz Questions"};
        mdl_contentList = new DefaultTableModel(header, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 0) return false;
                return super.isCellEditable(row, column);
            }
        };
        tbl_contentList.setModel(mdl_contentList);
        tbl_contentList.getTableHeader().setReorderingAllowed(false);

        row_contentList = new Object[header.length];
        loadContentList();
    }

    private void loadContentList() {
        ((DefaultTableModel) tbl_contentList.getModel()).setRowCount(0);

        for (Content content : Content.getList(courseId)) {
            row_contentList[0] = content.getId();
            row_contentList[1] = content.getTitle();
            row_contentList[2] = content.getDescription();
            row_contentList[3] = content.getYoutubeLink();
            row_contentList[4] = content.getQuizQuestionsAsSingleString();
            mdl_contentList.addRow(row_contentList);
        }
    }

    private void loadContentList(ArrayList<Content> contentList) {
        ((DefaultTableModel) tbl_contentList.getModel()).setRowCount(0);

        for (Content content : contentList) {
            row_contentList[0] = content.getId();
            row_contentList[1] = content.getTitle();
            row_contentList[2] = content.getDescription();
            row_contentList[3] = content.getYoutubeLink();
            row_contentList[4] = content.getQuizQuestionsAsSingleString();
            mdl_contentList.addRow(row_contentList);
        }
    }

    private void initAddButton() {
        btn_add.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_title, fld_description, fld_youtubeLink, fld_quizQuestions)) Helper.showMessage("fill");
            else {
                if (Content.add(fld_title.getText(), fld_description.getText(), fld_youtubeLink.getText(),
                        fld_quizQuestions.getText(), courseId)) {
                    Helper.showMessage("done");
                    fld_title.setText("");
                    fld_description.setText("");
                    fld_youtubeLink.setText("");
                    fld_quizQuestions.setText("");
                    loadContentList();
                } else Helper.showMessage("error");
            }
        });
    }
}
