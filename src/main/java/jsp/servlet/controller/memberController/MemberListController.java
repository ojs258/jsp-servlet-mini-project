

package jsp.servlet.controller.memberController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.servlet.entity.Member;
import jsp.servlet.repository.MemberRepository;


import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/members")
public class MemberListController extends HttpServlet {

    private static final MemberRepository memberRepository = new MemberRepository();

    public MemberListController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);
        req.getServletContext().getRequestDispatcher("/memberList.jsp").forward(req,resp);
    }
}

