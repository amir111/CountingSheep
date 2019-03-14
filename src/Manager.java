
public class Manager extends User{
    Hotel hotel = new Hotel();
    
    public Manager(){
        
    }
    
    public Hotel getHotel(){
        return hotel;
    }
    
    public void setHotel(Hotel _hotel){
        hotel = _hotel;
    }
}
