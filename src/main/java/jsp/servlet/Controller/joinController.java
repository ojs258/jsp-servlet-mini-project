
package jsp.servlet.Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp.servlet.Repository.MemberRepository;

import java.io.IOException;

@WebServlet(value = "/join")
public class joinController extends HttpServlet {
    private static final MemberRepository memberRepository = new MemberRepository();
    public joinController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
