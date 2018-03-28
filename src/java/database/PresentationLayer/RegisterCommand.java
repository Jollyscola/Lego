package database.PresentationLayer;

import database.FunctionLayer.LogicFacade;
import database.FunctionLayer.LoginSampleException;
import database.FunctionLayer.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterCommand extends Command {

    @Override
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String email = request.getParameter("email");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            if (password1.equals(password2)) {
                User user = LogicFacade.createUser(email, password1);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                request.getRequestDispatcher("/WEB-INF/" + user.getRole() + "page.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Two passwords must match.");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (LoginSampleException e) {
            request.setAttribute("error", "An error occurred.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
