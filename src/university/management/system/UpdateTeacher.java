package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField tfaddress, tfphone, tfemail, tfcourse, tfbranch;
    JLabel labelEmpId, labelname, labelfname, labeldob, labelx, labelxii, labelaadhar;
    JButton submit, cancel;
    Choice cEmpId;

    UpdateTeacher() {
        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.ITALIC, 35));
        add(heading);

        JLabel lblEmpId = new JLabel("Select Employee ID:");
        lblEmpId.setBounds(50, 80, 200, 20);
        lblEmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblEmpId);

        cEmpId = new Choice();
        cEmpId.setBounds(250, 80, 200, 20);
        add(cEmpId);

        try {
            Conn c = new Conn();
            ResultSet rs = c.con.createStatement().executeQuery("SELECT empId FROM teacher");
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name:");
        lblname.setBounds(50, 130, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(200, 130, 200, 30);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name:");
        lblfname.setBounds(400, 130, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600, 130, 200, 30);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblEmpIdDisplay = new JLabel("Employee ID:");
        lblEmpIdDisplay.setBounds(50, 180, 200, 30);
        lblEmpIdDisplay.setFont(new Font("serif", Font.BOLD, 20));
        add(lblEmpIdDisplay);

        labelEmpId = new JLabel();
        labelEmpId.setBounds(200, 180, 200, 30);
        labelEmpId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelEmpId);

        JLabel lbldob = new JLabel("DOB:");
        lbldob.setBounds(400, 180, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);

        labeldob = new JLabel();
        labeldob.setBounds(600, 180, 200, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address:");
        lbladdress.setBounds(50, 230, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 230, 200, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone:");
        lblphone.setBounds(400, 230, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 230, 200, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email:");
        lblemail.setBounds(50, 280, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 280, 200, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X Marks:");
        lblx.setBounds(400, 280, 200, 30);
        lblx.setFont(new Font("serif", Font.BOLD, 20));
        add(lblx);

        labelx = new JLabel();
        labelx.setBounds(600, 280, 200, 30);
        labelx.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelx);

        JLabel lblxii = new JLabel("Class XII Marks:");
        lblxii.setBounds(50, 330, 200, 30);
        lblxii.setFont(new Font("serif", Font.BOLD, 20));
        add(lblxii);

        labelxii = new JLabel();
        labelxii.setBounds(200, 330, 200, 30);
        labelxii.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelxii);

        JLabel lblaadhar = new JLabel("Aadhar No:");
        lblaadhar.setBounds(400, 330, 200, 30);
        lblaadhar.setFont(new Font("serif", Font.BOLD, 20));
        add(lblaadhar);

        labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 330, 200, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        JLabel lblcourse = new JLabel("Education:");
        lblcourse.setBounds(50, 380, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(200, 380, 200, 30);
        add(tfcourse);

        JLabel lblbranch = new JLabel("Department:");
        lblbranch.setBounds(400, 380, 200, 30);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 380, 200, 30);
        add(tfbranch);

        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "SELECT * FROM teacher WHERE empId = ?";
                    PreparedStatement pstmt = c.con.prepareStatement(query);
                    pstmt.setString(1, cEmpId.getSelectedItem());
                    ResultSet rs = pstmt.executeQuery();

                    if (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labelEmpId.setText(rs.getString("empId"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(String.valueOf(rs.getFloat("class_x")));
                        labelxii.setText(String.valueOf(rs.getFloat("class_xii")));
                        labelaadhar.setText(rs.getString("aadhar"));
                        tfcourse.setText(rs.getString("education"));
                        tfbranch.setText(rs.getString("department"));
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
            String empId = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfcourse.getText();
            String department = tfbranch.getText();

            try {
                Conn c = new Conn();
                String query = "UPDATE teacher SET address=?, phone=?, email=?, education=?, department=? WHERE empId=?";
                PreparedStatement pstmt = c.con.prepareStatement(query);

                pstmt.setString(1, address);
                pstmt.setString(2, phone);
                pstmt.setString(3, email);
                pstmt.setString(4, education);
                pstmt.setString(5, department);
                pstmt.setString(6, empId);

                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Teacher details updated successfully.");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}


//package university.management.system;
//
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import javax.swing.*;
//
//public class UpdateTeacher extends JFrame implements ActionListener {
//
//    Choice empIdChoice;
//    JTextField nameField, fnameField, dobField, addressField, phoneField, emailField, educationField, departmentField;
//    JButton updateButton, cancelButton;
//
//    UpdateTeacher() {
//        setSize(800, 600);
//        setLocation(300, 100);
//        setLayout(null);
//
//        JLabel heading = new JLabel("Update Teacher Details");
//        heading.setBounds(50, 20, 400, 40);
//        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
//        add(heading);
//
//        JLabel empIdLabel = new JLabel("Select Employee ID:");
//        empIdLabel.setBounds(50, 80, 200, 30);
//        add(empIdLabel);
//
//        empIdChoice = new Choice();
//        empIdChoice.setBounds(250, 80, 200, 30);
//        add(empIdChoice);
//
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.con.createStatement().executeQuery("SELECT empid FROM teacher");
//            while (rs.next()) {
//                empIdChoice.add(rs.getString("empid"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        empIdChoice.addItemListener(new ItemListener() {
//            public void itemStateChanged(ItemEvent ie) {
//                fetchTeacherDetails(empIdChoice.getSelectedItem());
//            }
//        });
//
//        JLabel nameLabel = new JLabel("Name:");
//        nameLabel.setBounds(50, 130, 100, 30);
//        add(nameLabel);
//
//        nameField = new JTextField();
//        nameField.setBounds(150, 130, 200, 30);
//        add(nameField);
//
//        JLabel fnameLabel = new JLabel("Father's Name:");
//        fnameLabel.setBounds(400, 130, 100, 30);
//        add(fnameLabel);
//
//        fnameField = new JTextField();
//        fnameField.setBounds(520, 130, 200, 30);
//        add(fnameField);
//
//        JLabel dobLabel = new JLabel("DOB:");
//        dobLabel.setBounds(50, 180, 100, 30);
//        add(dobLabel);
//
//        dobField = new JTextField();
//        dobField.setBounds(150, 180, 200, 30);
//        add(dobField);
//
//        JLabel addressLabel = new JLabel("Address:");
//        addressLabel.setBounds(400, 180, 100, 30);
//        add(addressLabel);
//
//        addressField = new JTextField();
//        addressField.setBounds(520, 180, 200, 30);
//        add(addressField);
//
//        JLabel phoneLabel = new JLabel("Phone:");
//        phoneLabel.setBounds(50, 230, 100, 30);
//        add(phoneLabel);
//
//        phoneField = new JTextField();
//        phoneField.setBounds(150, 230, 200, 30);
//        add(phoneField);
//
//        JLabel emailLabel = new JLabel("Email:");
//        emailLabel.setBounds(400, 230, 100, 30);
//        add(emailLabel);
//
//        emailField = new JTextField();
//        emailField.setBounds(520, 230, 200, 30);
//        add(emailField);
//
//        JLabel educationLabel = new JLabel("Education:");
//        educationLabel.setBounds(50, 280, 100, 30);
//        add(educationLabel);
//
//        educationField = new JTextField();
//        educationField.setBounds(150, 280, 200, 30);
//        add(educationField);
//
//        JLabel departmentLabel = new JLabel("Department:");
//        departmentLabel.setBounds(400, 280, 100, 30);
//        add(departmentLabel);
//
//        departmentField = new JTextField();
//        departmentField.setBounds(520, 280, 200, 30);
//        add(departmentField);
//
//        updateButton = new JButton("Update");
//        updateButton.setBounds(250, 400, 100, 30);
//        updateButton.addActionListener(this);
//        add(updateButton);
//
//        cancelButton = new JButton("Cancel");
//        cancelButton.setBounds(400, 400, 100, 30);
//        cancelButton.addActionListener(this);
//        add(cancelButton);
//
//        fetchTeacherDetails(empIdChoice.getSelectedItem());
//
//        setVisible(true);
//    }
//
//    public void fetchTeacherDetails(String empId) {
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM teacher WHERE empid = ?";
//            PreparedStatement ps = c.con.prepareStatement(query);
//            ps.setString(1, empId);
//
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                nameField.setText(rs.getString("name"));
//                fnameField.setText(rs.getString("fname"));
//                dobField.setText(rs.getString("dob"));
//                addressField.setText(rs.getString("address"));
//                phoneField.setText(rs.getString("phone"));
//                emailField.setText(rs.getString("email"));
//                educationField.setText(rs.getString("education"));
//                departmentField.setText(rs.getString("department"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == updateButton) {
//            String empId = empIdChoice.getSelectedItem();
//            String name = nameField.getText();
//            String fname = fnameField.getText();
//            String dob = dobField.getText();
//            String address = addressField.getText();
//            String phone = phoneField.getText();
//            String email = emailField.getText();
//            String education = educationField.getText();
//            String department = departmentField.getText();
//
//            try {
//                Conn c = new Conn();
//                String query = "UPDATE teacher SET name = ?, fname = ?, dob = ?, address = ?, phone = ?, email = ?, education = ?, department = ? WHERE empid = ?";
//                PreparedStatement ps = c.con.prepareStatement(query);
//                ps.setString(1, name);
//                ps.setString(2, fname);
//                ps.setString(3, dob);
//                ps.setString(4, address);
//                ps.setString(5, phone);
//                ps.setString(6, email);
//                ps.setString(7, education);
//                ps.setString(8, department);
//                ps.setString(9, empId);
//
//                ps.executeUpdate();
//                JOptionPane.showMessageDialog(null, "Teacher details updated successfully.");
//                setVisible(false);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (ae.getSource() == cancelButton) {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new UpdateTeacher();
//    }
//}
