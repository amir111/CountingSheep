/*
 Boolean check if date overlap or not 
 */

import java.sql.Date;
import java.time.LocalDate;
//my comp prints 
//yyyy-mm-ddThh:mm:ss.xxx
//2019-03-25T04:56:10.764

public class CheckDateOverlap {

    public static void main(String[] args) {
        
        //mb try to ask user for 
        //enter start_date yyyy, now month mm, now enter dd
        //enter end_date yyye, now month me, now enter de
        // start_date2 and end_date2 could be final as they are already assigned to a room...but how? 
        int k = 2; //it knows this will be 02
        
        Date start_date = Date.valueOf(LocalDate.of(2017, k, 10)); //can also do this to show todays date, -> Date start_date = Date.valueOf(LocalDate.now());
        Date end_date = Date.valueOf(LocalDate.of(2019, 03, 10));
        Date start_date2 = Date.valueOf(LocalDate.of(2019, 03, 11));
        Date end_date2 = Date.valueOf(LocalDate.of(2019, 03, 31));
        if ((start_date.getTime() <= end_date2.getTime()) && (start_date2.getTime() <= end_date.getTime())) {
            System.out.println("conflict");
            System.out.println(start_date + " " + end_date + " " + start_date2 + " " + end_date2);
        } else {
            System.out.println("no conflict");
            System.out.println(start_date + " " + end_date + " " + start_date2 + " " + end_date2);
        }
    }
    //Make a User Validation Check to make sure the input is only integers for dates not strings etc
    
}
