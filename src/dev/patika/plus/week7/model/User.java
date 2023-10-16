package dev.patika.plus.week7.model;

import dev.patika.plus.week7.helper.DbConnector;
import dev.patika.plus.week7.helper.Helper;

import java.sql.*;
import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String username;
    private String password;
    private String type;

    public User() {

    }
    public User(int id, String name, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public static boolean add(String name, String username, String password, String type) {
        String query = "INSERT INTO public.\"user\" (name, username, password, type) VALUES(?, ?, ?, ?)";
        User existingUser = User.fetchBy("username", username);
        if (existingUser != null) {
            Helper.showMessage("Username already exists in the database.", "Okay");
            return false;
        }

        try {
            PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setObject(4, type, Types.OTHER);
            if (ps.executeUpdate() == -1) Helper.showMessage("error");
            else return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static boolean update(int id, String name, String username, String password, String type) {
        String query = "UPDATE public.\"user\" SET name = ?, username = ?, password = ?, type = ? WHERE id = ?";
        User existingUser = User.fetchBy("username", username);
        if (existingUser != null && existingUser.getId() != id) {
            Helper.showMessage("Username already exists in the database.", "Okay");
            return false;
        }

        try {
            PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.setObject(4, type, Types.OTHER);
            ps.setInt(5, id);
            return ps.executeUpdate() != -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static ArrayList<User> filterUserList(String query) {
        ArrayList<User> userList = new ArrayList<>();
        User user;

        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user = getUserFormedWithResultSet(rs);
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public static String filterQuery(String name, String username, String type) {
        String query = "SELECT * FROM public.\"user\" WHERE " +
                "name LIKE '%" + name + "%' AND " +
                "username LIKE '%" + username + "%' ";
        if (!type.isEmpty()) query += "AND type = '" + type + "'";
        return query;
    }

    public static User fetchBy(String headerName, String value) {
        User user = null;
        String query = String.format("SELECT * FROM public.\"user\" WHERE %s = ?", headerName);
        try {
            PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
            ps.setString(1, value);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString(headerName).equals(value)) return getUserFormedWithResultSet(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User fetchBy(int id) {
        User user = null;
        String query = String.format("SELECT * FROM public.\"user\" WHERE id = ?");
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getInt("id") == id) return getUserFormedWithResultSet(resultSet);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User checkCredentials(String username, char[] password) {
        User user = null;
        String query = String.format("SELECT * FROM public.\"user\" WHERE username = ? AND password = ?");
        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, String.valueOf(password));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                switch (resultSet.getString("type")) {
                    case "operator" -> user = new Operator();
                    case "instructor" -> user = new Instructor();
                    case "student" -> user = new Student();
                }

                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getString("type"));
                return user;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static ArrayList<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.\"user\"";
        User user;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user = getUserFormedWithResultSet(rs);
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    public static ArrayList<User> getList(String ofUserType) {
        ArrayList<User> userList = new ArrayList<>();
        String query = "SELECT * FROM public.\"user\" WHERE type = '"+ ofUserType +"'";
        User user;
        try {
            Statement st = DbConnector.getInstance().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                user = getUserFormedWithResultSet(rs);
                userList.add(user);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    private static User getUserFormedWithResultSet(ResultSet rs) throws SQLException {
        User user;

        user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setType(rs.getString("type"));
        return user;
    }

    public static boolean deleteById(int id) {
        String query = "DELETE FROM public.\"user\" WHERE id = ?";
        try {
            PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
            ps.setInt(1, id);

            if (ps.executeUpdate() != -1) {
                ArrayList<Course> coursesOfUser = Course.getList(id);
                for (Course course : coursesOfUser) {
                    Course.deleteById(course.getId());
                }
            }
            else return false;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
