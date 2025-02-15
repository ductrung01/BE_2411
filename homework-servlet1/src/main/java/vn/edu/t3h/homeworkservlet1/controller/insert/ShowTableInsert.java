package vn.edu.t3h.homeworkservlet1.controller.insert;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Handler;
@WebServlet(name = "ShowTableInsert",value = "/table-insert-employee")
public class ShowTableInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cms/add-employee.jsp");
        requestDispatcher.forward(req, resp);
    }
}
