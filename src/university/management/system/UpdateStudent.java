//
//package university.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import com.toedter.calendar.JDateChooser;
//import java.sql.*; // Import for database operations
//
//
//public class UpdateStudent extends JFrame implements ActionListener {
//    JTextField tfcourse, tfaddress, tfphone, tfemail,tfbranch;
//    JLabel labelrollno;
//    JButton submit, cancel;
//    Choice crollno;
//    
//    UpdateStudent() {
//        setSize(900, 650);
//        setLocation(350, 50);
//        setLayout(null);
//
//        JLabel heading = new JLabel("Update Student Details");
//        heading.setBounds(50, 10, 500, 50);
//        heading.setFont(new Font("serif", Font.ITALIC, 35));
//        add(heading);
//        
//        JLabel lblrollnumber = new JLabel("Select Roll Number");
//        lblrollnumber.setBounds(50, 100, 200, 20);
//        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
//        add(lblrollnumber);
//
//        // Dropdown choice for roll numbers
//        crollno = new Choice();
//        crollno.setBounds(250, 100, 200, 20);
//        add(crollno);
//
//        // Populate the Choice dropdown with roll numbers
//        try {
//            Conn c = new Conn();
//            Statement stmt = c.con.createStatement(); // Create a statement
//            ResultSet rs = stmt.executeQuery("select rollno from student");
//            while (rs.next()) {
//                crollno.add(rs.getString("rollno"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        JLabel lblname = new JLabel("Name:");
//        lblname.setBounds(50, 150, 100, 30);
//        lblname.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblname);
//
//        JLabel labelname = new JLabel();
//        labelname.setBounds(200, 150, 150, 30);
//        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        add(labelname);
//
//        JLabel lblfname = new JLabel("Father's Name:");
//        lblfname.setBounds(400, 150, 200, 30);
//        lblfname.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblfname);
//
//        JLabel labelfname = new JLabel();
//        labelfname.setBounds(600, 150, 150, 30);
//        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        add(labelfname);
//
//        JLabel lblrollno = new JLabel("Roll Number:");
//        lblrollno.setBounds(50, 200, 200, 30);
//        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblrollno);
//
//        labelrollno = new JLabel();
//        labelrollno.setBounds(200, 200, 200, 30);
//        labelrollno.setFont(new Font("serif", Font.PLAIN, 20));
//        add(labelrollno);
//
//        JLabel lbldob = new JLabel("DOB:");
//        lbldob.setBounds(400, 200, 200, 30);
//        lbldob.setFont(new Font("serif", Font.BOLD, 20));
//        add(lbldob);
//
//        JLabel labeldob = new JLabel();
//        labeldob.setBounds(600, 200, 150, 30);
//        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
//        add(labeldob);
//
//        JLabel lbladdress = new JLabel("Address:");
//        lbladdress.setBounds(50, 250, 200, 30);
//        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
//        add(lbladdress);
//
//        tfaddress = new JTextField();
//        tfaddress.setBounds(200, 250, 150, 30);
//        tfaddress.setFont(new Font("serif", Font.PLAIN, 20));
//        add(tfaddress);
//
//        JLabel lblphone = new JLabel("Phone:");
//        lblphone.setBounds(400, 250, 200, 30);
//        lblphone.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblphone);
//
//        tfphone = new JTextField();
//        tfphone.setBounds(600, 250, 150, 30);
//        tfphone.setFont(new Font("serif", Font.PLAIN, 20));
//        add(tfphone);
//
//        JLabel lblemail = new JLabel("Email:");
//        lblemail.setBounds(50, 300, 200, 30);
//        lblemail.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblemail);
//
//        tfemail = new JTextField();
//        tfemail.setBounds(200, 300, 150, 30);
//        tfemail.setFont(new Font("serif", Font.PLAIN, 20));
//        add(tfemail);
//
//        JLabel lblx = new JLabel("Class 10%:");
//        lblx.setBounds(400, 300, 200, 30);
//        lblx.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblx);
//
//        JLabel labelx = new JLabel();
//        labelx.setBounds(600, 300, 150, 30);
//        labelx.setFont(new Font("serif", Font.PLAIN, 20));
//        add(labelx);
//
//        JLabel lblxii = new JLabel("Class 12%:");
//        lblxii.setBounds(50, 350, 200, 30);
//        lblxii.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblxii);
//
//        JLabel labelxii = new JLabel();
//        labelxii.setBounds(200, 350, 150, 30);
//        labelxii.setFont(new Font("serif", Font.PLAIN, 20));
//        add(labelxii);
//
//        JLabel lblaadhar = new JLabel("Aadhar:");
//        lblaadhar.setBounds(400, 350, 200, 30);
//        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblaadhar);
//
//        JLabel labelaadhar = new JLabel();
//        labelaadhar.setBounds(600, 350, 150, 30);
//        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
//        add(labelaadhar);
//
//        JLabel lblcourse = new JLabel("Course:");
//        lblcourse.setBounds(50, 400, 200, 30);
//        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblcourse);
//
//        
//        tfcourse = new JTextField();
//        tfcourse.setBounds(200, 400, 150, 30);
//        tfcourse.setFont(new Font("serif", Font.PLAIN, 20));
//        add(tfcourse);
//
//        JLabel lblbranch = new JLabel("Branch:");
//        lblbranch.setBounds(400, 400, 200, 30);
//        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
//        add(lblbranch);
//
//        
//        tfbranch = new JTextField();
//        tfbranch.setBounds(600, 400, 150, 30);
//        tfaddress.setFont(new Font("serif", Font.PLAIN, 20));
//        add(tfbranch);
//        
//        try{
//            Conn c = new Conn();
//            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
//            
//            Statement stmt = c.con.createStatement(); // Create a statement
//            ResultSet rs = stmt.executeQuery(query);
//            
//            //ResultSet rs = c.s.ExecuteQuery(query);
//            while(rs.next()){
//                labelname.setText(rs.getString("name"));
//                labelfname.setText(rs.getString("fname"));
//                labeldob.setText(rs.getString("dob"));
//                tfaddress.setText(rs.getString("address"));
//                tfphone.setText(rs.getString("phone"));
//                tfemail.setText(rs.getString("email"));
//                labelx.setText(rs.getString("class_x"));
//                labelxii.setText(rs.getString("class_xii"));
//                labelaadhar.setText(rs.getString("aadhar"));
//                labelrollno.setText(rs.getString("rollno"));
//                tfcourse.setText(rs.getString("course"));
//                tfbranch.setText(rs.getString("branch"));
//            }
//            
//        }catch(Exception e){
//           e.printStackTrace(); 
//        }
//        
//        crollno.addItemListener(new itemListener);
//        
//        
//        
//
//        submit = new JButton("Update");
//        submit.setBounds(250, 500, 120, 30);
//        submit.addActionListener(this);
//        add(submit);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(450, 500, 120, 30);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//    if (ae.getSource() == submit) {
//        String name = tfname.getText();
//        String fname = tffname.getText();
//        String rollno = labelrollno.getText();
//        String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
//        String address = tfaddress.getText();
//        String phone = tfphone.getText();
//        String email = tfemail.getText();
//        String classX = tfx.getText();
//        String classXII = tfxii.getText();
//        String aadhar = tfaadhar.getText();
//        String course = (String) cbcourse.getSelectedItem();
//        String branch = (String) cbbranch.getSelectedItem();
//
//        try {
//            // Updated SQL query to match the student table structure
//            String query = "INSERT INTO student (name, fname, rollno, dob, address, phone, email, class_x, class_xii, aadhar, course, branch) "
//                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            Conn con = new Conn();
//            PreparedStatement pstmt = con.con.prepareStatement(query);
//
//            // Set parameters for PreparedStatement
//            pstmt.setString(1, name.isEmpty() ? null : name);
//            pstmt.setString(2, fname.isEmpty() ? null : fname);
//            pstmt.setString(3, rollno);
//            pstmt.setString(4, dob.isEmpty() ? null : dob); // Handles date as a string (ensure format matches database expectations)
//            pstmt.setString(5, address.isEmpty() ? null : address);
//            pstmt.setString(6, phone.isEmpty() ? null : phone);
//            pstmt.setString(7, email.isEmpty() ? null : email);
//            pstmt.setFloat(8, classX.isEmpty() ? 0 : Float.parseFloat(classX)); // Handle `class_x` as float
//            pstmt.setFloat(9, classXII.isEmpty() ? 0 : Float.parseFloat(classXII)); // Handle `class_xii` as float
//            pstmt.setString(10, aadhar.isEmpty() ? null : aadhar);
//            pstmt.setString(11, course);
//            pstmt.setString(12, branch);
//
//            // Execute the query
//            pstmt.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Student details added successfully");
//            setVisible(false);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
//    } else if (ae.getSource() == cancel) {
//        setVisible(false);
//    }
//}
//
//
//    public static void main(String[] args) {
//        new UpdateStudent();
//    }
//}
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
    JTextField tfcourse, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelrollno, labelname, labelfname, labeldob, labelx, labelxii, labelaadhar;
    JButton submit, cancel;
    Choice crollno;

    UpdateStudent() {
        setSize(900, 650);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.ITALIC, 35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 100, 200, 20);
        lblrollnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblrollnumber);

        // Dropdown choice for roll numbers
        crollno = new Choice();
        crollno.setBounds(250, 100, 200, 20);
        add(crollno);

        // Populate the Choice dropdown with roll numbers
        try {
            Conn c = new Conn();
            ResultSet rs = c.con.createStatement().executeQuery("select rollno from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll Number:");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("serif", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelrollno);

        JLabel lbldob = new JLabel("DOB:");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 200, 200, 30); // Increased width for better visibility
        labeldob.setFont(new Font("serif", Font.PLAIN, 20)); // Ensure consistent font size
        add(labeldob);


        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        tfaddress.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        tfphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfphone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        tfemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfemail);

        JLabel lblx = new JLabel("Class 10%:");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        labelx = new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        labelx.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelx);

        JLabel lblxii = new JLabel("Class 12%:");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        labelxii = new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        labelxii.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelxii);

        JLabel lblaadhar = new JLabel("Aadhar:");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        JLabel lblcourse = new JLabel("Course:");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 400, 150, 30);
        tfcourse.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfcourse);

        JLabel lblbranch = new JLabel("Branch:");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        tfbranch.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfbranch);

        // Add item listener for Choice component
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='" + crollno.getSelectedItem() + "'";
                    ResultSet rs = c.con.createStatement().executeQuery(query);
                    if (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("rollno"));
                        tfcourse.setText(rs.getString("course"));
                        tfbranch.setText(rs.getString("branch"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250, 500, 120, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String branch = tfbranch.getText();

            try {
                Conn c = new Conn();
                String query = "update student set address=?, phone=?, email=?, course=?, branch=? where rollno=?";
                PreparedStatement pstmt = c.con.prepareStatement(query);

                pstmt.setString(1, address);
                pstmt.setString(2, phone);
                pstmt.setString(3, email);
                pstmt.setString(4, course);
                pstmt.setString(5, branch);
                pstmt.setString(6, rollno);

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Student details updated successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateStudent();
    }
}
