
//package university.management.system;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class Project extends JFrame implements ActionListener {
//    Project() {
//        // Set frame properties
//        setSize(2000, 1080);
//        setLayout(new BorderLayout()); // Ensure the frame uses BorderLayout
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Load and scale the image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(2000, 800, Image.SCALE_DEFAULT); // Adjust scale to fit frame width
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        add(image, BorderLayout.CENTER); // Add the image to the center
//
//        // Create menu bar
//        JMenuBar mb = new JMenuBar();
//        mb.setPreferredSize(new Dimension(2000, 60)); // Set the height of the menu bar
//        mb.setBackground(new Color(70, 130, 180)); // Attractive background color for the menu bar
//
//        // Create menu items with styling
//        //new Information
//        JMenu newInformation = createStyledMenu("New Information");
//        mb.add(newInformation);
//         
//         
//        JMenuItem facultyInfo = new JMenuItem("new Faculty Information");
//        facultyInfo.setBackground(Color.white);
//        newInformation.add(facultyInfo);
//        
//       
//        JMenuItem studentInfo = new JMenuItem("new Student Information");
//        studentInfo.setBackground(Color.white);
//        newInformation.add(studentInfo);
//        
//        
//        //Details
//        JMenu details = createStyledMenu("View Details");
//        mb.add(details);
//         
//         
//        JMenuItem facultydetails = new JMenuItem("View Faculty details");
//        facultydetails.setBackground(Color.white);
//        details.add(facultydetails);
//        
//       
//        JMenuItem studentdetails = new JMenuItem("View Students details");
//        studentdetails.setBackground(Color.white);
//        details.add(studentdetails);
//        
//        
//        //Details
//        JMenu leave = createStyledMenu("Leave Application");
//        mb.add(leave);
//        
//        
//        JMenuItem facultyleave = new JMenuItem("Faculty leave");
//        facultyleave.setBackground(Color.white);
//        leave.add(facultyleave);
//        
//       
//        JMenuItem studentleave = new JMenuItem("Students leave");
//        studentleave.setBackground(Color.white);
//        leave.add(studentleave);
//         
//         
//        
//        //leave details
//        
//        
//        JMenu leaveDetails = createStyledMenu("Leave Application Details");
//        mb.add(leaveDetails );
//        
//        JMenuItem facultyleavedetails = new JMenuItem("Faculty leave details");
//        facultyleavedetails.setBackground(Color.white);
//        leaveDetails.add(facultyleavedetails);
//        
//       
//        JMenuItem studentleavedetails = new JMenuItem("Students leave details");
//        studentleavedetails.setBackground(Color.white);
//        leaveDetails.add(studentleavedetails);
//        
//       //exam
//        JMenu exam = createStyledMenu("Examination");
//        mb.add(exam);
//        
//        JMenuItem examinationdetails= new JMenuItem("Examination Details");
//        facultyleavedetails.setBackground(Color.white);
//        exam.add(examinationdetails);
//        
//       
//        JMenuItem entermarks = new JMenuItem("Enter Marks");
//        entermarks.setBackground(Color.white);
//        exam.add(entermarks);
//        
//        
//        //update
//        
//        JMenu updateInfo= createStyledMenu("Update Details");
//        mb.add(updateInfo);
//        
//        JMenuItem updatefacultyinfo= new JMenuItem("Update faculty information ");
//        updatefacultyinfo.setBackground(Color.white);
//        updateInfo.add(updatefacultyinfo);
//        
//       
//        JMenuItem updatestudentinfo = new JMenuItem("Update Student Information ");
//        updatestudentinfo.setBackground(Color.white);
//        updateInfo.add(updatestudentinfo);
//        
//        
//        //fees
//        JMenu fee= createStyledMenu("Fee Details");
//        mb.add(fee);
//        
//        JMenuItem feestructure= new JMenuItem("Fees Structure");
//        feestructure.setBackground(Color.white);
//        fee.add(feestructure);
//        
//       
//        JMenuItem feeform = new JMenuItem("Fee Form");
//        feeform.setBackground(Color.white);
//        fee.add(feeform);
//        
//        
//        //utility
//        JMenu utility= createStyledMenu("Utility");
//        mb.add(utility);
//        
//        JMenuItem notepad= new JMenuItem("Notepad");
//        notepad.setBackground(Color.white);
//        notepad.addActionListener(this);
//        utility.add(notepad);
//        
//       
//        JMenuItem calc = new JMenuItem("Calculator");
//        calc.setBackground(Color.white);
//        calc.addActionListener(this);
//        utility.add(calc);
//        
//        
//        JMenu exit= createStyledMenu("Exit");
//        mb.add(exit);
//        
//        JMenuItem ex= new JMenuItem("Exit");
//        ex.setBackground(Color.white);
//        ex.addActionListener(this);
//        exit.add(notepad);
//        
//        
//        
//
//        // Add menus to the menu bar
//       
//        
//        // Add the menu bar to the frame
//        setJMenuBar(mb);
//
//        // Set visibility
//        setVisible(true);
//    }
//
//    // Helper method to create styled menus
//    private JMenu createStyledMenu(String text) {
//        JMenu menu = new JMenu(text);
//        menu.setFont(new Font("Arial", Font.BOLD, 20)); // Set bold font with size matching height
//        menu.setForeground(Color.WHITE); // Set text color
//        menu.setOpaque(true);
//        menu.setBackground(new Color(100, 149, 237)); // Button-like background color
//        menu.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Add white border
//        menu.setPreferredSize(new Dimension(200, 60)); // Set individual menu item size
//        return menu;
//    }
//    public void actionPerformed(ActionEvent ae){
//        String msg = ae.getActionCommand();
//        
//    if(msg.equals("Exit")) {
//    setVisible(false);
//    }   else if (msg.equals("Calculator")){
//        try{
//            Runtime.getRuntime().exec("calc.exe");
//        }catch(Exception e){
//        
//    }
//    } 
//    
//    else if (msg.equals("Notepad")){
//        try{
//            Runtime.getRuntime().exec("notepad.exe");
//        }catch(Exception e){
//        
//    }
//    } 
//    
//    
//
//        
//    }
//
//    public static void main(String args[]) {
//        new Project();
//    }
//}

