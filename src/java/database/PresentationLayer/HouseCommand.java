/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.PresentationLayer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command subclass used to forward the customer to the input page for house
 * dimensions when 'New House' button is pressed in top menu.
 *
 * @author Gert Lehmann Madsen
 */
public class HouseCommand extends Command {

    @Override
    void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("login.jsp?error=You must be logged in.");
            return;
        }
        request.getRequestDispatcher("WEB-INF/" + "input" + "page.jsp").forward(request, response);
    }

}
