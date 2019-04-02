//Malcean Frazier

public class UserLogIn{

 public static User checkLogIn(String username,String psword){
        try{
        User user = DB.selectTargetUser(username);
        if (user.password.equals(psword)){
            return user;
        }
        else{
            return null;
        }
        }
        catch(Exception e){
            return null;
        }
        
 }
}