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
        
        <a href="includes/menu.jsp"></a>
       <h1>Login in lego</h1>
        <form id="login" action="FrontController" method="post">
            <input type="text" name="email" value="" placeholder="Email" />
            <input type="password" name="password" value="" placeholder="Password" />
            <input type="hidden" name="command" value="login" />
            <input type="submit" value="Log in" />
        </form>
        <% String error = (String) request.getAttribute( "error"); %>
        <% if(error !=null){ %>
    <p>ERROR</p>
    <%= error %>
    <%}%>
       
       
       
    </body>
</html>
