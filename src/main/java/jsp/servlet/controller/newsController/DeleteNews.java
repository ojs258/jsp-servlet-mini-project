package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jsp.servlet.service.NewsService;

@WebServlet(value = "/delete")
public class DeleteNews extends HttpServlet {

    private static final NewsService newsService = new NewsService();

    public DeleteNews() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n_id = Integer.parseInt(req.getParameter("id"));
        newsService.deleteNews(n_id);
        resp.sendRedirect("/news");
    }
}

