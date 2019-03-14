
public class Room extends Hotel {
    int roomName;
    float roomPrice;
    int roomID;
    String roomDescription;
    
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
}
