package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;

@WebServlet(value = "/delete")
public class DeleteNews extends HttpServlet {

    public DeleteNews() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

//    public String deleteNews(HttpServletRequest req) {
//        int aid = Integer.parseInt(req.getParameter("aid"));
//        try {
//            newsRepository.delete(aid);
//        } catch (Exception e){
//            e.printStackTrace();
//            return listNews(req);
//        }
//        return "redirect:/news.nhn?action=listNews";
//    }
}
