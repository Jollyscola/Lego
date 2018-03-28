/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.PresentationLayer;

import database.FunctionLayer.Brickcalculateor;
import database.FunctionLayer.LogicFacade;
import database.FunctionLayer.Order;
import database.FunctionLayer.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewOrderCommand extends Command {

    @Override
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("login.jsp?error=You must be logged in.");
            return;
        }

      
           
        
        
        
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            //int oid = Integer.parseInt(request.getParameter("oid"));
            //LogicFacade.calcBricks(user, oid);
            List<Order> orders = LogicFacade.getUserOrders(user.getId());
            request.setAttribute("orders", orders);
             //request.setAttribute("oid", oid);
            request.getRequestDispatcher("WEB-INF/orders.jsp").forward(request, response);
    }
}
