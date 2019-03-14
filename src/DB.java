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
    /*
    TO IMPLEMENT QUERIES
    Guest
        Booking Info
            Gets the hotel information where a specific customer is staying     
                SELECT * FROM Booking b, Room r, Hotel h
                WHERE b.room_id = r.room_id AND r.hotel_id = h.hotel_id AND b.customer_id = 7
            Returns the requests made by this client
                SELECT * FROM Request
                WHERE customer_id = 7
        Book Room
            Search for rooms with these qualities
                SELECT * FROM Room r, Hotel h
                WHERE r.hotel_id = h.hotel_id AND r.price = 120.00 AND h.city = 'Greensboro'
        Request
            Create a new request
                insert into Request
                values(2,'Pizza','Food',now(),NULL,6,7)
            Check the largest request_id so that a new one can be made
                SELECT max(request_id)
                FROM Request
    
    Concerns
    GUI: Each hotel has multiple rooms, but GUI only shows the hotels, not each individual room available to book
    Guest Request screen has a few typos
    */
}
