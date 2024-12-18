//package university.management.system;
//
//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;
//import java.awt.event.*;
//
//public class TeacherLeaveDetails extends JFrame implements ActionListener {
//    Choice cempId;
//    JTable table;
//    JButton search, print, cancel;
//
//    TeacherLeaveDetails() {
//        // Setting the background and layout
//        getContentPane().setBackground(Color.white);
//        setLayout(null);
//
//        // Heading label
//        JLabel heading = new JLabel("Search by Employee ID");
//        heading.setBounds(20, 20, 180, 20);
//        add(heading);
//
//        // Dropdown choice for employee IDs
//        cempId = new Choice();
//        cempId.setBounds(200, 20, 150, 20);
//        add(cempId);
//
//        // Populate the Choice dropdown with employee IDs
//        try {
//            Conn c = new Conn();
//            Statement stmt = c.con.createStatement();
//            ResultSet rs = stmt.executeQuery("select empId from teacher");
//            while (rs.next()) {
//                cempId.add(rs.getString("empId"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // JTable to display teacher leave details
//        table = new JTable();
//
//        // Populate the JTable with leave data
//        try {
//            Conn c = new Conn();
//            Statement stmt = c.con.createStatement();
//            ResultSet rs = stmt.executeQuery("select * from teacherleave");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Add JScrollPane to the JFrame for the JTable
//        JScrollPane jsp = new JScrollPane(table);
//        jsp.setBounds(0, 100, 900, 600);
//        add(jsp);
//
//        // Buttons
//        search = new JButton("Search");
//        search.setBounds(20, 70, 80, 20);
//        search.addActionListener(this);
//        add(search);
//
//        print = new JButton("Print");
//        print.setBounds(120, 70, 80, 20);
//        print.addActionListener(this);
//        add(print);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(220, 70, 80, 20);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        // JFrame properties
//        setSize(900, 700);
//        setLocation(300, 100);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == search) {
//            // Fetch data based on selected employee ID
//            String query = "select * from teacherleave where empId='" + cempId.getSelectedItem() + "'";
//            try {
//                Conn c = new Conn();
//                Statement stmt = c.con.createStatement();
//                ResultSet rs = stmt.executeQuery(query);
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == print) {
//            // Print table content
//            try {
//                table.print();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == cancel) {
//            // Close the window
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new TeacherLeaveDetails();
//    }
//}
//
package university.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class TeacherLeave extends JFrame {
    Choice cEmpId, ctime;
    JDateChooser dcdate;

    TeacherLeave() {
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
        JLabel lblrollno = new JLabel("Search by Employee ID");
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblrollno.setBounds(60, 100, 200, 20);
        add(lblrollno);

        cEmpId = new Choice();
        cEmpId.setBounds(60, 130, 200, 20);
        add(cEmpId);

        // Populate roll numbers
        try {
            Conn c = new Conn();
            Statement stmt = c.con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
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
        String rollno = cEmpId.getSelectedItem();
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
            String query = "INSERT INTO teacherleave (empId, date, duration) VALUES (?, ?, ?)";
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
        new TeacherLeave();
    }
}
