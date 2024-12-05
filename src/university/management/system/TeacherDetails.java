package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    Choice cEmpid;
    JTable table;
    JButton search, print, update, add, cancel;

    TeacherDetails() {
        // Setting the background and layout
        getContentPane().setBackground(Color.white);
        setLayout(null);

        // Heading label
        JLabel heading = new JLabel("Search by employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        // Dropdown choice for roll numbers
        cEmpid = new Choice();
        cEmpid.setBounds(180, 20, 150, 20);
        add(cEmpid);

        // Populate the Choice dropdown with roll numbers
        try {
            Conn c = new Conn();
            Statement stmt = c.con.createStatement(); // Create a statement
            ResultSet rs = stmt.executeQuery("select empId from teacher");
            while (rs.next()) {
                cEmpid.add(rs.getString("empId"));
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
            ResultSet rs = stmt.executeQuery("select * from teacher");
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
        
         add = new JButton("add");
        add.setBounds(220,70,80, 20);
        add.addActionListener(this);
        add(add);
        
         update = new JButton("update");
        update.setBounds(320,70,80, 20);
        update.addActionListener(this);
        add(update);
        
        
         cancel = new JButton("cancel");
        cancel.setBounds(420,70,80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        

        // JFrame properties
        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource()== search){
           String query = "select * from teacher where empId='" + cEmpid.getSelectedItem() + "'";
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
            else if (ae.getSource() == add){
                 setVisible(false);
                 new AddTeacher();
            
        }
        
            else if (ae.getSource() == update){
                 setVisible(false);
                // new UpdateTeacher();
            
        }
            else{
                setVisible(false);
            }
        
    }

    public static void main(String[] args) {
        new TeacherDetails();
    }
}
