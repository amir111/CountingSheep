
public class Room extends Hotel {
    String roomName;
    float roomPrice;
    String roomID;
    String roomDescription;
    
    public Room(){
        
    }
    
    public String getRoomName(){
        return roomName;
    }
    
    public float getRoomPrice(){
        return roomPrice;
    }
    
    public String getRoomID(){
        return roomID;
    }
    
    public String getRoomDescription(){
        return roomDescription;
    }
    
    public void setRoomName(String _roomName){
        roomName = _roomName;
    }
    
    public void setRoomPrice(float _roomPrice){
        roomPrice = _roomPrice;
    }
    
    public void setRoomID(String _roomID){
        roomID = _roomID;
    }
    
    public void setRoomDescription(String _roomDescription){
        roomDescription = _roomDescription;
    }
}
