package countingsheep;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private static Connection connect() {
        Connection connect = null;
        try {
            //NOTE: This method will not work unless you go to project properties -> libraries -> add the jar thats in the mysql-connector-java... folder
            String serverName = "localhost:3306";
            String mydatabase = "counting_sheep";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "java";
            String password = "password";
            connect = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            throw new IllegalStateException("Cannot connect",e);
        }
        return connect;
    }
    
    public static void searchUsers(){
        Connection conn = connect();
    }
}
