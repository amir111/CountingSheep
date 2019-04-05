/*
 Checks to make sure credit card is exactly 16 digits long, doesn't start with 0 and doesn't have letters
 */

import java.util.Scanner;

public class CheckCreditCard {

    static boolean CheckTheCC(Long cc) {
//        Scanner input = new Scanner(System.in); // Create a Scanner
//        System.out.print("Enter a 16 digit credit card number: ");
        String cd = Long.toString(cc);
        //    int stringLength = cd.length();
        return numberOrNot(cd);
//        if(numberOrNot(cd)){
//            return true;
//        //    System.out.println(cc + " is valid");
//        }
//        else 
//            return false;
//        //    System.out.println(cc + " is invalid");

    }

    static boolean numberOrNot(String cd) {
        if (cd.matches("^((?!(0))[0-9]{16})$")) {
            return true;
        } else {
            return false;
        }
    }
}

//Need to do Date Input Validation so user won't enter wrong format date
//example saved on desktop
