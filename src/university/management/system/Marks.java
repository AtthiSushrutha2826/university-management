//
//package university.management.system;
//
//import java.awt.*;
//import java.sql.*;
//import javax.swing.*;
//public class Marks extends JFrame{
//    String rollno;
//    Marks( String rollno){
//        this.rollno=rollno;
//        setSize(500,600);
//        setVisible(true);
//        
//        setLayout(null);
//        getContentPane().setBackground(Color.WHITE);
//        
//
//        JLabel heading = new JLabel("Chennai Technical University");
//        heading.setBounds(100, 10, 500, 25);
//        heading.setFont(new Font("serif", Font.BOLD, 20));
//        add(heading);
//        
//        JLabel subheading = new JLabel("Result of examination 2023");
//        subheading.setBounds(600, 100, 500, 20);
//        subheading.setFont(new Font("serif", Font.BOLD, 20));
//        add(subheading);
//        
//        JLabel lblrollno = new JLabel("Roll Number "+rollno);
//        lblrollno.setBounds(60, 100, 500, 20);
//        lblrollno.setFont(new Font("serif", Font.PLAIN, 20));
//        add(lblrollno);
//        
//        JLabel lblsemester = new JLabel();
//        lblsemester.setBounds(100, 50, 500, 20);
//        lblsemester.setFont(new Font("serif", Font.PLAIN, 20));
//        add(lblsemester);
//        
//        JLabel sub1 = new JLabel();
//        sub1.setBounds(100, 200, 500, 20);
//        sub1.setFont(new Font("serif", Font.PLAIN, 20));
//        add(sub1);
//        
//        JLabel sub2 = new JLabel();
//        sub2.setBounds(100, 230, 500, 20);
//        sub2.setFont(new Font("serif", Font.PLAIN, 20));
//        add(sub2);
//        
//        JLabel sub3 = new JLabel();
//        sub3.setBounds(100, 260, 500, 20);
//        sub3.setFont(new Font("serif", Font.PLAIN, 20));
//        add(sub3);
//        
//        JLabel sub4 = new JLabel();
//        sub4.setBounds(100, 290, 500, 20);
//        sub4.setFont(new Font("serif", Font.PLAIN, 20));
//        add(sub4);
//        
//        JLabel sub5 = new JLabel();
//        sub5.setBounds(100, 320, 500, 20);
//        sub5.setFont(new Font("serif", Font.PLAIN, 20));
//        add(sub5);
//        
//        try{
//            Conn c = new Conn();
//            ResultSet rs1 = c.con.createStatement().executeQuery("select * from subject where rollno= '"+rollno+"'");
//            while(rs1.next()){
//                sub1.setText(rs1.getString("subject1"));
//                sub2.setText(rs1.getString("subject2"));
//                sub3.setText(rs1.getString("subject3"));
//                sub4.setText(rs1.getString("subject4"));
//                sub5.setText(rs1.getString("subject5"));
//            }
//            
//            ResultSet rs2 = c.con.createStatement().executeQuery("select * from subject where rollno= '"+rollno+"'");
//            while(rs2.next()){
//                sub1.setText(sub1.getText()+"----------"+rs2.getString("marks1"));
//                sub2.setText(sub2.getText()+"----------"+rs2.getString("marks2"));
//                sub3.setText(sub3.getText()+"----------"+rs2.getString("marks3"));
//                sub4.setText(sub4.getText()+"----------"+rs2.getString("marks4"));
//                sub5.setText(sub5.getText()+"----------"+rs2.getString("marks5"));
//                lblsemester.setText("Semester "+ rs2.getString("semester"));
//            }
//            
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//       
//    }
//    
//    public static void main(String args[]){
//        new Marks("");
//    }
//    
//}
package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class Marks extends JFrame {
    String rollno;

    Marks(String rollno) {
        this.rollno = rollno;

        setSize(500, 600);
        setLocation(400, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Chennai Technical University");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2023");
        subheading.setBounds(100, 50, 500, 20);
        subheading.setFont(new Font("serif", Font.BOLD, 20));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number: " + rollno);
        lblrollno.setBounds(100, 90, 500, 20);
        lblrollno.setFont(new Font("serif", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(100, 120, 500, 20);
        lblsemester.setFont(new Font("serif", Font.PLAIN, 18));
        add(lblsemester);

        // Labels for subjects and marks
        JLabel sub1 = new JLabel();
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("serif", Font.PLAIN, 18));
        add(sub1);

        JLabel sub2 = new JLabel();
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("serif", Font.PLAIN, 18));
        add(sub2);

        JLabel sub3 = new JLabel();
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("serif", Font.PLAIN, 18));
        add(sub3);

        JLabel sub4 = new JLabel();
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("serif", Font.PLAIN, 18));
        add(sub4);

        JLabel sub5 = new JLabel();
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("serif", Font.PLAIN, 18));
        add(sub5);

     try {
    Conn c = new Conn();

    // Query to join subject and marks tables using rollno and semester
    String query = "SELECT s.subject1, s.subject2, s.subject3, s.subject4, s.subject5, "
                 + "m.marks1, m.marks2, m.marks3, m.marks4, m.marks5, m.semester "
                 + "FROM subject s "
                 + "JOIN marks m ON s.rollno = m.rollno AND s.semester = m.semester "
                 + "WHERE s.rollno = '" + rollno + "'";

    ResultSet rs = c.con.createStatement().executeQuery(query);

    if (rs.next()) {
        // Display Semester
        lblsemester.setText("Semester: " + rs.getString("semester"));

        // Display Subjects and Marks
        sub1.setText("Subject: " + rs.getString("subject1") + " | Marks: " + rs.getString("marks1"));
        sub2.setText("Subject: " + rs.getString("subject2") + " | Marks: " + rs.getString("marks2"));
        sub3.setText("Subject: " + rs.getString("subject3") + " | Marks: " + rs.getString("marks3"));
        sub4.setText("Subject: " + rs.getString("subject4") + " | Marks: " + rs.getString("marks4"));
        sub5.setText("Subject: " + rs.getString("subject5") + " | Marks: " + rs.getString("marks5"));
    } else {
        JOptionPane.showMessageDialog(null, "No data found for Roll Number: " + rollno);
    }
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error fetching data: " + e.getMessage());
}



        setVisible(true);
    }

    public static void main(String args[]) {
        new Marks("default");
    }
}
