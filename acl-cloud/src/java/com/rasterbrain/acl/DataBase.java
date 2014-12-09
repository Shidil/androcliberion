/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rasterbrain.acl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ezio
 */
public class DataBase {
    Connection con;
    public Connection createConnection() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        // open a 
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/androcliberion","root","");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }

    public Connection getConnection() {
            if(con==null){
                createConnection();
            }
           return con;
    }
}