package dev.patika.plus.week7.model;

import dev.patika.plus.week7.helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Content {
    private int id;
    private String title;
    private String description;
    private String youtubeLink;
    private String[] quizQuestions;
    private int courseId;
    private Course course;

    public Content() {
    }

    public Content(int id, String title, String description, String youtubeLink, String quizQuestions, int courseId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.youtubeLink = youtubeLink;
        this.quizQuestions = quizQuestions.split(", ");
        this.courseId = courseId;
        course = Course.fetchBy(courseId);
    }

    public static boolean add(String title, String description, String youtubeLink, String quizQuestions,
                              int courseId) {
        String query = "INSERT INTO public.content (title, description, youtube_link, quiz_questions, course_id) " +
                "VALUES(?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, youtubeLink);
            preparedStatement.setString(4, quizQuestions);
            preparedStatement.setInt(5, courseId);
            return preparedStatement.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    public static boolean update(int id, String title, String description, String youtubeLink, String quizQuestions,
                                 int courseId) {
        String query = "UPDATE public.content SET title = ?, description = ?, youtube_link = ?, quiz_questions = ? " +
                "WHERE id = ? AND course_id = ?";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, youtubeLink);
            preparedStatement.setString(4, quizQuestions);
            preparedStatement.setInt(5, id);
            preparedStatement.setInt(6, courseId);
            return preparedStatement.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM public.content WHERE id = ?";
        try {
            PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            return ps.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static ArrayList<Content> filterContentList(String searchToken, int currentCourseId) {
        ArrayList<Content> contentList = new ArrayList<>();
        String query = "SELECT * FROM public.content WHERE course_id = ? AND " +
                "title LIKE '%" + searchToken + "%'";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, currentCourseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String youtubeLink = resultSet.getString("youtube_link");
                String quizQuestions = resultSet.getString("quiz_questions");
                int courseId = resultSet.getInt("course_id");
                contentList.add(new Content(id, title, description, youtubeLink, quizQuestions, courseId));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contentList;
    }

    public static ArrayList<Content> getList(int courseId) {
        ArrayList<Content> contentList = new ArrayList<>();
        String query = "SELECT * FROM public.content WHERE course_id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int course_id = resultSet.getInt("course_id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                String youtubeLink = resultSet.getString("youtube_link");
                String quizQuestions = resultSet.getString("quiz_questions");
                contentList.add(new Content(id, title, description, youtubeLink, quizQuestions, course_id));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return contentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String[] getQuizQuestionsAsArray() {
        return quizQuestions;
    }

    public String getQuizQuestionsAsSingleString() {
        String result = "";
        for (String question : quizQuestions) {
            result += question + ", ";
        }
        return result;
    }

    public void setQuizQuestions(String quizQuestions) {
        this.quizQuestions = quizQuestions.split(", ");
    }

    public void setQuizQuestions(String[] quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
