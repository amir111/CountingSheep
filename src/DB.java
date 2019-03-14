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
    /*public static void selectUsers() {
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
    */
    
    //Used to obtain a specific user's data for login or displaying a manger of a hotel's contact information
    public static User selectTargetUser(String uname) {
        User user = new User();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM User WHERE uname = '" + uname + "'");
            if (rs.next()) {
                user.setUuid(rs.getInt("user_id"));
                user.setUsername(rs.getString("uname"));
                user.setPassword(rs.getString("pword"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                if (rs.getInt("user_type") == 1) {
                    user.setID('M');
                } else {
                    user.setID('C');
                }
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return user;
    }

    //Returns a list of rooms booked by a specific client identified by their uuid
    public static ArrayList<Room> selectBookedRoom(int clientUuid) {
        ArrayList<Room> roomList = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Booking b, Room r, Hotel h WHERE b.room_id = r.room_id AND r.hotel_id = h.hotel_id AND b.customer_id = " + clientUuid);
            while (rs.next()) {
                Room newRoom = new Room();
                newRoom.setAddress(rs.getString("address"));
                newRoom.setCity(rs.getString("city"));
                newRoom.setName(rs.getString("name"));
                newRoom.setRoomDescription(rs.getString("description"));
                newRoom.setRoomID(rs.getInt("room_id"));
                newRoom.setRoomName(rs.getInt("number"));
                newRoom.setRoomPrice(rs.getFloat("price"));
                newRoom.setState("state");
                if(rs.getInt("pool") == 1){
                    newRoom.setPool(true);
                }
                else{
                    newRoom.setPool(false);
                }
                if(rs.getInt("breakfast") == 1){
                    newRoom.setBreakfast(true);
                }
                else{
                    newRoom.setBreakfast(false);
                }
                if(rs.getInt("food_delivery") == 1){
                    newRoom.setFoodDelivery(true);
                }
                else{
                    newRoom.setFoodDelivery(false);
                }
                roomList.add(newRoom);
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return roomList;
    }
    
    //Returns a list of rooms based on search inputs, leave parameters as 0.0f for price and the empty string for state if the client did not search using these
    public static ArrayList<Room> selectRooms(float price,String state) {
        ArrayList<Room> roomList = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            if(price == 0.0f && state.isEmpty()){
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id");
            }
            else if(price == 0.0f){
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND h.city = '" +state+"'");
            }
            else if(state.isEmpty()){
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND r.price = " + price);
            }
            else{
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND r.price = " + price + " AND h.city = '" +state+"'");
            }
            while (rs.next()) {
                Room newRoom = new Room();
                newRoom.setAddress(rs.getString("address"));
                newRoom.setCity(rs.getString("city"));
                newRoom.setName(rs.getString("name"));
                newRoom.setRoomDescription(rs.getString("description"));
                newRoom.setRoomID(rs.getInt("room_id"));
                newRoom.setRoomName(rs.getInt("number"));
                newRoom.setRoomPrice(rs.getFloat("price"));
                newRoom.setState("state");
                if(rs.getInt("pool") == 1){
                    newRoom.setPool(true);
                }
                else{
                    newRoom.setPool(false);
                }
                if(rs.getInt("breakfast") == 1){
                    newRoom.setBreakfast(true);
                }
                else{
                    newRoom.setBreakfast(false);
                }
                if(rs.getInt("food_delivery") == 1){
                    newRoom.setFoodDelivery(true);
                }
                else{
                    newRoom.setFoodDelivery(false);
                }
                roomList.add(newRoom);
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return roomList;
    }
    
    //NOTE: Not fully implemented yet, just sends a request to manager 6
    //Creates a request based on client desires, returns true if request was made, false if not
    public static boolean insertNewRequest(String desc, String category, int clientUuid){
        boolean inserted = false;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT max(request_id) FROM Request");
            rs.next();
            int uuid = rs.getInt("max(request_id)");
            inserted = statement.execute("insert into Request values("+uuid+",'"+desc+"','"+category+"',now(),NULL,6,"+clientUuid);
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return inserted;
    }
    /*
     TO IMPLEMENT QUERIES
     Guest
     Booking Info
     //Gets the hotel information where a specific customer is staying     
     //SELECT * FROM Booking b, Room r, Hotel h
     //WHERE b.room_id = r.room_id AND r.hotel_id = h.hotel_id AND b.customer_id = 7
     Returns the requests made by this client
     SELECT * FROM Request
     WHERE customer_id = 7
     //Book Room
     //Search for rooms with these qualities
     //SELECT * FROM Room r, Hotel h
     //WHERE r.hotel_id = h.hotel_id AND r.price = 120.00 AND h.city = 'Greensboro'
     ~Request
     ~Create a new request
     ~insert into Request
     ~values(2,'Pizza','Food',now(),NULL,6,7)
     ~Check the largest request_id so that a new one can be made
     ~SELECT max(request_id)
     ~FROM Request
    
    TO DO:
    Return a list of bookings of a certain room
    Create a booking
     */
}
