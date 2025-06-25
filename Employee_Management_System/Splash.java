
package employee.management.system; //address of class splash
import javax.swing.*; //used for GUIS JFrame,JLabel JButton
 import java.awt.*;//color,fonts class is in this package
import java.awt.event.*;// handle events like button click

public class Splash extends JFrame implements ActionListener{ //By extending JFrame, the Splash class inherits all the properties and methods of JFrame, allowing it to create a windowed application.

     Splash(){ //default constructor
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);//desables default layout
         JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
          heading.setBounds(80,30,1200,60);//label from left,top,label lenght nad label width
         heading.setFont(new Font("serif", Font.PLAIN,60) );//font.PLAIN can be italic or bold
         heading.setForeground(Color.red); 
         add(heading); //adds label to the frame
         
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg")); //take image
        Image i2=i1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT); // scales the image to specific dimensions ,this returns object
        ImageIcon i3=new ImageIcon(i2);//hence again converted it into image
        JLabel image=new JLabel(i3);//holds the image
        image.setBounds(50,100,1050,500);//image from left,top,length,width
        add(image);
        
        JButton clickhere=new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400,400,300,70);
        clickhere.setBackground(Color.black); //button bg clor to black
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);// to implement click event
        image.add(clickhere);
        
        
        setSize(1170,650);//length and width of frame
          setLocation(200,50);//distance from left and top
        setVisible(true); //visible on the screen
        
        while(true){
            heading.setVisible(false);//hides the heading llabel
            try{
                Thread.sleep(500);//blinking effects
            }catch(Exception e){
            }
            heading.setVisible(true);//makes heading visible again
            try{
                Thread.sleep(500);
            }catch(Exception e){
            }
    }
     }
     
     public void actionPerformed(ActionEvent ae){
         setVisible(false);//hides the current splash screen
         new Login(); //this will invoke the login class constructor(new obj of login class)
     }
    public static void main(String args[]){
        new Splash(); 
    }
}
