
public class User {
     String username;
     String password;
     char ID;
     String email;
     String phone;
     String name;
  
    public User(){
        
    }
    public String getUsername(){
        return username;
    }
     
    public String getPassword(){
        return password;
    }
    
    public char getID(){
        return ID;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public String getName(){
        return name;
    }
    
    public void setUsername(String _username){
        username = _username;
    }
    
    public void setPassword(String _password){
        password = _password;
    }
    
    public void setID(char _ID){
        ID = _ID;
    }
    
    public void setEmail(String _email){
        email = _email;
    }
    
    public void setPhone(String _phone){
        phone = _phone;
    }
    
    public void setName(String _name){
        name = _name;
    }

}

