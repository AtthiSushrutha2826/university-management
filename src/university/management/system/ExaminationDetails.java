//
//package university.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.sql.*;
//import net.proteanit.sql.DbUtils;
//import java.awt.event.*;
//
//public class ExaminationDetails extends JFrame implements ActionListener {
//    JTextField search;
//    JButton submit, cancel;
//    JTable table;
//
//    ExaminationDetails() {
//        setSize(1000, 475);
//        setLocation(300, 100);
//        setLayout(null);
//        getContentPane().setBackground(Color.WHITE);
//        
//
//        JLabel heading = new JLabel("Check Result");
//        heading.setBounds(80, 15, 400, 50);
//        heading.setFont(new Font("serif", Font.BOLD, 20));
//        add(heading);
//
//        search = new JTextField();
//        search.setBounds(80, 90, 200, 30);
//        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
//        add(search);
//
//        submit = new JButton("check result");
//        submit.setBounds(300, 90, 120, 30);
//        submit.setBackground(Color.BLACK);
//        submit.setForeground(Color.WHITE);
//        submit.addActionListener(this);
//        add(submit);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(440, 90, 120, 30);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.WHITE);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        table = new JTable();
//        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
//
//        JScrollPane jsp = new JScrollPane(table);
//        jsp.setBounds(0, 130, 1000, 310);
//        add(jsp);
//
//        try {
//            Conn c = new Conn();
//            ResultSet rs = c.con.createStatement().executeQuery("select * from student");
//            table.setModel(DbUtils.resultSetToTableModel(rs));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Add Mouse Listener to the table to populate the search field
//        table.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent me) {
//                int row = table.getSelectedRow();
//                if (row != -1) {
//                    search.setText(table.getModel().getValueAt(row, 2).toString());
//                }
//            }
//        });
//
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == submit) {
//            setVisible(false); // Close current frame
//            new Marks(search.getText()); // Redirect to Marks
//        } else if (ae.getSource() == cancel) {
//            setVisible(false); // Close current frame
//        }
//    }
//
//    public static void main(String[] args) {
//        new ExaminationDetails();
//    }
//}
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField search;
    JButton submit, cancel;
    JTable table;

    ExaminationDetails() {
        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("serif", Font.BOLD, 20));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

        submit = new JButton("Check Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);

        // Fetch and display students in the table
        try {
            Conn c = new Conn();
            ResultSet rs = c.con.createStatement().executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Populate search field when a row is clicked
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    search.setText(table.getModel().getValueAt(row, 2).toString()); // Assuming column 2 has roll number
                }
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = search.getText();
            if (!rollno.isEmpty()) {
                setVisible(false);
                new Marks(rollno); // Open Marks page with the selected roll number
            } else {
                JOptionPane.showMessageDialog(null, "Please select or enter a Roll Number");
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
