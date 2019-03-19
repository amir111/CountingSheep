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

    private static int getNewId(String table, Statement statement) {
        int uuid = -1;
        try {
            ResultSet rs = statement.executeQuery("SELECT max(" + table.toLowerCase() + "_id) FROM " + table);
            rs.next();
            uuid = rs.getInt("max(" + table.toLowerCase() + "_id)") + 1;
        } catch (Exception e) {

        }
        return uuid;
    }

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
                if (rs.getInt("pool") == 1) {
                    newRoom.setPool(true);
                } else {
                    newRoom.setPool(false);
                }
                if (rs.getInt("breakfast") == 1) {
                    newRoom.setBreakfast(true);
                } else {
                    newRoom.setBreakfast(false);
                }
                if (rs.getInt("food_delivery") == 1) {
                    newRoom.setFoodDelivery(true);
                } else {
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
    public static ArrayList<Room> selectRooms(float price, String city) {
        ArrayList<Room> roomList = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            if (price == 0.0f && city.isEmpty()) {
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id");
            } else if (price == 0.0f) {
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND h.city = '" + city + "'");
            } else if (city.isEmpty()) {
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND r.price = " + price);
            } else {
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND r.price = " + price + " AND h.city = '" + city + "'");
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
                if (rs.getInt("pool") == 1) {
                    newRoom.setPool(true);
                } else {
                    newRoom.setPool(false);
                }
                if (rs.getInt("breakfast") == 1) {
                    newRoom.setBreakfast(true);
                } else {
                    newRoom.setBreakfast(false);
                }
                if (rs.getInt("food_delivery") == 1) {
                    newRoom.setFoodDelivery(true);
                } else {
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

    //Returns a list of bookings that a particular room has
    public static ArrayList<RequestBooking> selectBookingsByRoom(int roomUuid) {
        ArrayList<RequestBooking> bookings = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Booking WHERE room_id = " + roomUuid);
            while (rs.next()) {
                RequestBooking newBooking = new RequestBooking();
                newBooking.setRoom_id(rs.getInt("room_id"));
                newBooking.setStart_date(rs.getDate("start_date"));
                newBooking.setEnd_date(rs.getDate("end_date"));
                newBooking.setCustomer_id(rs.getInt("customer_id"));
                newBooking.setBooking_id(rs.getInt("booking_id"));
                bookings.add(newBooking);
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return bookings;
    }
    
    //NOTE: Timestamps a little buggy but it does contain all important information thats in the database
    //Returns a list of requests made by a specific client
    public static ArrayList<PersonalRequest> selectRequestByClient(int clientUuid){
        ArrayList<PersonalRequest> requests = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Request WHERE customer_id = "+clientUuid);
            while (rs.next()) {
                PersonalRequest newReq = new PersonalRequest();
                newReq.setCategory(rs.getString("category"));
                newReq.setCompletionTime(rs.getTimestamp("completion_time"));
                newReq.setCreationTime(rs.getTimestamp("creation_time"));
                newReq.setCustomerId(rs.getInt("customer_id"));
                newReq.setDesc(rs.getString("description"));
                newReq.setManagerId(rs.getInt("manager_id"));
                newReq.setRequestId(rs.getInt("request_id"));
                requests.add(newReq);
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return requests;
    }

    //Creates a request based on client desires, returns true if request was made, false if not
    public static boolean insertNewRequest(String desc, String category, int managerUuid, int clientUuid) {
        boolean inserted = false;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            int uuid = getNewId("Request", statement);
            int numInserted = statement.executeUpdate("insert into Request\n values('" + uuid + "','" + desc + "','" + category + "',now(),NULL,'" + managerUuid + "','" + clientUuid + "');");
            if (numInserted > 0) {
                inserted = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return inserted;
    }
    
    //NOTE: The Date data type will not work as java's date format is nowhere near the same as SQL's, thus maybe we should use strings or look for alternatives
    //This method creates a new booking in the database based on client input
    public static boolean insertNewBooking(String start,String end,int customerUuid,int roomUuid) {
        boolean inserted = false;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            int uuid = getNewId("Booking", statement);
            int numInserted = statement.executeUpdate("insert into Booking\n values('"+uuid+"','"+start+"','"+end+"','"+customerUuid+"','"+roomUuid+"');");
            if (numInserted > 0) {
                inserted = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return inserted;
    }
}
