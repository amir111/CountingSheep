//Malcean Frazier

public class UserLogIn{

 public static char checkLogIn(String username,String psword){
        User user = DB.selectTargetUser(username);
        if (user.password.equals(psword)){
            return user.ID;
        }
        else{
            return 0;
        }
 }
}