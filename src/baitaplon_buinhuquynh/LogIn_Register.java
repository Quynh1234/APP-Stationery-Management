/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baitaplon_buinhuquynh;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

/**
 *
 * @author quynh
 */
public class LogIn_Register extends JFrame{
     private static Runnable Main;
    //private static Runnable Student;
    private JButton btnLogIn;
    private JButton addEmployeeBtn;
    private JButton deleteEmployeeBtn;
    private JButton editEmployeeBtn;
    

    private JLabel IDLabel;
    private JLabel nameLabel;
   

    private JTextField IDField;
    private JTextField nameField;
    
   
    public LogIn_Register() {
        initComponents();
    }

    private void add(JPanel panel) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        addEmployeeBtn = new JButton("Add");
        editEmployeeBtn = new JButton("Edit");
        deleteEmployeeBtn = new JButton("Delete");
        

    

        IDLabel = new JLabel("ID");
        nameLabel = new JLabel("Name");
      

        IDField = new JTextField(6);
        nameField = new JTextField(15);
       

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        

        panel.add(addEmployeeBtn);
        panel.add(editEmployeeBtn);
        panel.add(deleteEmployeeBtn);
       

        panel.add(IDLabel);
        panel.add(nameLabel);
       
        panel.add(IDField);
        panel.add(nameField);
      

        layout.putConstraint(SpringLayout.WEST, IDLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, IDLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
       

        layout.putConstraint(SpringLayout.WEST, IDField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, IDField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
      

        layout.putConstraint(SpringLayout.WEST, addEmployeeBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addEmployeeBtn, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editEmployeeBtn, 60, SpringLayout.WEST, addEmployeeBtn);
        layout.putConstraint(SpringLayout.NORTH, editEmployeeBtn, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteEmployeeBtn, 60, SpringLayout.WEST, editEmployeeBtn);
       
        layout.putConstraint(SpringLayout.NORTH, deleteEmployeeBtn, 270, SpringLayout.NORTH, panel);
        
      

    
        add(panel);
        setTitle("Student Information");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
         Main m = new Main();
}

 
    
    
}
