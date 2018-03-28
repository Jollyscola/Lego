/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.PresentationLayer;

import database.DBAccess.OrderMapper;
import database.DBAccess.WritingToSQLException;
import database.PresentationLayer.InputException;
import database.FunctionLayer.LegohusException;
import database.FunctionLayer.LogicFacade;
import database.FunctionLayer.Order;
import database.FunctionLayer.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class InputCommand extends Command {

       
    @Override
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        int length = 0, width = 0, height = 0, user_id = 0;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
         if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("login.jsp?error=You must be logged in.");
            return;
        }
       Order order;
        try {
                       
            length = Integer.parseInt(request.getParameter("length"));
            width = Integer.parseInt(request.getParameter("width"));
            height = Integer.parseInt(request.getParameter("heigth"));
            user_id = user.getId();
            
         order = LogicFacade.createOrder(user_id,length,width,height);
            
            
        } catch (NumberFormatException ex) {
throw new IllegalStateException(ex);
//request.setAttribute("error", "An error occurred.");
        }
        boolean valid = LogicFacade.Dimensions(length, width, height);
        if(valid){
        
       
        
        }
       response.sendRedirect("FrontController?command=orders");
    }

}
