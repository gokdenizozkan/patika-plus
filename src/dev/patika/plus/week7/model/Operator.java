package dev.patika.plus.week7.model;

import dev.patika.plus.week7.helper.DbConnector;
import dev.patika.plus.week7.helper.Helper;

import java.sql.PreparedStatement;
import java.sql.Types;

public class Operator extends User {

    public Operator() {
        super();
    }

    public static boolean add(String name, String username, String password, String type) {
        // add to database
        if (User.fetchBy("username", username) == null) {
            String query = "INSERT INTO public.\"user\" (name, username, password, type) VALUES(?, ?, ?, ?)";
            try {
                PreparedStatement ps = DbConnector.getInstance().prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, username);
                ps.setString(3, password);
                ps.setObject(4, type, Types.OTHER);
                return ps.executeUpdate() == -1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
