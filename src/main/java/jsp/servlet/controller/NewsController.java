package jsp.servlet.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jsp.servlet.entity.News;
import jsp.servlet.repository.NewsRepository;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(urlPatterns = "/news.nhn")
@MultipartConfig(maxFileSize = 1024*1024*2, location = "c:/dev/img")
public class NewsController extends HttpServlet {
    private ServletContext ctx;
    private NewsRepository newsRepository;

    private final String START_PAGE = "newList.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ctx = getServletContext();
        newsRepository = new NewsRepository();
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");

        Method m;
        String view = null;

        if(action == null){
            action = "listNews";
        }
        try{
            m = this.getClass().getMethod(action, HttpServletRequest.class);
            view = (String)m.invoke(this, req);

        } catch (Exception e){
            e.printStackTrace();
            view = START_PAGE;
        }

        if (view.startsWith("redirect:/")){
            resp.sendRedirect(view.substring("redirect:/".length()));
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(view);
            dispatcher.forward(req,resp);
        }
    }
    private News news = new News();

    public String addNews(HttpServletRequest req){

        try{
            Part part = req.getPart("file");
            String fileName = getFilename(part);
            if(fileName != null && !fileName.isEmpty()){
                part.write(fileName);
            }

            BeanUtils.populate(news,req.getParameterMap());
            news.addImg("/img/"+fileName);

            newsRepository.save(news);

        }catch (Exception e){
            e.printStackTrace();
            return listNews(req);
        }

        return "redirect:/news.nhn?action=listNews";
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
    public String getNews(HttpServletRequest req) {

        int aid = Integer.parseInt(req.getParameter("aid"));
        News news = newsRepository.findOne(aid);

        try {
            req.setAttribute("news",news);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "newsView.jsp";
    }
    public String deleteNews(HttpServletRequest req) {
        int aid = Integer.parseInt(req.getParameter("aid"));
        try {
            newsRepository.delete(aid);
        } catch (Exception e){
            e.printStackTrace();
            return listNews(req);
        }
        return "redirect:/news.nhn?action=listNews";
    }
    public String getFilename(Part part) {
        String header = part.getHeader("content-disposition");

        int start = header.indexOf("filename=");
        return header.substring(start+10,header.length()-1);
    }
}
