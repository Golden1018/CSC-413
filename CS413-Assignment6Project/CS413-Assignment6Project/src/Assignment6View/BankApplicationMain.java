/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.LayoutManager;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

/**
 *
 * @author karunmehta
 */

public class BankApplicationMain extends JFrame implements ActionListener {
	
    private JMenuBar menuBar = new JMenuBar();
    private JPanel mainPanel = new JPanel();

    public BankApplicationMain() throws IOException {
        //Create the basic frame
        
        //this.initComponents();
        //Set main display paramaeters for pane
        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setResizable(true);
        //getContentPane().setSize(400, 400);
        setTitle("My Banking Application ");
        //setPreferredSize(new Dimension(1200, 800));
        
        //Define the window label
        JLabel windowHeading = new JLabel("My Banking Application");
        windowHeading.setBounds(80, 50, 1200, 60);
        windowHeading.setFont(new Font("Calibri", Font.BOLD, 60));
        windowHeading.setForeground(Color.LIGHT_GRAY);
        add(windowHeading);
        
        
        //create icon you want on the frame
        ImageIcon iIcon = new ImageIcon(ClassLoader.getSystemResource("icons/bankapplicationlandingpage.jpg"));
        Image anImage = iIcon.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon iIcon2 = new ImageIcon(anImage);
        JLabel theLabel = new JLabel(iIcon2);
        theLabel.setBounds(50, 130, 1000,600);
        add(theLabel); 
        
        //add a new button to get to login pane
        JButton openAppButton = new javax.swing.JButton("Start Application");
        openAppButton.setBounds(400, 550, 200, 50);
        openAppButton.addActionListener(this);
        theLabel.add(openAppButton);

        
        setSize(1200, 800);
        this.setLocationRelativeTo(null); 
        setVisible(true);
   
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //Action that will be invoked when button on the frame is clicked

        new UserLogin().setVisible(true);
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        
        try {
            new BankApplicationMain();
        } catch(IOException ioe) {
            System.out.println("Exception caught openin landing page.. " + ioe.getMessage());
        }
    }
    
}

