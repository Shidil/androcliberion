/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasterbrain.acl.services;

import com.rasterbrain.acl.Constants;
import com.rasterbrain.acl.DataBase;
import com.rasterbrain.acl.servlets.LoginServlet;
import com.rasterbrain.acl.user.LoginData;
import com.rasterbrain.acl.user.UserManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ezio
 */
@WebService(serviceName = "UserService")
public class UserService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {

        try {
            UserManager man = new UserManager();
            if (man.login(username, password)) {
                /*LoginData login = new LoginData();
                 login.setUsername(username);
                 login.setUserType(man.getUserType(username));*/
                    //request.getSession().setAttribute(Constants.LOGIN_DATA, login);
                //response.sendRedirect("admin_books.html");
                return "true";
            } else {
                return "false";
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "false";
    }
}
