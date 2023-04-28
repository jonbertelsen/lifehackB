package dat.backend.control;

import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The purpose of the class is to deliver logout specific code
 */
@WebServlet(name = "logout", urlPatterns = {"/logout"} )
public class Logout extends HttpServlet
{
    /**
     * Logout user and invalidate session scope
     * @param request
     * @param response
     * @throws IOException Will be thrown if .....
     * @author jobe
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}