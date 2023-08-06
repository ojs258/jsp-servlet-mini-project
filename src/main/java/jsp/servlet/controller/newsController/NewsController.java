package jsp.servlet.controller.newsController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jsp.servlet.repository.NewsRepository;

import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(urlPatterns = "/news.nhn")

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
        String action = req.getParameter("action");

        Method m;
        String view;

        if (action == null) {
            action = "listNews";
        }
        try {
            m = this.getClass().getMethod(action, HttpServletRequest.class);
            view = (String) m.invoke(this, req);

        } catch (Exception e) {
            e.printStackTrace();
            view = START_PAGE;
        }

        if (view.startsWith("redirect:/")) {
            resp.sendRedirect(view.substring("redirect:/".length()));
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher(view);
            dispatcher.forward(req, resp);
        }
    }
}