import java.util.Date;

public class RequestBooking {
    //3 ints 2dates 
    int booking_id; 
    Date start_date; 
    Date end_date; 
    int customer_id;
    int room_id; 
    
    public int getBooking_id(){
        return booking_id;
    }

    public void setBooking_id(int booking_id) {
        booking_id = booking_id;
    }
    
    public int getCustomer_id(){
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        customer_id = customer_id;
    }
    
    public int getRoom_id(){
        return room_id;
    }

    public void setRoom_id(int room_id) {
        room_id = room_id;
    }
    
    public Date getStart_date(){
        return start_date;
    }

    public void setStart_date(Date start_date) {
        start_date = start_date;
    }
    
    public Date getEnd_date(){
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        end_date = end_date;
    }
}