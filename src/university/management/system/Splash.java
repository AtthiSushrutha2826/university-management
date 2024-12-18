package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable { // Class for splash screen with animation and threading
    Thread t; // Thread for managing timed tasks

    Splash() {
        // Load and scale the image for the splash screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg")); // Load image
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT); // Scale image to 1000x700
        ImageIcon i3 = new ImageIcon(i2); // Convert scaled image back to ImageIcon
        JLabel image = new JLabel(i3); // Create a JLabel to hold the image
        add(image); // Add the image to the JFrame

        t = new Thread(this); // Initialize the thread
        t.start(); // Start the thread for handling splash screen timing

        setVisible(true); // Make the JFrame visible

        int x = 1; // Initialize a variable for animation
        for (int i = 0; i <= 500; i += 4, x += 1) { // Animation loop to resize the JFrame
            setLocation(600 - ((i + x) / 2), 350 - (i / 2)); // Dynamically adjust JFrame position
            setSize(i + 3 * x, i + x / 2); // Dynamically adjust JFrame size
            try {
                Thread.sleep(10); // Pause to create smooth animation effect
            } catch (Exception e) {
                e.printStackTrace(); // Handle exception if animation fails
            }
        }
        setSize(1000, 700); // Set final size of the JFrame
        setLocation(250, 50); // Set final position of the JFrame
    }

    public void run() {
        try {
            Thread.sleep(2000); // Keep the splash screen visible for 7 seconds smooth transition slowly 
            setVisible(false); // Hide the JFrame after the delay
            
            
            new Login();
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception if thread sleep fails
        }
    }

    public static void main(String[] args) {
        new Splash(); // Create and show the splash screen
    }
}
