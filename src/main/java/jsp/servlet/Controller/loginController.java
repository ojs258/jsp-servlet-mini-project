package jsp.servlet.Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class loginController extends HttpServlet {
    public loginController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
