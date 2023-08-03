package jsp.servlet.controller.memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.servlet.entity.Member;
import jsp.servlet.service.MemberService;

import java.io.IOException;

@WebServlet(urlPatterns = "/join")
public class JoinController extends HttpServlet {

    private final static MemberService memberService = new MemberService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");

        memberService.saveForJoin(new Member(email, pw, name));

        resp.sendRedirect("index.html");
    }
}
