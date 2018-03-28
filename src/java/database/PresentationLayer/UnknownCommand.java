package database.PresentationLayer;

import database.FunctionLayer.LoginSampleException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    void execute( HttpServletRequest request, HttpServletResponse response ) throws ServletException {
        String msg = "Unknown command. Contact IT";
        request.setAttribute("error", msg);
        request.getRequestDispatcher("/WEB-INF/login.jsp");
    }

}
