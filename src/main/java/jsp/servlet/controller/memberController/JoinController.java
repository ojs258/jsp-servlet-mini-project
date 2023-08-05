package jsp.servlet.controller.memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.JoinException.EmailDuplicatedException;
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

        try{
            memberService.join(member);
        }catch (EmailDuplicatedException e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("joinForm.jsp").forward(req, resp);
        }
        resp.sendRedirect("index.html");
    }
}
