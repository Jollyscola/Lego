<%-- 
    Document   : login
    Created on : 19-03-2018, 13:17:09
    Author     : Jollys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file="includes/menu.jsp" %>
        
       <h1>Login in lego</h1>
        <form name="login" action="FrontController" method="post">
                <input type="hidden" name="command" value="login" />
            <input type="text" name="email"  placeholder="Email" />
            <input type="password" name="password"  placeholder="Password" />
            
            <input type="submit" value="Log in" />
        </form>
       
       <h1>Register</h1>
        <from name="register" action="FrontController" method="post">
            <input type="hidden" name="command" value="register"/>
            Email:
            <br/>
            <input type="email" name="email"  placeholder="email"/>
            <br/>
            Password:
            <br/>
            <input type="password" name="password1" placeholder="password"/>
            <br/>
            Retype Password:
            <br/>
            <input type="password" name="password2" placeholder="repeat password"/>
            <br/>
            <input type="submit" value="Submit"> 
        </from>
        <% String error = (String) request.getAttribute( "error"); %>
        <% if(error !=null){ %>
    <p>ERROR</p>
    <%= error %>
    <%}%>
       
       
       
    </body>
</html>
