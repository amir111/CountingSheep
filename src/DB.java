
import java.sql.*;
import java.util.ArrayList;

public class DB {

    private static Connection connect() {
        Connection connect = null;
        try {
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

    public static boolean roomExists(int userUuid, int roomNum) {
        Connection conn = connect();
        Hotel hotel = DB.selectHotelByManager(userUuid);
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Room WHERE hotel_id = '" + hotel.getHotelID() + "' AND number = '" + roomNum + "'");
            if (rs.next()) {
                return true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return false;
    }
    
    public static int getManagerOfMyBooking(RequestBooking booking){
        int managerUuid = -1;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT user_id FROM Booking b, Room r, Hotel h, User u WHERE b.room_id = r.room_id AND r.hotel_id = h.hotel_id AND h.manager_id = u.user_id AND booking_id = "+ booking.getBooking_id());
            if (rs.next()) {
                managerUuid = rs.getInt("user_id");
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return managerUuid;
    }
    
    public static String getUsernameFromRequest(PersonalRequest request) {
        String uname = "";
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT uname FROM User u, Request r WHERE r.customer_id = u.user_id AND r.request_id = 1");
            if (rs.next()) {
                uname = rs.getString("uname");
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return uname;
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
    public static ArrayList<Room> selectClientBookedRooms(int clientUuid) {
        ArrayList<Room> roomList = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Booking b, Room r, Hotel h WHERE b.room_id = r.room_id AND r.hotel_id = h.hotel_id AND b.customer_id = " + clientUuid + "  AND b.end_date >= date(now())");
            while (rs.next()) {
                Room newRoom = new Room();
                newRoom.setAddress(rs.getString("address"));
                newRoom.setCity(rs.getString("city"));
                newRoom.setName(rs.getString("name"));
                newRoom.setRoomDescription(rs.getString("description"));
                newRoom.setRoomID(rs.getInt("room_id"));
                newRoom.setRoomName(rs.getInt("number"));
                newRoom.setRoomPrice(rs.getFloat("price"));
                newRoom.setState(rs.getString("state"));
                newRoom.setHotelID(rs.getInt("hotel_id"));
                newRoom.setRating(rs.getInt("rating"));
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
    
    //Returns a list of all rooms in a hotel, and whether or not the rooms are booked
    public static ArrayList<Room> selectBookedRooms(int managerUuid) {
        ArrayList<Room> roomList = new ArrayList<>();
        Hotel hotel = DB.selectHotelByManager(managerUuid);
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND h.hotel_id = "+hotel.getHotelID()+" AND r.room_id IN (SELECT room_id FROM Booking WHERE date(now()) <= end_date)");
            while (rs.next()) {
                Room newRoom = new Room();
                newRoom.setAddress(rs.getString("address"));
                newRoom.setCity(rs.getString("city"));
                newRoom.setName(rs.getString("name"));
                newRoom.setRoomDescription(rs.getString("description"));
                newRoom.setRoomID(rs.getInt("room_id"));
                newRoom.setRoomName(rs.getInt("number"));
                newRoom.setRoomPrice(rs.getFloat("price"));
                newRoom.setState(rs.getString("state"));
                newRoom.setRating(rs.getInt("rating"));
                newRoom.setBooked(true);
                newRoom.setBookings(DB.selectBookingsByRoom(newRoom.getRoomID()));
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
            rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND h.hotel_id = "+hotel.getHotelID()+" AND r.room_id NOT IN (SELECT room_id FROM Booking WHERE now() < end_date)");
            while (rs.next()) {
                Room newRoom = new Room();
                newRoom.setAddress(rs.getString("address"));
                newRoom.setCity(rs.getString("city"));
                newRoom.setName(rs.getString("name"));
                newRoom.setRoomDescription(rs.getString("description"));
                newRoom.setRoomID(rs.getInt("room_id"));
                newRoom.setRoomName(rs.getInt("number"));
                newRoom.setRoomPrice(rs.getFloat("price"));
                newRoom.setState(rs.getString("state"));
                newRoom.setRating(rs.getInt("rating"));
                newRoom.setBooked(false);
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

    //Returns the current booking of a client if there is one
    public static RequestBooking selectCurrentBooking(int clientUuid) {
        RequestBooking current = new RequestBooking();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Booking WHERE customer_id = " + clientUuid + " AND date(now()) BETWEEN start_date AND end_date");
            if (rs.next()) {
                current.setRoom_id(rs.getInt("room_id"));
                current.setStart_date(rs.getString("start_date"));
                current.setEnd_date(rs.getString("end_date"));
                current.setCustomer_id(rs.getInt("customer_id"));
                current.setBooking_id(rs.getInt("booking_id"));
            } else {
                conn.close();
                return null;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return current;
    }

    //Returns a list of rooms based on search inputs, leave parameters as 0.0f for price and the empty string for state if the client did not search using these
    public static ArrayList<Room> selectRooms(float price, String city) {
        ArrayList<Room> roomList = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            if (price == 0.0f && city.equals("")) {
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id");
            } else if (price == 0.0f) {
                rs = statement.executeQuery("SELECT * FROM Room r, Hotel h WHERE r.hotel_id = h.hotel_id AND h.city = '" + city + "'");
            } else if (city.equals("")) {
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
                newRoom.setState(rs.getString("state"));
                newRoom.setRating(rs.getInt("rating"));
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
                newBooking.setStart_date(rs.getString("start_date"));
                newBooking.setEnd_date(rs.getString("end_date"));
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
    public static ArrayList<PersonalRequest> selectRequestsByClient(int clientUuid) {
        ArrayList<PersonalRequest> requests = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Request WHERE customer_id = " + clientUuid);
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

    //Returns a list of requests based on the manager and whether the requests are complete or not
    public static ArrayList<PersonalRequest> selectRequestsByManager(int managerUuid, boolean complete) {
        ArrayList<PersonalRequest> requests = new ArrayList<>();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs;
            if (complete) {
                rs = statement.executeQuery("SELECT * FROM Request WHERE manager_id = " + managerUuid + " AND completion_time IS NOT NULL");
            } else {
                rs = statement.executeQuery("SELECT * FROM Request WHERE manager_id = " + managerUuid + " AND completion_time IS NULL");
            }
            while (rs.next()) {
                PersonalRequest newReq = new PersonalRequest();
                newReq.setCategory(rs.getString("category"));
                newReq.setCompletionTime(rs.getTimestamp("completion_time"));
                newReq.setCreationTime(rs.getTimestamp("creation_time"));
                newReq.setCustomerId(rs.getInt("customer_id"));
                newReq.setDesc(rs.getString("description"));
                newReq.setManagerId(rs.getInt("manager_id"));
                newReq.setRequestId(rs.getInt("request_id"));
                newReq.setCustomerName(DB.getUsernameFromRequest(newReq));
                requests.add(newReq);
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return requests;
    }

    //Returns the hotel that a specific manager manages
    public static Hotel selectHotelByManager(int managerUuid) {
        Hotel hotel = new Hotel();
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Hotel WHERE manager_id = '" + managerUuid + "'");
            if (rs.next()) {
                hotel.setHotelID(rs.getInt("hotel_id"));
                hotel.setAddress(rs.getString("address"));
                hotel.setCity(rs.getString("city"));
                hotel.setName(rs.getString("name"));
                hotel.setState(rs.getString("state"));
                hotel.setRating(rs.getInt("rating"));
                if (rs.getInt("pool") == 1) {
                    hotel.setPool(true);
                } else {
                    hotel.setPool(false);
                }
                if (rs.getInt("breakfast") == 1) {
                    hotel.setBreakfast(true);
                } else {
                    hotel.setBreakfast(false);
                }
                if (rs.getInt("food_delivery") == 1) {
                    hotel.setFoodDelivery(true);
                } else {
                    hotel.setFoodDelivery(false);
                }
            }
            rs = statement.executeQuery("SELECT * FROM Room WHERE hotel_id = '" + hotel.getHotelID() + "'");
            while (rs.next()) {
                Room newRoom = new Room();
                newRoom.setAddress(hotel.getAddress());
                newRoom.setCity(hotel.getCity());
                newRoom.setName(hotel.getName());
                newRoom.setRoomDescription(rs.getString("description"));
                newRoom.setRoomID(rs.getInt("room_id"));
                newRoom.setRoomName(rs.getInt("number"));
                newRoom.setRoomPrice(rs.getFloat("price"));
                newRoom.setState(hotel.getState());
                newRoom.setRating(hotel.getRating());
                newRoom.setPool(hotel.isPool());
                newRoom.setBreakfast(hotel.isBreakfast());
                newRoom.setFoodDelivery(hotel.isFoodDelivery());
                hotel.setRoom(newRoom);
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return hotel;
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
    public static boolean insertNewBooking(String start, String end, int customerUuid, int roomUuid) {
        boolean inserted = false;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();

            int uuid = getNewId("Booking", statement);
            int numInserted = statement.executeUpdate("insert into Booking\n values('" + uuid + "','" + start + "','" + end + "','" + customerUuid + "','" + roomUuid + "');");
            if (numInserted > 0) {
                inserted = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return inserted;
    }

    //This method creates a new room based on manager input
    public static boolean insertNewRoom(int roomNumber, String description, float price, int userUuid) {
        Hotel hotel = DB.selectHotelByManager(userUuid);
        if (roomExists(userUuid, roomNumber)) {
            return false;
        }
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            int uuid = getNewId("Room", statement);
            statement.executeUpdate("insert into Room\n values('" + uuid + "','" + roomNumber + "','" + description + "','" + price + "','" + hotel.getHotelID() + "');");
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return true;
    }

    //This method deletes a room within the manager's hotel
    public static boolean deleteRoomByNumber(int roomNumber, int userUuid) {
        boolean deleted = false;
        Hotel hotel = DB.selectHotelByManager(userUuid);
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            int numDeleted = statement.executeUpdate("delete from Room\n where number = '" + roomNumber + "' AND hotel_id = '" + hotel.getHotelID() + "'");
            if (numDeleted > 0) {
                deleted = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return deleted;
    }

    //This method updates target room number within the manager's hotel, this assume that either the description or the price is not null
    public static boolean updateRoom(int roomNumber, int userUuid, String description, float price) {
        Hotel hotel = DB.selectHotelByManager(userUuid);
        if (!roomExists(userUuid, roomNumber)) {
            return false;
        }
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            String sql;
            if (description.equals("")) {
                sql = "update Room\nset price = '" + price + "'\nwhere number = '" + roomNumber + "' and hotel_id = '" + hotel.getHotelID() + "'";
            } else if (price == 0.0f) {
                sql = "update Room\nset description = '" + description + "'\nwhere number = '" + roomNumber + "' and hotel_id = '" + hotel.getHotelID() + "'";
            } else {
                sql = "update Room\nset description = '" + description + "', price = '" + price + "'\nwhere number = '" + roomNumber + "' and hotel_id = '" + hotel.getHotelID() + "'";
            }
            statement.executeUpdate(sql);
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return true;
    }

    //This method sets target request as complete
    public static boolean updateRequestAsComplete(int requestUuid) {
        boolean updated = false;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            int numUpdated = statement.executeUpdate("update Request\nset completion_time = now()\nwhere request_id = '" + requestUuid + "'");
            if (numUpdated > 0) {
                updated = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return updated;
    }

    //This method changes target user's password
    public static boolean updateUserPassword(int UserUuid, String newPassword) {
        boolean updated = false;
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            int numUpdated = statement.executeUpdate("update User\nset pword = '" + newPassword + "'\nwhere user_id = '" + UserUuid + "'");
            if (numUpdated > 0) {
                updated = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return updated;
    }

    //This method updates the manager's hotel's features
    public static boolean updateHotelFeatures(int userUuid, boolean breakfast, boolean pool, boolean foodDelivery) {
        boolean updated = false;
        Hotel hotel = DB.selectHotelByManager(userUuid);
        Connection conn = connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "update Hotel\nset";
            if (breakfast) {
                sql += " breakfast = '" + 1 + "',";
            } else {
                sql += " breakfast = '" + 0 + "',";
            }
            if (pool) {
                sql += " pool = '" + 1 + "',";
            } else {
                sql += " pool = '" + 0 + "',";
            }
            if (foodDelivery) {
                sql += " food_delivery = '" + 1 + "',";
            } else {
                sql += " food_delivery = '" + 0 + "',";
            }
            sql = sql.substring(0, sql.length() - 1);
            sql += "\nwhere hotel_id = '" + hotel.getHotelID() + "'";
            int numUpdated = statement.executeUpdate(sql);
            if (numUpdated > 0) {
                updated = true;
            }
            conn.close();
        } catch (Exception e) {
            throw new IllegalStateException("", e);
        }
        return updated;
    }
}
