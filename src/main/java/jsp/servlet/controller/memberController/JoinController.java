package jsp.servlet.controller.memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.CustomException.JoinException.EmailDuplicatedException;
import jsp.CustomException.JoinException.JoinInformationInsufficientException;
import jsp.servlet.dto.MemberDto;
import jsp.servlet.service.MemberService;

import java.io.IOException;

@WebServlet(urlPatterns = "/join")
public class JoinController extends HttpServlet {

    private final static MemberService memberService = new MemberService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDto newMember = new MemberDto();

        newMember.setEmail(req.getParameter("email"));
        newMember.setPw(req.getParameter("pw"));
        newMember.setName(req.getParameter("name"));

        try{
            memberService.join(newMember);
        }catch (EmailDuplicatedException | JoinInformationInsufficientException e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("joinForm.jsp").forward(req, resp);
        }
        resp.sendRedirect("index.html");
    }
}
