/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pageform;

import java.awt.HeadlessException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JOptionPane;


/**
 *
 * @author acer
 */
public class koneksi {
    
    public static Connection connectionDb(){
        try{
            String username = "root";
            String pass ="";
            String sqlconn = "jdbc:mysql://localhost:3306/db_mie";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(sqlconn, username, pass);
            System.out.println("Database connected");
            return conn;
            
        } catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "JDBC Driver not found:"+ e.getMessage());
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Database connection error:"+ e.getMessage());
            
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
