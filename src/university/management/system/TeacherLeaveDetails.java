
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
    Choice cempid;
    JTable table;
    JButton search, print, cancel;

    TeacherLeaveDetails() {
        // Setting the background and layout
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Heading label
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        // Dropdown choice for roll numbers
        cempid = new Choice();
        cempid.setBounds(180, 20, 150, 20);
        add(cempid);

        // Populate the Choice dropdown with roll numbers
        try {
            Conn c = new Conn();
            Statement stmt = c.con.createStatement(); // Create a statement
            ResultSet rs = stmt.executeQuery("select empid from teacher");
            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // JTable to display student details
        table = new JTable();

        // Populate the JTable with student data
        try {
            Conn c = new Conn();
            Statement stmt = c.con.createStatement(); // Create a statement
            ResultSet rs = stmt.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add JScrollPane to the JFrame for the JTable
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);
        
        search = new JButton("search");
        search.setBounds(20,70,80, 20);
        search.addActionListener(this);
        add(search);
        
         print = new JButton("print");
        print.setBounds(120,70,80, 20);
        print.addActionListener(this);
        add(print);
        
        cancel = new JButton("cancel");
        cancel.setBounds(220,70,80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        

        // JFrame properties
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()== search){
            String query = "select * from teacherleave where empid='"+cempid.getSelectedItem()+"'";
            try{
               Conn c = new Conn();
               Statement stmt = c.con.createStatement(); // Create a statement
               ResultSet rs = stmt.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
                 
            }catch (Exception e){
               e.printStackTrace();
            }
            
        }else if (ae.getSource() == print){
            try {
                table.print();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
            
            else{
                setVisible(false);
            }
        
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}

