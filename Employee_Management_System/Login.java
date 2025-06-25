package employee.management.system;

import javax.swing.*;//jframe,jlabel GUI
import java.awt.*;//fonts and colors
import java.awt.event.*;
import java.sql.*;//accesing ang processing data stored in database using java database connectivity JDBC API .includes classes like statement,ResultSet and Drivermanager

public class Login extends JFrame implements ActionListener{ //The class implements the ActionListener interface, which requires the class to define the actionPerformed method to handle action events (like button clicks).
    
    JTextField tfusername, tfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username"); //creates label and label is added to the frame.
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);
        
        tfusername = new JTextField();//Creates a text field for the user to enter their username and sets its position and size.
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");//creates label
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);//this calls the actionPerformed method when button is clicked
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();//Retrieves the text entered in the tfusername text field and stores it in the username variable.
            String password = tfpassword.getText();
            
            Conn c = new Conn();// Creates a new instance of the Conn class, which establishes a connection to the database.
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
    //Constructs a SQL query to select all records from the login table where the username and password match the values entered by the user.    
            ResultSet rs = c.s.executeQuery(query);//The result of the query is stored in a ResultSet object (rs), which contains the data returned by the query.
            if (rs.next()) { //moves to next row in query
                setVisible(false);
                new Home(); //if username and password are correct then open home page
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
} 