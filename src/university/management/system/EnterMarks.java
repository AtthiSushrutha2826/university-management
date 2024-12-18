//
//package university.management.system;
//import java.awt.*;
//import java.sql.*;
//import javax.swing.*;
//import java.awt.event.*;
//public class EnterMarks extends JFrame implements ActionListener{
//    Choice crollno;
//    JComboBox cbsemester;
//    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
//    JButton submit, cancel;
//    EnterMarks(){
//        setSize(1000, 500);
//        setLocation(300, 150);
//        setLayout(null);
//        
//        getContentPane().setBackground(Color.white);
//        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1920, 800, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        add(image, BorderLayout.CENTER);
//        image.setBounds(500, 40, 400, 300);
//        
//        JLabel heading = new JLabel("Enter marks of student");
//        heading.setBounds(50, 10, 500, 50);
//        heading.setFont(new Font("serif", Font.BOLD, 20));
//        add(heading);
//
//        JLabel lblrollnumber = new JLabel("Select Roll Number");
//        lblrollnumber.setBounds(50, 70, 150, 20);
//        add(lblrollnumber);
//
//        // Dropdown choice for roll numbers
//        crollno = new Choice();
//        crollno.setBounds(200, 70, 150, 20);
//        add(crollno);
//
//        // Populate the Choice dropdown with roll numbers
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.con.createStatement().executeQuery("select rollno from student");
//            while (rs.next()) {
//                crollno.add(rs.getString("rollno"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        JLabel lblsemester = new JLabel("Select Semester");
//        lblsemester.setBounds(50, 70, 150, 20);
//        add(lblsemester);
//
//        String semester[] = {"I","II","III","IV","V","VI","VII","VII"};
//        cbsemester =new JComboBox();
//        cbsemester.setBounds(50, 110, 150, 20);
//        cbsemester.setBackground(Color.white);
//        
//        
//        JLabel lblentersubject = new JLabel("Enter Subject");
//        lblentersubject.setBounds(100, 150, 200, 40);
//        add(lblentersubject);
//        
//        JLabel lblentermarks = new JLabel("Enter Marks");
//        lblentermarks.setBounds(320, 150, 200, 40);
//        add(lblentermarks);
//        
//        
//        tfsub1 = new JTextField();
//        tfsub1.setBounds(50, 230, 200, 20);
//        add(tfsub1);
//        
//        tfsub2 = new JTextField();
//        tfsub2.setBounds(50, 260, 200, 20);
//        add(tfsub2);
//        
//        tfsub3 = new JTextField();
//        tfsub3.setBounds(50, 290, 200, 20);
//        add(tfsub3);
//        
//        tfsub4 = new JTextField();
//        tfsub4.setBounds(50, 310, 200, 20);
//        add(tfsub4);
//        
//        tfsub5 = new JTextField();
//        tfsub5.setBounds(50, 340, 200, 20);
//        add(tfsub5);
//        
//        tfmarks1 = new JTextField();
//        tfmarks1.setBounds(250, 200, 200, 20);
//        add(tfmarks1);
//        
//        tfmarks2 = new JTextField();
//        tfmarks2.setBounds(250, 230, 200, 20);
//        add(tfmarks2);
//        
//        tfmarks3 = new JTextField();
//        tfmarks3.setBounds(250, 260, 200, 20);
//        add(tfmarks3);
//
//        tfmarks4 = new JTextField();
//        tfmarks4.setBounds(250, 290, 200, 20);
//        add(tfmarks4);
//
//        tfmarks5 = new JTextField();
//        tfmarks5.setBounds(250, 320, 200, 20);
//        add(tfmarks5);
//        
//        submit = new JButton("Update");
//        submit.setBounds(70, 360, 150, 25);
//        submit.setBackground(Color.BLACK);
//       // submit.addActionListener(this);
//        add(submit);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(280, 360, 150, 25);
//         submit.setBackground(Color.BLACK);
//        //cancel.addActionListener(this);
//        add(cancel);
//
//        
//        setVisible(true);
//    }
//    public void actionPer
//    
//    
//    
//    public static void main(String args[]){
//        new EnterMarks();
//    }
//    
//}
package university.management.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class EnterMarks extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox<String> cbsemester;
    JTextField tfsub1, tfsub2, tfsub3, tfsub4, tfsub5;
    JTextField tfmarks1, tfmarks2, tfmarks3, tfmarks4, tfmarks5;
    JButton submit, cancel;

    EnterMarks() {
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Add background image
        // Load the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));

// Scale the image to fit within the JLabel bounds dynamically
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);

