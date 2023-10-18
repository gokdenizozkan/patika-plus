package dev.patika.plus.week7.model;

import dev.patika.plus.week7.helper.DbConnector;
import dev.patika.plus.week7.helper.Helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Student extends User {

    public boolean isRegistered() {
        String query = "SELECT 1 FROM public.student WHERE user_id = ? LIMIT 1";

        try {
            PreparedStatement preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, this.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean register() {
        String query = "INSERT INTO public.student (user_id, enrolled_paths) VALUES(?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, this.getId());
            preparedStatement.setString(2, "");

            boolean response = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    public boolean enroll(int pathId) {
        String enrolledPaths = getEnrolledPaths();
        String pathIdString = String.valueOf(pathId);

        if (enrolledPaths.contains(pathIdString)) Helper.showMessage("You are already enrolled.", "Okay");
        else {
            enrolledPaths += pathIdString + ",";
            return updateEnrollment(enrolledPaths);
        }
        return false;
    }

    public boolean unenroll(int pathId) {
        String enrolledPaths = getEnrolledPaths();
        String pathIdString = String.valueOf(pathId);

        if (enrolledPaths.contains(pathIdString)) {
            enrolledPaths = enrolledPaths.replace(pathIdString + ",", "");
            return updateEnrollment(enrolledPaths);
        }
        return false;
    }

    public String getEnrolledPaths() {
        String query = "SELECT enrolled_paths FROM public.student WHERE user_id = ?";

        String enrolledPaths = "";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setInt(1, this.getId());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) enrolledPaths = resultSet.getString("enrolled_paths");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (enrolledPaths.isEmpty()) return "";

        // check if all paths in enrolled paths actually exists
        String[] enrolledPathsArray = enrolledPaths.split(",");
        String enrolledPathsString = "";
        for (String pathIdString : enrolledPathsArray) {
            int pathId = Integer.parseInt(pathIdString);
            Path path = Path.fetchBy(pathId);
            if (path != null) enrolledPathsString += pathIdString + ",";
        }

        if (enrolledPathsString != enrolledPaths) updateEnrollment(enrolledPathsString);

        return enrolledPathsString;
    }

    public boolean updateEnrollment(String enrolledPaths) {
        String query = "UPDATE public.student SET enrolled_paths = ? WHERE user_id = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DbConnector.getInstance().prepareStatement(query);
            preparedStatement.setString(1, enrolledPaths);
            preparedStatement.setInt(2, this.getId());
            boolean response = preparedStatement.executeUpdate() != -1;
            preparedStatement.close();
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }


}
