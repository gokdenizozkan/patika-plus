package dev.patika.plus.week6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseApp {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/****";
        String username = "postgres";
        String password = "****";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(255)," +
                "position VARCHAR(255)," +
                "salary DECIMAL(10, 2)" +
                ");";

        String querySQL = "SELECT id, name, position, salary FROM employees";

        String insertSQL = "INSERT INTO employees (name, position, salary) VALUES('ahmet', 'masör', 1500)";
        String insertSQL2 = "INSERT INTO employees (name, position, salary) VALUES('ayşe', 'kahin', 1500)";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            statement.execute(createTableSQL);
            statement.execute(insertSQL);
            statement.execute(insertSQL2);

            ResultSet resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Position: " + position);
                System.out.println("Salary: " + salary);
                System.out.println("-----------------------");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
