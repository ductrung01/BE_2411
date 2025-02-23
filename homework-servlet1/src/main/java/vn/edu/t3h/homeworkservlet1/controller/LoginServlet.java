package vn.edu.t3h.homeworkservlet1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homeworkservlet1.DAO.impl.RoleDAOImpl;
import vn.edu.t3h.homeworkservlet1.DAO.impl.UserDAOImpl;
import vn.edu.t3h.homeworkservlet1.service.UserService;
import vn.edu.t3h.homeworkservlet1.service.impl.UserServiceImpl;
import vn.edu.t3h.homeworkservlet1.util.Constans;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login" , "/logout"})
public class LoginServlet extends HttpServlet {
    private  UserService userService;

    @Override
    public void init() throws ServletException {

        this.userService = new UserServiceImpl(new UserDAOImpl(), new RoleDAOImpl());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Kiểm tra xem người dùng có đang thực hiện hành động logout ko
        // nếu req.getRequestURI mà là logout thì xóa Attribute liên quan đến phiên của người dùng khỏi HttpSession.
        if(req.getRequestURI().contains("/logout")){//Kiểm tra xem req.getRequestURI có phải là logout ko, nếu phải thì
            //delete session when logout
            req.getSession().removeAttribute(Constans.SESSION_ID_CURRENT_USER);
            resp.sendRedirect("/home");
            // xóa session khi logout đi và ở đây sẽ phải truyền 1 key vào cặp dấu ""
        }
       else{
            String message = req.getParameter("message");
            req.setAttribute("message", message);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String urlRedirect =userService.login(username, password, req);// dòng mã này dùnd de dieu huong trang sau khi ngươi dung dangnhap
        resp.sendRedirect(urlRedirect);

        }
    }
