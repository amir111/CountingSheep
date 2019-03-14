import java.lang.Object;
import java.util.ArrayList;

public class Hotel {
    //Room[] room = new Room[];
    ArrayList<Room> room = new ArrayList<Room>();
    String hotelName;
    String state;
    String city;
    String address;
    
    public Hotel(){
        
    }
    
    public ArrayList<Room> getRoom(){
        return room;
    }
    
    public String getName(){
        return hotelName;
    }
    
    public String getState(){
        return state;
    }
    
    public String getCity(){
        return city;
    }
    
    public String getAddress(){
        return address;
    }
   
    public void setRoom (Room _room){
        room.add(_room);
    }
    
    public void setName(String _name){
        hotelName =  _name;
    }
    
    public void setState(String _state){
        state = _state;
    }
    
    public void setCity(String _city){
        city = _city;
    }
    
    public void setAddress(String _address){
        address = _address;
    }
    
}
