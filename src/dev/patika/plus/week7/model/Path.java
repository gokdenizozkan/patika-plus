package dev.patika.plus.week7.model;

import dev.patika.plus.week7.helper.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Path {
    private int id;
    private String name;

    public Path(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ArrayList<Path> getList() {
        ArrayList<Path> pathList = new ArrayList<>();
        Path path;

        try {
            Statement statement = DbConnector.getInstance().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.path");

            while (resultSet.next()) {
                path = new Path(resultSet.getInt("id"), resultSet.getString("name"));
                pathList.add(path);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return pathList;
    }

    public static boolean add(String name) {
        String query = "INSERT INTO public.path (name) VALUES(?)";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            return preparedStatement.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean update(int id, String name) {
        String query = "UPDATE public.path SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static Path fetchBy(String headerName, String value) {
        Path path = null;
        String query = String.format("SELECT * FROM public.path WHERE %s = ?", headerName);
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString(headerName).equals(value)) return new Path(resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Path fetchBy(int id) {
        Path path = null;
        String query = "SELECT * FROM public.path WHERE id = ?";
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("id") == id) return new Path(resultSet.getInt("id"),
                        resultSet.getString("name"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static boolean delete(int id) {
        String query = "DELETE FROM public.path WHERE id = ?";
        ArrayList<Course> courseList = Course.getList();
        for (Course course : courseList) {
            if (course.getPath().getId() == id) {
                Course.deleteById(course.getId());
            }
        }
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
