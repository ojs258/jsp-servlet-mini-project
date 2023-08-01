
package jsp.servlet.Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jsp.servlet.DAO.Member;
import jsp.servlet.Repository.MemberRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/join")
public class joinController extends HttpServlet {
    private static final MemberRepository memberRepository = new MemberRepository();
    public joinController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");

        memberRepository.save(new Member(id, name ,pw));
        List<Member> members = memberRepository.findMemberList();

        req.setAttribute("members", members);
        req.getServletContext().getRequestDispatcher("/MemberList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
