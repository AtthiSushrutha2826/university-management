package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentFeeForm extends JFrame implements ActionListener {
    JComboBox<String> rollNoCombo;
    JTextField nameField, fatherNameField, totalPayableField;
    JComboBox<String> courseField, branchField, semesterField;
    JButton updateButton, payFeeButton, backButton;

    StudentFeeForm() {
        // Frame setup
        setSize(900, 500);
        setLocation(300, 150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel title = new JLabel("Student Fee Form");
        title.setFont(new Font("serif", Font.BOLD, 30));
        title.setBounds(350, 10, 300, 50);
        add(title);

        // Select Roll No
        JLabel rollLabel = new JLabel("Select Roll No");
        rollLabel.setBounds(50, 80, 120, 25);
        add(rollLabel);

        rollNoCombo = new JComboBox<>();
        rollNoCombo.setBounds(180, 80, 150, 25);
        add(rollNoCombo);
        rollNoCombo.addActionListener(this);
        
        // Name
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 120, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(180, 120, 150, 25);
        nameField.setEditable(false);
        add(nameField);

        // Father's Name
        JLabel fatherLabel = new JLabel("Father's Name");
        fatherLabel.setBounds(50, 160, 120, 25);
        add(fatherLabel);

        fatherNameField = new JTextField();
        fatherNameField.setBounds(180, 160, 150, 25);
        fatherNameField.setEditable(false);
        add(fatherNameField);

        // Course
        JLabel courseLabel = new JLabel("Course");
        courseLabel.setBounds(50, 200, 120, 25);
        add(courseLabel);

        courseField = new JComboBox<>(new String[]{"BTech", "MTech", "MBA", "BBA"});
        courseField.setBounds(180, 200, 150, 25);
        add(courseField);

        // Branch
        JLabel branchLabel = new JLabel("Branch");
        branchLabel.setBounds(50, 240, 120, 25);
        add(branchLabel);

        branchField = new JComboBox<>(new String[]{"Mechanical", "CSE", "Electrical", "Civil"});
        branchField.setBounds(180, 240, 150, 25);
        add(branchField);

        // Semester
        JLabel semesterLabel = new JLabel("Semester");
        semesterLabel.setBounds(50, 280, 120, 25);
        add(semesterLabel);

        semesterField = new JComboBox<>(new String[]{"Semester1", "Semester2", "Semester3", "Semester4"});
        semesterField.setBounds(180, 280, 150, 25);
        add(semesterField);

        // Total Payable
        JLabel totalLabel = new JLabel("Total Payable");
        totalLabel.setBounds(50, 320, 120, 25);
        add(totalLabel);

        totalPayableField = new JTextField();
        totalPayableField.setBounds(180, 320, 150, 25);
        totalPayableField.setEditable(false);
        add(totalPayableField);

        // Buttons
        updateButton = new JButton("Update");
        updateButton.setBounds(50, 370, 100, 30);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(this);
        add(updateButton);

        payFeeButton = new JButton("Pay Fee");
        payFeeButton.setBounds(170, 370, 100, 30);
        payFeeButton.setBackground(Color.BLACK);
        payFeeButton.setForeground(Color.WHITE);
        payFeeButton.addActionListener(this);
        add(payFeeButton);

        backButton = new JButton("Back");
        backButton.setBounds(290, 370, 100, 30);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 100, 350, 250);
        add(image);

        // Load roll numbers into the dropdown
        try {
            Conn c = new Conn();
            ResultSet rs = c.con.createStatement().executeQuery("select rollno from student");
            while (rs.next()) {
                rollNoCombo.addItem(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == rollNoCombo) {
            String rollno = (String) rollNoCombo.getSelectedItem();
            try {
                Conn c = new Conn();
                ResultSet rs = c.con.createStatement().executeQuery("select * from student where rollno = '" + rollno + "'");
                if (rs.next()) {
                    nameField.setText(rs.getString("name"));
                    fatherNameField.setText(rs.getString("fname"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == updateButton) {
    try {
        Conn c = new Conn();
        String course = (String) courseField.getSelectedItem();
        String branch = (String) branchField.getSelectedItem();
        String semester = (String) semesterField.getSelectedItem();

        // Convert semester name to match the column name in the table
        String semesterColumn = semester.toLowerCase();

        String query = "select " + semesterColumn + " as fee from fee where course='" + course + "'";
        ResultSet rs = c.con.createStatement().executeQuery(query);

        if (rs.next()) {
            totalPayableField.setText(rs.getString("fee"));
            JOptionPane.showMessageDialog(null, "Details Updated Successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Fee details not found");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching fee details");
    }
}

         else if (ae.getSource() == payFeeButton) {
            JOptionPane.showMessageDialog(null, "Fee Paid Successfully");
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentFeeForm();
    }
}