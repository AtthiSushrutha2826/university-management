//package university.management.system;
//
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class Login extends JFrame implements ActionListener {
//    JButton login, cancel;
//    JTextField tfusername,tfpassword;
//    Login() {
//        getContentPane().setBackground(Color.white);
//        setLayout(null);
//
//        JLabel lblusername = new JLabel("Username");
//        lblusername.setBounds(40, 20, 100, 20);
//        add(lblusername);
//
//        tfusername = new JTextField();
//        tfusername.setBounds(150, 20, 150, 20); // Fixed bounds for username field
//        add(tfusername);
//
//        JLabel lblpassword = new JLabel("Password");
//        lblpassword.setBounds(40, 70, 100, 20);
//        add(lblpassword);
//
//        tfpassword = new JPasswordField();
//        tfpassword.setBounds(150, 70, 150, 20); // Fixed bounds for password field
//        add(tfpassword);
//
//        login = new JButton("Login");
//        login.setBounds(40, 140, 120, 30);
//        login.setBackground(Color.BLACK);
//        login.setForeground(Color.white);
//        login.addActionListener(this);
//        login.setFont(new Font("Tohoma", Font.BOLD, 15));
//        add(login);
//
//        cancel = new JButton("Cancel");
//        cancel.setBounds(180, 140, 120, 30);
//        cancel.setBackground(Color.BLACK);
//        cancel.setForeground(Color.white);
//        cancel.addActionListener(this);
//        cancel.setFont(new Font("Tohoma", Font.BOLD, 15));
//        add(cancel);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); // Load image
//        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Scale image to 200x200
//        ImageIcon i3 = new ImageIcon(i2); // Convert scaled image back to ImageIcon
//        JLabel image = new JLabel(i3); // Create a JLabel to hold the image
//        image.setBounds(350, 0, 200, 200);
//        add(image); // Add the image to the JFrame
//
//        setSize(600, 300);
//        setLocation(500, 250);
//        setVisible(true);
//    }
//
//    // Corrected method name
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == login) {
//            System.out.println("Login button clicked!");
//            String username=tfusername.getText();
//            String password=tfpassword.getText();
//            
//            String query="select * from login where username="+username+"and password="+password+"";
//            try{
//               Conn c=new Conn();
//               ResultSet rs=c.s.executeQuery(query);
//               
//               if (rs.next()){
//                   setVisible(false);
//                   new Project();
//               }else{
//                  JOptionPane.showMessageDialog(null, "invaalid username of password");
//                  setVisible(false);
//               }
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//            } else if (ae.getSource() == cancel) {
//            setVisible(false); // Close the frame
//        }
//    }
//
//    public static void main(String[] args) {
//        new Login();
//    }
//}
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, cancel;
    JTextField tfusername, tfpassword;

    Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 20, 100, 20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150, 20, 150, 20); // Fixed bounds for username field
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150, 70, 150, 20); // Fixed bounds for password field
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        login.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180, 140, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tohoma", Font.BOLD, 15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg")); // Load image
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT); // Scale image to 200x200
        ImageIcon i3 = new ImageIcon(i2); // Convert scaled image back to ImageIcon
        JLabel image = new JLabel(i3); // Create a JLabel to hold the image
        image.setBounds(350, 0, 200, 200);
        add(image); // Add the image to the JFrame

        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    // Corrected method name
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            System.out.println("Login button clicked!");
            String username = tfusername.getText();
            String password = tfpassword.getText();

            // Using prepared statement for safe query
            String query = "SELECT * FROM login WHERE username = ? AND password = ?";

            try {
                Conn c = new Conn();  // Initialize connection
                PreparedStatement ps = c.con.prepareStatement(query); // Use correct connection reference
                ps.setString(1, username);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    setVisible(false);
                    new Project(); // Assuming you have a Project class for further actions
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    tfusername.setText(""); // Clear fields after failed login
                    tfpassword.setText(""); 
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false); // Close the frame
        }
    }

    public static void main(String[] args) {
        new Login(); // Run the login form
    }
}
