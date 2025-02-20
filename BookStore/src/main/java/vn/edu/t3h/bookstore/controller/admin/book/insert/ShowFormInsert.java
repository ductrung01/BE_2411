package vn.edu.t3h.bookstore.controller.admin.book.insert;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ShowFormInsert", value = "/form-insert-book")
public class ShowFormInsert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("add".equals(action)){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/admin-productManager-addProduct.jsp");
            requestDispatcher.forward(req, resp);
        }

    }
}
