/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rasterbrain.acl.servlets;

import com.rasterbrain.acl.Constants;
import com.rasterbrain.acl.DataBase;
import com.rasterbrain.acl.user.LoginData;
import com.rasterbrain.acl.user.User;
import com.rasterbrain.acl.user.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ezio
 */
public class RegisterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phonenumber = request.getParameter("phonenumber");
        String location = request.getParameter("location");

        DataBase db = new DataBase();
        if (db.createConnection() == null) {
        } else {
            try {
                UserManager man = new UserManager();

                if (man.register(username, password, email,name, address, phonenumber, location)) {
                    if (man.login(username, password)) {
                        LoginData login = new LoginData();
                        login.setUsername(username);
                        request.getSession().setAttribute(Constants.LOGIN_DATA, login);
                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println("success");
                    } else {
                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println("failed");
                    }
                }
                else {
                        response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println("failed");
                    }
            } catch (SQLException ex) {
                       response.setContentType("text/html;charset=UTF-8");
                        PrintWriter out = response.getWriter();
                        out.println("failed");
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
