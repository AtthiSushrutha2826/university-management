//
//package university.management.system;
//
//import java.sql.*;
//public class Conn {
//    Connection c;
//    Statement s;
//    Conn(){
//    try{
//        //Class.forName("con.mysql.cj.jdbc.Driver");
//        Class.forName("com.mysql.cj.jdbc.Driver");
//
//        //c=DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","Sushrutha@280206#");
//        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "Sushrutha@280206#");
//
//        s=c.createStatement();
//    }
//    catch (Exception e){
//        e.printStackTrace();
//    }
//        
//    }
//}
package university.management.system;

import java.sql.*;

public class Conn {
    public Connection con;

    public Conn() {
        try {
            // Ensure the JDBC driver is loaded and connection string is correct
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Database connection with the correct credentials
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "Sushrutha@280206#"); // Replace with actual password
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

