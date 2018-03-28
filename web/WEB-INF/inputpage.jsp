<%-- 
    Document   : inputpage
    Created on : 21-03-2018, 20:58:28
    Author     : Jollys
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <style>
            
                      
                  body{
    background-image: url(Picture/patternlego.jpg);
    
    
}
        </style>

        <title>inputpage</title>
    </head>
    <body>
        
        <%@include file="../includes/menu.jsp" %>
        
        <div class="frames" id="input">
            <div>
                <h1 >Submit Order:</h1>
            </div>
            <div>
                <table>
                    <tr>
                        <td>
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="input"> 
                                <br/>
                                Length:
                                <br/>
                                <input type="number" name="length" value="1" min="1" >
                                <br/>
                                Width:
                                <br/>
                                <input type="number" name="width" value="1" min="1" >
                                <br/>
                                Heigth:
                                <br/>
                                <input type="number" name="heigth" value="1" min="1" > 
                                <br/>
                                <input type="submit" value="submit">
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
            
            <% String error = (String) request.getAttribute("error"); %>
            <% if (error != null) {%>
            <p style="color:red">Error: <%= error%></p>
            <%}%>
        </div>
    </body>
</html>
