package com.example.task2;

import java.sql.*;
import java.util.LinkedList;

public class JDBCPostgres implements UserDUO{

    static final String DB_URL = "jdbc:postgresql://localhost:5432/testdb";

    public static Connection dbConnect() {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return null;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, "postgres", "admin");

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }

    public LinkedList<User> takeList(){
        String selectTableSQL = "SELECT user_id, login, password, email, byear from users";
        Connection dbConnection = null;
        Statement statement = null;

        LinkedList<User> usersFrom = new LinkedList<>();

        try {
            dbConnection = dbConnect();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                usersFrom.add(new User(rs.getString("login"),rs.getString("password"), rs.getInt("byear"),rs.getString("email")));
                System.out.println(usersFrom.get(usersFrom.size() - 1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usersFrom;
    }
    public void writeList(User user){
        Statement statement = null;
        Connection dbConnection = dbConnect();

        String selectTableSQL = "SELECT max(user_id) from users";
        int maxId = 0;
        ResultSet rs;
        try {
            statement = dbConnection.createStatement();
            rs =  statement.executeQuery(selectTableSQL);
            rs.next();
            maxId = rs.getInt(1) + 1;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        String insertTableSQL = String.format("INSERT INTO users (user_id, login, password, email, byear) VALUES (%d, '%s', '%s', '%s', %d)", maxId, user.Login, user.Password, user.Email, user.Birthday);
//        String insertTableSQL = "INSERT INTO users"
//                + "(user_id, login, password, email, byear) " + "VALUES"
//                + "(" + maxId + ", '" + user.Login + ", '" + user.Password + ", '" + user.Email + ", " + user.Birthday + ")";


        try {

            statement = dbConnection.createStatement();
            statement.executeQuery(insertTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
