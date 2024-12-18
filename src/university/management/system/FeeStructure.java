//
//package university.management.system;
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;
//public class FeeStructure extends JFrame{
//    FeeStructure(){
//        setSize(1000, 700);
//        setLocation(250,50);
//        setLayout(null);
//        getContentPane().setBackground(Color.white);
//        
//        JLabel heading = new JLabel("Fees Structure");
//        heading.setBounds(50, 10, 400, 30);
//        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
//        add(heading);
//        
//        
//        JTable table = new JTable();
//        
//        try{
//            
//         Conn con = new Conn();
//         PreparedStatement rs = con.con.prepareStatement("select * from fee");
//         table.setModel(DbUtils.resultSetToTableModel(rs));
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        JScrollPane jsp = new JScrollPane(table);
//        jsp.setBounds(0, 60, 1000, 700);
//        add(jsp);
//        
//        
//        setVisible(true);
//    }
//    
//    public static void main(String args[]){
//        new FeeStructure();
//    }
//    
//}
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    FeeStructure() {
        // Frame properties
        setSize(1000, 700);
        setLocation(250, 50);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        // Heading Label
        JLabel heading = new JLabel("Fees Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        // JTable to display data
        JTable table = new JTable();

        try {
            // Establish database connection and fetch data
            Conn con = new Conn();
            String query = "SELECT * FROM fee";
            PreparedStatement ps = con.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery(); // Execute the query
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Populate table with result
            rs.close(); // Close ResultSet
            ps.close(); // Close PreparedStatement
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add JScrollPane containing the JTable
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 600); // Adjusted height to fit within the frame
        add(jsp);

        // Make frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
