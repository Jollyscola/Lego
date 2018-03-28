
<%@page import="database.FunctionLayer.User"%>

<%User user = (User) session.getAttribute("user");%>

<nav>
    <ul>

        <li class="Legohuset">Lego House</li>
        <li><a href="index.jsp">Front page</a></li>
            <% if (user == null) { %>
        <li><a href="login.jsp">Login/Register</a></li>
            <% } else { %>
        <li class="navbar-text">
            <a href="FrontController?command=home">Home</a>
            
        </li>
            <li>
                <a href="FrontController?command=orders">Orders</a>
                
            </li>
        <li class="navbar-text">
            <a href="FrontController?command=house">New House</a>    
            
            </li>
        
        <li class="navbar-text">
            <a href="FrontController?command=logout">Logout</a>
            
        </li>
        
        <% }%>
    </ul>
</nav>