//plz work 


import java.util.*;
import java.util.Date;



//class customer has email, cell phone
class Customer extends User {

    // the customer subclass adds one more field 
    private String email;
    private int phone;
//
//    //the customer subclass has one contrustor 
//    public void doStuff() {
//        System.out.println("Jamming");
//    }

    public Date date; //wouldn't date be two dates??
    private int noOfAdults;

    // the Customer subclass adds one more method that sets date
    public void setDate(Date date) {
        this.date = date;
    }

    // the Customer subclass adds one more method that gets date
    public Date getDate() {
        return this.date;
    }

    // the Customer subclass adds one more method that sets no of adults
    public void setNoOfAdults(Date date) {
        this.noOfAdults = noOfAdults;
    }

    // the Customer subclass adds one more method that gets no of adults
    public int getNoOfAdults() {
        return this.noOfAdults;
    }
}
