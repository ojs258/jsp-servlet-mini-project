package jsp.servlet.Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp.servlet.Repository.MemberRepository;

import java.io.IOException;

@WebServlet(value = "/login")
public class loginController extends HttpServlet {

    private static final MemberRepository memberRepository = new MemberRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pw = req.getParameter("pw");

        memberRepository.findOne(email)
    }
}
