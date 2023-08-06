package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jsp.servlet.entity.News;

@WebServlet(value = "/detail")
public class DetailNews extends HttpServlet {

    public DetailNews() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

//    public String getNews(HttpServletRequest req) {
//
//        int aid = Integer.parseInt(req.getParameter("aid"));
//        News news = newsRepository.findOne(aid);
//
//        try {
//            req.setAttribute("news",news);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "newsView.jsp";
//    }
}