// Add the image to a JLabel
JLabel image = new JLabel(i3);
image.setBounds(500, 50, 400, 300); // Adjust bounds for perfect fitting
add(image);


        // Heading
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        // Roll Number
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50, 70, 150, 20);
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 70, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.con.createStatement().executeQuery("select rollno from student");
            while (rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Semester
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);

        String[] semester = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII"};
        cbsemester = new JComboBox<>(semester);
        cbsemester.setBounds(200, 110, 150, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);

        // Enter Subjects and Marks
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(50, 150, 150, 20);
        add(lblentersubject);

        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(300, 150, 150, 20);
        add(lblentermarks);

        // Subject text fields
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 180, 200, 20);
        add(tfsub1);

        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 210, 200, 20);
        add(tfsub2);

        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 240, 200, 20);
        add(tfsub3);

        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 270, 200, 20);
        add(tfsub4);

        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 300, 200, 20);
        add(tfsub5);

        // Marks text fields
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(300, 180, 200, 20);
        add(tfmarks1);

        tfmarks2 = new JTextField();
        tfmarks2.setBounds(300, 210, 200, 20);
        add(tfmarks2);

        tfmarks3 = new JTextField();
        tfmarks3.setBounds(300, 240, 200, 20);
        add(tfmarks3);

        tfmarks4 = new JTextField();
        tfmarks4.setBounds(300, 270, 200, 20);
        add(tfmarks4);

        tfmarks5 = new JTextField();
        tfmarks5.setBounds(300, 300, 200, 20);
        add(tfmarks5);

        // Buttons
        submit = new JButton("Update");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(280, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String rollno = crollno.getSelectedItem();
        String semester = (String) cbsemester.getSelectedItem();

        // Collect subject and marks data
        String[] subjects = {tfsub1.getText(), tfsub2.getText(), tfsub3.getText(), tfsub4.getText(), tfsub5.getText()};
        String[] marks = {tfmarks1.getText(), tfmarks2.getText(), tfmarks3.getText(), tfmarks4.getText(), tfmarks5.getText()};

        try {
            Conn c = new Conn();

            // Insert subjects into the 'subject' table
            String subjectQuery = "INSERT INTO subject (rollno, semester, subject1, subject2, subject3, subject4, subject5) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psSubject = c.con.prepareStatement(subjectQuery);
            psSubject.setString(1, rollno);
            psSubject.setString(2, semester);
            psSubject.setString(3, subjects[0]);
            psSubject.setString(4, subjects[1]);
            psSubject.setString(5, subjects[2]);
            psSubject.setString(6, subjects[3]);
            psSubject.setString(7, subjects[4]);
            psSubject.executeUpdate();

            // Insert marks into the 'marks' table
            String marksQuery = "INSERT INTO marks (rollno, semester, marks1, marks2, marks3, marks4, marks5) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psMarks = c.con.prepareStatement(marksQuery);
            psMarks.setString(1, rollno);
            psMarks.setString(2, semester);
            psMarks.setString(3, marks[0]);
            psMarks.setString(4, marks[1]);
            psMarks.setString(5, marks[2]);
            psMarks.setString(6, marks[3]);
            psMarks.setString(7, marks[4]);
            psMarks.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marks and Subjects Inserted Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Occurred: " + e.getMessage());
        }
    } else if (ae.getSource() == cancel) {
        setVisible(false);
    }
}

    public static void main(String[] args) {
        new EnterMarks();
    }
}

