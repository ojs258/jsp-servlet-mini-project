package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jsp.servlet.dto.NewsDto;
import jsp.servlet.entity.News;
import jsp.servlet.service.NewsService;

@WebServlet(value = "/detail")
public class DetailNews extends HttpServlet {

    private static final NewsService newsService = new NewsService();

    NewsDto detailNews;

    public DetailNews() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n_id = Integer.parseInt(req.getParameter("id"));

        detailNews = newsService.detailNews(n_id);
        req.setAttribute("detailNews", detailNews);
        req.getRequestDispatcher("/newsDetail.jsp").forward(req, resp);
    }
}
