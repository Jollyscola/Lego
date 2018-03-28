<%-- 
    Document   : order
    Created on : 22-03-2018, 15:56:55
    Author     : Jollys
--%>

<%@page import="database.FunctionLayer.Bricks"%>
<%@page import="java.util.List"%>
<%@page import="database.FunctionLayer.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../includes/menu.jsp" %>
        <table>
            
            <thead>
                <tr>
                    
                    <th>Id</th>
                    <th>length</th>
                    <th>width</th>
                    <th>heigth</th>
                   
                    
                </tr>
            </thead> 
            <tbody>
            <%Bricks bricks = new Bricks(); %>
                <% for (Order order : (List<Order>) request.getAttribute("orders")) {%>
                <tr>
                    
                    <td><%= order.getId()%></td>
                    <td><%= order.getLength()%></td>
                    <td><%= order.getWidth()%></td>
                    <td><%= order.getHeight()%></td>
                   
                </tr>
                <%}%>




            </tbody>
        </table>

    </body>
</html>
