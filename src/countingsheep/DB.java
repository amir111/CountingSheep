package countingsheep;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    public Connection connect() {
        Connection connect = null;
        try {
            //This may or may not work, just testing the connection part of every method here
            //Make this a private method once tested fully
            
            //String driverName = "org.gjt.mm.mysql.Driver";
            //Class.forName(driverName);

            String serverName = "localhost";
            String mydatabase = "mydatabase";
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "username";
            String password = "password";
            connect = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {

        }
        return connect;
    }
}
