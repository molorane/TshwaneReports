/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tshwanereports;

/**
 *
 * @author hlalefang
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class javaconnect {
    public Connection connection=null;
    public  static Connection getConnection()
    {
        System.out.println("------Mysql Connection Testing-----");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            System.out.println("Where is mysql Driver");
            e.printStackTrace();
            
        }
        System.out.println("mysql Driver registered");
        Connection connection = null;
        
        
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/student_portal","root","");
        }
        catch(SQLException e)
        {
                    JOptionPane.showConfirmDialog(null, "Database error");
                    e.printStackTrace();
        }
        if(connection!=null)
        {
            System.out.println("Connected");
        }
        else
        {
            System.out.println("failed to connect");
        }
        return connection;
        
        
    }
}

