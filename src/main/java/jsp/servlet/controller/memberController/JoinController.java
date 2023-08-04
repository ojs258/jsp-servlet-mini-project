package jsp.servlet.controller.memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.servlet.dto.MemberDto;
import jsp.servlet.entity.Member;
import jsp.servlet.service.MemberService;

import java.io.IOException;

@WebServlet(urlPatterns = "/join")
public class JoinController extends HttpServlet {

    private final static MemberService memberService = new MemberService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDto member = new MemberDto();

        member.setEmail(req.getParameter("email"));
        member.setPw(req.getParameter("pw"));
        member.setName(req.getParameter("name"));

        memberService.join(member);

        resp.sendRedirect("index.html");
    }
}
