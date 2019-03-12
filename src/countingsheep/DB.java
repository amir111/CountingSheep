package countingsheep;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    private static Connection connect() {
        Connection connect = null;
        try {
            //NOTE: This method will not work unless you go to project properties -> libraries -> add the jar thats in the mysql-connector-java... folder
            String serverName = "counting-sheep-db.cr86epichnnr.us-east-2.rds.amazonaws.com:3306";
            String mydatabase = "counting_sheep";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "webrady";
            String password = "4bJvyriM8DZfwDG";
            connect = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            throw new IllegalStateException("Cannot connect to the database", e);
        }
        return connect;
    }

    //Used to test database connection, will probably be removed later
    public static void selectUsers() {
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT uname FROM User");
            while (rs.next()) {
                System.out.println(rs.getString("uname"));
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
    }

    //Used to obtain a specific user's data for login or displaying a manger of a hotel's contact information
    public static ArrayList<String> selectTargetUser(String uname) {
        ArrayList<String> user = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM User WHERE uname = '" + uname + "'");
            if (rs.next()) {
                user.add(rs.getString("user_id"));
                user.add(rs.getString("uname"));
                user.add(rs.getString("pword"));
                user.add(rs.getString("email"));
                user.add(rs.getString("phone"));
                user.add(rs.getString("user_type"));
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return user;
    }
}
