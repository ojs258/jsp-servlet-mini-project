

package jsp.servlet.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.servlet.Entity.Member;
import jsp.servlet.Repository.MemberRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/members")
public class membersController extends HttpServlet {

    private static final MemberRepository memberRepository = new MemberRepository();

    public membersController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);
        req.getServletContext().getRequestDispatcher("/memberList.jsp").forward(req,resp);
    }
}

