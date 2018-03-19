<%-- 
    Document   : Register
    Created on : 19-03-2018, 13:33:24
    Author     : Jollys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>register</title>
    </head>
    <body>
        <a href="includes/menu.jsp"></a>
        <h1>Register</h1>
        <from name="register" action="FrontController" method="post">
            <input type="hidden" name="command" value="register">
            Email:
            <input type="text" name="email"  placeholder="email">
            <br/>
            <input type="password" name="password1" placeholder="password">
            <br/>
            <input type="password" name="password2" placeholder="repeat password">
            <br/>
            <input type="submit" value="Submit"> 
        </from>
        
    
    </body>
</html>