//package university.management.system;
//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class Project extends JFrame implements ActionListener {
//    Project() {
//        // Set frame properties
//        setSize(1920, 1080);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Load and scale the background image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1920, 800, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        add(image, BorderLayout.CENTER);
//
//        // Create menu bar
//        JMenuBar mb = new JMenuBar();
//        mb.setLayout(new GridLayout(1, 0)); // Grid layout ensures even spacing for buttons
//        mb.setBackground(new Color(50, 115, 220)); // Menu bar background color
//
//        // Add menus
//        addMenu(mb, "New Information", new String[]{"New Faculty Information", "New Student Information"});
//        addMenu(mb, "View Details", new String[]{"View Faculty Details", "View Student Details"});
//        addMenu(mb, "Leave Application", new String[]{"Faculty Leave", "Student Leave"});
//        addMenu(mb, "Leave Details", new String[]{"Faculty Leave Details", "Student Leave Details"});
//        addMenu(mb, "Examination", new String[]{"Examination Details", "Enter Marks"});
//        addMenu(mb, "Update Details", new String[]{"Update Faculty Information", "Update Student Information"});
//        addMenu(mb, "Fee Details", new String[]{"Fees Structure", "Fee Form"});
//        addMenu(mb, "Utility", new String[]{"Notepad", "Calculator"});
//        addExitMenu(mb);
//
//        // Add menu bar to frame
//        setJMenuBar(mb);
//
//        // Set visibility
//        setVisible(true);
//    }
//
//    private void addMenu(JMenuBar mb, String menuName, String[] items) {
//        JMenu menu = new JMenu(menuName);
//
//        // Button styling
//        menu.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font size
//        menu.setForeground(Color.WHITE);
//        menu.setBackground(new Color(0, 153, 153));
//        menu.setOpaque(true);
//        menu.setPreferredSize(new Dimension(200, 60)); // Set height for buttons
//        menu.setHorizontalAlignment(SwingConstants.LEFT); // Left-align the text
//        menu.setVerticalAlignment(SwingConstants.CENTER); // Center-align vertically
//        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding for clean appearance
//
//        // Add menu items
//        for (String item : items) {
//            JMenuItem menuItem = new JMenuItem(item);
//            menuItem.setBackground(Color.WHITE);
//            menuItem.setFont(new Font("Arial", Font.PLAIN, 18)); // Dropdown item font size
//            menuItem.addActionListener(this); // Attach action listener
//            menu.add(menuItem);
//        }
//
//        mb.add(menu);
//    }
//
//    private void addExitMenu(JMenuBar mb) {
//        JMenu menu = new JMenu("Exit");
//
//        // Button styling
//        menu.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font size
//        menu.setForeground(Color.WHITE);
//        menu.setBackground(new Color(255, 69, 69));
//        menu.setOpaque(true);
//        menu.setPreferredSize(new Dimension(200, 60)); // Set height for buttons
//        menu.setHorizontalAlignment(SwingConstants.LEFT); // Left-align the text
//        menu.setVerticalAlignment(SwingConstants.CENTER); // Center-align vertically
//        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding for clean appearance
//
//        // Add Exit menu item
//        JMenuItem exitItem = new JMenuItem("Exit");
//        exitItem.setBackground(Color.WHITE);
//        exitItem.setFont(new Font("Arial", Font.PLAIN, 18)); // Dropdown item font size
//        exitItem.addActionListener(this);
//        menu.add(exitItem);
//
//        mb.add(menu);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        String msg = ae.getActionCommand();
//
//        if (msg.equals("Exit")) {
//            setVisible(false);
//        } else if (msg.equals("Calculator")) {
//            try {
//                Runtime.getRuntime().exec("calc.exe");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (msg.equals("Notepad")) {
//            try {
//                Runtime.getRuntime().exec("notepad.exe");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else if (msg.equals("New Faculty Information")) {
//            new AddTeacher(); // Open the AddTeacher form
//        } else if (msg.equals("New Student Information")) {
//            new AddStudent(); // Open the AddStudent form
//        }else if (msg.equals("View Student Information")) {
//            new AddStudent(); // Open the AddStudent form
//        }else if (msg.equals("View Faculty Information")) {
//            new AddTeacher(); // Open the AddStudent form
//        }
//        
//        
//    }
//
//    public static void main(String[] args) {
//        new Project();
//    }
//}
//
package university.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    Project() {
        // Set frame properties
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load and scale the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, BorderLayout.CENTER);

        // Create menu bar
        JMenuBar mb = new JMenuBar();
        mb.setLayout(new GridLayout(1, 0)); // Grid layout ensures even spacing for buttons
        mb.setBackground(new Color(50, 115, 220)); // Menu bar background color

        // Add menus
        addMenu(mb, "New Information", new String[]{"New Faculty Information", "New Student Information"});
        addMenu(mb, "View Details", new String[]{"View Faculty Details", "View Student Details"});
        addMenu(mb, "Apply Leave", new String[]{"Faculty Leave", "Student Leave"});
        addMenu(mb, "Leave Details", new String[]{"Faculty Leave Details", "Student Leave Details"});
        addMenu(mb, "Examination", new String[]{"Examination Details", "Enter Marks"});
        addMenu(mb, "Update Details", new String[]{"Update Faculty Information", "Update Student Information"});
        addMenu(mb, "Fee Details", new String[]{"Fees Structure", "Fee Form"});
        addMenu(mb, "Utility", new String[]{"Notepad", "Calculator"});
        addExitMenu(mb);

        // Add menu bar to frame
        setJMenuBar(mb);

        // Set visibility
        setVisible(true);
    }

    private void addMenu(JMenuBar mb, String menuName, String[] items) {
        JMenu menu = new JMenu(menuName);

        // Button styling
        menu.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font size
        menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(0, 153, 153));
        menu.setOpaque(true);
        menu.setPreferredSize(new Dimension(200, 60)); // Set height for buttons
        menu.setHorizontalAlignment(SwingConstants.LEFT); // Left-align the text
        menu.setVerticalAlignment(SwingConstants.CENTER); // Center-align vertically
        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding for clean appearance

        // Add menu items
        for (String item : items) {
            JMenuItem menuItem = new JMenuItem(item);
            menuItem.setBackground(Color.WHITE);
            menuItem.setFont(new Font("Arial", Font.PLAIN, 18)); // Dropdown item font size
            menuItem.addActionListener(this); // Attach action listener
            menu.add(menuItem);
        }

        mb.add(menu);
    }

    private void addExitMenu(JMenuBar mb) {
        JMenu menu = new JMenu("Exit");

        // Button styling
        menu.setFont(new Font("Arial", Font.BOLD, 20)); // Larger font size
        menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(255, 69, 69));
        menu.setOpaque(true);
        menu.setPreferredSize(new Dimension(200, 60)); // Set height for buttons
        menu.setHorizontalAlignment(SwingConstants.LEFT); // Left-align the text
        menu.setVerticalAlignment(SwingConstants.CENTER); // Center-align vertically
        menu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding for clean appearance

        // Add Exit menu item
        
        
         
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equals("New Faculty Information")) {
            new AddTeacher(); // Open the AddTeacher form
        } else if (msg.equals("New Student Information")) {
            new AddStudent(); // Open the AddStudent form
        } else if (msg.equals("View Faculty Details")) {
            new TeacherDetails(); // Open the TeacherDetails form for viewing faculty details
        } else if (msg.equals("View Student Details")) {
            new StudentDetails(); // Open the StudentDetails form for viewing student details
        } else if (msg.equals("Student Leave")) {
            new StudentLeave(); // Open the StudentLeave form
        } else if (msg.equals("Faculty Leave")) {
            new TeacherLeave(); // Open the TeacherLeave form
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails(); // Open the StudentLeaveDetails form
        } else if (msg.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails(); // Open the TeacherLeaveDetails form
        }else if (msg.equals("Update Faculty Information")) {
            new UpdateTeacher(); // Open the TeacherLeaveDetails form
        }else if (msg.equals("Update Student Information")) {
            new UpdateStudent(); // Open the TeacherLeaveDetails form
        }else if (msg.equals("Fees Structure")) {
            new FeeStructure(); // Open the TeacherLeaveDetails form
        }else if (msg.equals("Enter Marks")) {
            new EnterMarks(); // Open the TeacherLeaveDetails form
        }else if (msg.equals("Examination Details")) {
            new ExaminationDetails(); // Open the TeacherLeaveDetails form
        }
        
    }

    public static void main(String[] args) {
        new Project();
    }
}