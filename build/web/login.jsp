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
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <title>JSP Page</title>
        <style>
            td{
                width:300px;
                margin-right: 50px;
            }
                  body{
    background-image: url(Picture/patternlego.jpg);
    
    
}
            
        </style>
    </head>
    <body>

        <%@include file="includes/menu.jsp" %>

        <div class="frames" id="login" >
            <div>
                <% if (request.getParameter("error") != null) {%>
                <p style="color:red"><%= request.getParameter("error")%></p>
                <% } %>

                <table >
                    <tr>
                        <td>
                            <h1>Login into lego</h1>
                            <form name="login" action="FrontController" method="post">
                                
                                <input type="hidden" name="command" value="login" />
                                
                                <input type="text" name="email"  placeholder="Email" />
                                
                                <input type="password" name="password"  placeholder="Password" />
                                <br/><br/>
                                <div class="buttonHolder">
                                <input type="submit" value="Log in" />
                                </div>
                            </form>
                        </td>
                        <td>
                            <h1>Register</h1>
                            <form  action="FrontController" method="post">
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
                                <br/><br/>
                                <input type="submit" value="Submit"> 
                            </form>
                        <% String error = (String) request.getAttribute("error"); %>
                        <% if (error != null) {%>
                    <p style="color:red">Error: <%= error%></p>
                    <%}%>
                        </td>

                    
                    </tr>
                </table>'
            </div>

        </div>





    </body>
</html>
