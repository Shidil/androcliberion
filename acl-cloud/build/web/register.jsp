<%-- 
    Document   : register
    Created on : 1 Dec, 2014, 11:39:27 PM
    Author     : ezio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css">
            input{
                display: 
                    block;
                margin:5px;
            }
        </style>
    </head>
    <body>
        <form method ="POST" action="RegisterServlet" >
            <input type="text" name="username" placeholder="username"/>
            <input type="password" name ="password" placeholder="password" />
            <input type="password" name ="confirm_password" placeholder="confirm password" />
            <input type="email" name="email" placeholder="valid email address"/>
            <input type="text" name="name" placeholder="Full name" />
            <input type="phone" name="phonenumber" placeholder="valid phone number"/>
            <input type="location" name="location" placeholder="location"/>
            <textarea name="address" placeholder="Address">
                
            </textarea>
            <input type="submit" value="Register" />
        </form>
    </body>
</html>
