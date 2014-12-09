/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasterbrain.acl.user;

import com.rasterbrain.acl.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ezio
 */
public class UserManager {

    public static DataBase db;

    public UserManager() {
        db = new DataBase();
        db.createConnection();
    }

    public boolean isUser(String username) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT username FROM user_info WHERE username = ?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String user_db = rs.getString("username");
                if (username.equals(user_db)) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getUserType(String username) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT user_type FROM user_info WHERE username = ?");
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("user_type");

            }

        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean login(String username, String password) throws SQLException {
        Connection con = db.getConnection();
        PreparedStatement ps = con.prepareStatement("SELECT password FROM user_info WHERE username = ?");
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String password_db = rs.getString("password");
            if (password.equals(password_db)) {
                // login success\

                return true;
            }
        }
        return false;
    }

    public boolean register(String username, String password, String email, String name, String address, String phonenumber, String location) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT into user_info (username,password,email,phone,address,location,name) VALUES(?,?,?,?,?,?,?)");
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phonenumber);
            ps.setString(5, address);
            ps.setString(6, location);
            ps.setString(7, name);
            int rs = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public boolean delete(String userName) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user_info WHERE username = ?");
            ps.setString(1, userName);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;

        }

    }

    public boolean edit(String username, String password, String email, String name, String address, String phonenumber, String location) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE user_info SET password = ?,email=?,phone=?,address=?,location=?,name=? WHERE username = ?");
            ps.setString(1, password);
            ps.setString(2, email);
            ps.setString(3, phonenumber);
            ps.setString(4, address);
            ps.setString(5, location);
            ps.setString(6, name);
            ps.setString(7, username);
            int rs = ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public User getUser(String userName) {
        try {
            Connection con = db.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user_info WHERE username = ?");
            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setLocation(rs.getString("location"));
                user.setName(rs.getString("name"));
                user.setReg_lib(rs.getInt("reg_lib"));
            }

        } catch (SQLException ex) {
            return null;
        }
        return null;
    }

}
