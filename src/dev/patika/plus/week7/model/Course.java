package dev.patika.plus.week7.model;

import dev.patika.plus.week7.helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Course {
    private int id;
    private int userId;
    private int pathId;
    private String name;
    private String lang;

    private Path path;
    private User instructor;

    public Course(int id, int userId, int pathId, String name, String lang) {
        this.id = id;
        this.userId = userId;
        this.pathId = pathId;
        this.name = name;
        this.lang = lang;
        this.path = Path.fetchBy(pathId);
        this.instructor = User.fetchBy(userId);
    }

    public static ArrayList<Course> getList() {
        ArrayList<Course> courseList = new ArrayList<>();
        Course course;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.course");
            formCourseListWithResultSet((ArrayList<Course>) courseList, resultSet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return courseList;
    }

    public static ArrayList<Course> getList(int ofUserId) {
        ArrayList<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM public.course WHERE user_id = ?";
        Course course;

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, ofUserId);
            ResultSet resultSet = preparedStatement.executeQuery();
            formCourseListWithResultSet((ArrayList<Course>) courseList, resultSet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return courseList;
    }

    private static void formCourseListWithResultSet(ArrayList<Course> courseList, ResultSet resultSet) throws SQLException {
        Course course;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("user_id");
            int pathId = resultSet.getInt("path_id");
            String name = resultSet.getString("name");
            String language = resultSet.getString("lang");

            course = new Course(id, userId, pathId, name, language);
            courseList.add(course);
        }
    }

    private static Course formCourseWithResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        int userId = resultSet.getInt("user_id");
        int pathId = resultSet.getInt("path_id");
        String name = resultSet.getString("name");
        String language = resultSet.getString("lang");

        return new Course(id, userId, pathId, name, language);
    }

    public static boolean add(int userId, int pathId, String name, String lang) {
        String query = "INSERT INTO public.course (user_id, path_id, name, lang)" +
                "VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, pathId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, lang);
            return preparedStatement.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean deleteById(int id) {
        String query = "DELETE FROM public.course WHERE id = ?";
        try {
            PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeUpdate() != -1;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static Course fetchBy(int id) {
        Course course = null;
        String query = String.format("SELECT * FROM public.course WHERE id = ?");
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                if (resultSet.getInt("id") == id){
                    int userId = resultSet.getInt("user_id");
                    int pathId = resultSet.getInt("path_id");
                    String name = resultSet.getString("name");
                    String language = resultSet.getString("lang");

                    return new Course(id, userId, pathId, name, language);
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPathId() {
        return pathId;
    }

    public void setPathId(int pathId) {
        this.pathId = pathId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }
}
