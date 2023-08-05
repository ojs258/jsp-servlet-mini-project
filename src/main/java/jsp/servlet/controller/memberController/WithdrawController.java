package jsp.servlet.controller.memberController;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp.servlet.service.MemberService;

import java.io.IOException;

@WebServlet(value = "/withdraw")
public class WithdrawController extends HttpServlet {
    private final static MemberService memberService = new MemberService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Integer id = (Integer) session.getAttribute("id");
        memberService.withdraw(id);
        resp.sendRedirect("/index.html");
    }
}
