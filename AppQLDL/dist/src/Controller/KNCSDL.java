/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class KNCSDL {
     public Connection getConnect() throws SQLException{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            String username = "root";
            String password ="";
            String url = "jdbc:mysql://localhost:3306/quanlydulich";
            return DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(KNCSDL.class.getName()).log(Level.SEVERE, null, ex);
            
        }catch(SQLException ex){
           Logger.getLogger(KNCSDL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
