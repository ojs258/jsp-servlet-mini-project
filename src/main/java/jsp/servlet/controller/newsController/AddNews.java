package jsp.servlet.controller.newsController;

import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jsp.servlet.dto.NewsDto;
import jsp.servlet.repository.NewsRepository;
import jsp.servlet.service.NewsService;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(value = "/add")
@MultipartConfig(maxFileSize = 1024*1024*2, location = "c:/dev/img")
public class AddNews extends HttpServlet {

    private static final NewsService newsService = new NewsService();
    NewsDto news;
    public AddNews() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer m_id = (Integer) session.getAttribute("id");
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Part part = req.getPart("file");
        String fileName = getFilename(part);
        if(fileName != null && !fileName.isEmpty()){
            part.write(fileName);
        }
        try{
            newsService.addNews(new NewsDto(title,"/img/"+fileName,content,m_id));
        }catch (Exception e){
            req.setAttribute("error",e.getMessage());
            req.getRequestDispatcher("newsForm.jsp").forward(req,resp);
        }
        resp.sendRedirect("/news");
    }

    public String getFilename(Part part) {
        String header = part.getHeader("content-disposition");

        int start = header.indexOf("filename=");
        return header.substring(start+10,header.length()-1);
    }

}
