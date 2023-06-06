/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import javax.swing.JOptionPane;

public class Connector {
    String DBurl = "jdbc:mysql://localhost:3306/almaul";
    String DBuser = "root";
    String DBpw = "";
    
    public Statement stmt;
    public Connection connection;
    
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = (Connection) DriverManager.getConnection(DBurl, DBuser, DBpw);
            System.out.println("Berhasil");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
