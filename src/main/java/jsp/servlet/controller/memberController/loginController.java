package jsp.servlet.controller.memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jsp.servlet.dto.MemberDto;
import jsp.servlet.service.MemberService;

import java.io.IOException;

@WebServlet(value = "/login")
public class loginController extends HttpServlet {

    private final static MemberService memberService = new MemberService();
    MemberDto memberDto;
    @Override
    public void init() throws ServletException {
        memberDto = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try{
            memberDto = memberService.login(req.getParameter("email"), req.getParameter("pw"));
        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
        }
        session.setAttribute("id",memberDto.getId());
        session.setAttribute("name",memberDto.getName());
        resp.sendRedirect("/main.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
