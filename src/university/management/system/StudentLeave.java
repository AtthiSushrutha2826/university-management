//
//package university.management.system;
//import com.toedter.calendar.JDateChooser;
//import java.awt.Color;
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//public class StudentLeave extends JFrame{
//    Choice crollno, ctime;
//    JDateChooser dcdate;
//    StudentLeave(){
//        setSize(500, 500);
//        setLocation(600, 100);
//        
//        getContentPane().setBackground(Color.white);
//        
//        JLabel heading = new JLabel("Apply leave");
//        heading.setBounds(40, 20, 300, 30);
//        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
//        add(heading);
//        
//        JLabel lblrollno = new JLabel("Search by Roll Number");
//        lblrollno.setFont(new Font("Tahoma",Font.PLAIN, 18));
//        lblrollno.setBounds(60, 100, 200, 20);
//        add(lblrollno);
//
//        // Dropdown choice for roll numbers
//        crollno = new Choice();
//        crollno.setBounds(60, 130, 200, 20);
//        add(crollno);
//
//        
//        try {
//            Conn c = new Conn();
//            Statement stmt = c.con.createStatement(); // Create a statement
//            ResultSet rs = stmt.executeQuery("select * from student");
//            while (rs.next()) {
//                crollno.add(rs.getString("rollno"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        
//        JLabel lbldate = new JLabel("Date");
//        lbldate.setFont(new Font("Tahoma",Font.PLAIN, 18));
//        lbldate.setBounds(60, 180, 200, 20);
//        add(lbldate);
//        
//        dcdate = new JDateChooser();
//        dcdate.setBounds(600, 210, 200, 30);
//        add(dcdate);
//        
//        
//        JLabel lbltime = new JLabel("Time Duration");
//        lbltime.setFont(new Font("Tahoma",Font.PLAIN, 18));
//        lbltime.setBounds(60, 260, 200, 20);
//        add(lbltime);
//        
//        ctime = new Choice();
//        ctime.setBounds(60, 290, 200, 20);
//        ctime.add("Fullday");
//        ctime.add("Halfday");
//        add(ctime);
//
//        setVisible(true);
//    }
//    
//     public static void main (String args[]){
//        new StudentLeave();
//    
//}}
package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class StudentLeave extends JFrame {
    Choice crollno, ctime;
    JDateChooser dcdate;

    StudentLeave() {
        // Frame properties
        setSize(500, 500);
        setLocation(600, 100);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Heading label
        JLabel heading = new JLabel("Apply Leave");
        heading.setBounds(150, 20, 200, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        // Roll number label and dropdown
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblrollno.setBounds(60, 100, 200, 20);
        add(lblrollno);

        crollno = new Choice();
        crollno.setBounds(60, 130, 200, 20);
        add(crollno);

        // Populate roll numbers
        try {
            Conn c = new Conn();
            Statement stmt = c.con.createStatement();
            ResultSet rs = stmt.executeQuery("select rollno from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Date label and chooser
        JLabel lbldate = new JLabel("Date");
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbldate.setBounds(60, 180, 200, 20);
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60, 210, 200, 30);
        add(dcdate);

        // Time duration label and dropdown
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltime.setBounds(60, 260, 200, 20);
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60, 290, 200, 20);
        ctime.add("Fullday");
        ctime.add("Halfday");
        add(ctime);

        // Submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(100, 350, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(e -> handleSubmit());
        add(submit);

        // Cancel button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(250, 350, 100, 30);
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(e -> setVisible(false));
        add(cancel);

        setVisible(true);
    }

    // Method to handle submit action
    private void handleSubmit() {
        String rollno = crollno.getSelectedItem();
        java.util.Date selectedDate = dcdate.getDate();
        String duration = ctime.getSelectedItem();

        if (rollno == null || selectedDate == null || duration == null || rollno.isEmpty() || duration.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Format the date to MySQL's required format (YYYY-MM-DD)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(selectedDate);

        try {
            Conn c = new Conn();
            String query = "INSERT INTO studentleave (rollno, date, duration) VALUES (?, ?, ?)";
            PreparedStatement pstmt = c.con.prepareStatement(query);
            pstmt.setString(1, rollno);
            pstmt.setString(2, formattedDate);
            pstmt.setString(3, duration);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Leave applied successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error applying leave", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
