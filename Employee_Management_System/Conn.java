package employee.management.system;

import java.sql.*;//accesing ang processing data stored in database using java database connectivity JDBC API .includes classes like statement,ResultSet and Drivermanager

public class Conn {//class is intended to handle database connection
    
    Connection c;//variable hods the connection to database
    Statement s;//This variable will hold a Statement object, which is used to execute SQL queries against the database.

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//This line loads the MySQL JDBC driver class.
            c = DriverManager.getConnection("jdbc:mysql:///employeelist", "root", "samiksha"); // This line establishes a connection to the MySQL database.
            s = c.createStatement(); //The Statement object is used to execute SQL queries against the database.
        } catch (Exception e) {
            e.printStackTrace();//The primary purpose of printStackTrace() is to provide a detailed report of the exception
        }
    }
}


