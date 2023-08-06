package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jsp.servlet.entity.News;

@WebServlet(value = "/news")
public class ListNews extends HttpServlet {

    public ListNews() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    public String listNews(HttpServletRequest req) {
        List<News> list = newsRepository.findAll();
        try {
            req.setAttribute("newslist",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "newsList.jsp";
    }
}
