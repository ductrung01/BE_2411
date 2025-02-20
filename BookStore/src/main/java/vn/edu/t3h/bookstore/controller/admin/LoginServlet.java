package vn.edu.t3h.bookstore.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.bookstore.dao.impl.RoleDAOImpl;
import vn.edu.t3h.bookstore.dao.impl.UserDAOImpl;
import vn.edu.t3h.bookstore.service.UserService;
import vn.edu.t3h.bookstore.service.impl.UserServiceImpl;
import vn.edu.t3h.bookstore.util.Constans;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login","/logout"})
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {

        this.userService = new UserServiceImpl(new UserDAOImpl(), new RoleDAOImpl());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getRequestURI().contains("/logout")){//Kiểm tra
            //delete session when logout
            req.getSession().removeAttribute(Constans.SESSION_ID_CURRENT_USER);
            resp.sendRedirect("/");
        }
        String message = req.getParameter("message");
        req.setAttribute("message", message);
        req.getRequestDispatcher("signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String urlRedirect =userService.login(username, password);
        resp.sendRedirect(urlRedirect);

    }
}
