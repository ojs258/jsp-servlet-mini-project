package jsp.servlet.controller.memberController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(value = "/logout")
public class logoutController extends HttpServlet {

    public logoutController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        session.removeAttribute("customInfo");
        session.invalidate();

        resp.sendRedirect("index.html");
    }
}
