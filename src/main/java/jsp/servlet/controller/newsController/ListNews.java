package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jsp.servlet.dto.NewsDto;
import jsp.servlet.entity.News;
import jsp.servlet.service.NewsService;

@WebServlet(value = "/news")
public class ListNews extends HttpServlet {

    private static final NewsService newsService = new NewsService();

    public ListNews() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Integer m_id = (Integer) session.getAttribute("id");

        try {
            List<NewsDto> newslist = new ArrayList<>();
            newslist.addAll(newsService.memberNewsList(m_id));
            req.setAttribute("newslist",newslist);
        } catch (Exception e) {
            req.setAttribute("error",e.getMessage());
        }finally {
            req.getRequestDispatcher("/newsList.jsp").forward(req,resp);
        }
    }
}
