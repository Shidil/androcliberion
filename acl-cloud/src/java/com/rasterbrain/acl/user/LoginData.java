/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rasterbrain.acl.user;

import java.util.Date;

/**
 *
 * @author ezio
 */
public class LoginData {
    
    private String username;
    private java.util.Date date;
    private String userType;

    public LoginData() {
        date = new Date();
    }  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

  
    
    
}
