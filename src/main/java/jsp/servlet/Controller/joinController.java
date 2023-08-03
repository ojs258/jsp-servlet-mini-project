package jsp.servlet.Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp.servlet.Entity.Member;
import jsp.servlet.Repository.MemberRepository;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(value = "/join")
public class joinController extends HttpServlet {
    private static final MemberRepository memberRepository = new MemberRepository();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String pw = req.getParameter("pw");
        String name = req.getParameter("name");
        memberRepository.save(new Member(email, pw, name));
    }
}
