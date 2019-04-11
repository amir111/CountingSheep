import java.util.ArrayList;

public class Room extends Hotel {
    int roomName;
    float roomPrice;
    int roomID;
    String roomDescription;
    //For DB.selectBookedRooms()
    boolean booked;
    ArrayList<RequestBooking> bookings;
    
    public Room(){
        
    }
    
    public int getRoomName(){
        return roomName;
    }
    
    public float getRoomPrice(){
        return roomPrice;
    }
    
    public int getRoomID(){
        return roomID;
    }
    
    public String getRoomDescription(){
        return roomDescription;
    }
    
    public void setRoomName(int _roomName){
        roomName = _roomName;
    }
    
    public void setRoomPrice(float _roomPrice){
        roomPrice = _roomPrice;
    }
    
    public void setRoomID(int _roomID){
        roomID = _roomID;
    }
    
    public void setRoomDescription(String _roomDescription){
        roomDescription = _roomDescription;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public ArrayList<RequestBooking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<RequestBooking> bookings) {
        this.bookings = bookings;
    }
    
    public void addBooking(RequestBooking addition){
        this.bookings.add(addition);
    }
    
    
}
