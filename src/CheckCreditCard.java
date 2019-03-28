/*
 Checks to make sure credit card is exactly 16 digits long, doesn't start with 0 and doesn't have letters
 */
import java.util.Scanner;

public class CheckCreditCard {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Create a Scanner
        System.out.print("Enter a 16 digit credit card number: ");
        String cc = input.nextLine();
        int stringLength = cc.length();
        if(numberOrNot(cc)){
            System.out.println(cc + " is valid");
        }
        else 
            System.out.println(cc + " is invalid");

    }

    static boolean numberOrNot(String cc) {
        if (cc.matches("^((?!(0))[0-9]{16})$")) {
            return true;
        } else {
            return false;
        }
    }
}

//Need to do Date Input Validation so user won't enter wrong format date
//example saved on desktop