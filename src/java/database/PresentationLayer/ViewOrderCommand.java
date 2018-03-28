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

        try {
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));
            LogicFacade.calcBricks(length, width, height);
        } catch (NumberFormatException ex) {

            request.setAttribute("error", "you have error");
        }
        
        
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            List<Order> orders = LogicFacade.getUserOrders(user.getId());
            request.setAttribute("orders", orders);
            request.getRequestDispatcher("WEB-INF/orders.jsp").forward(request, response);
    }
}
