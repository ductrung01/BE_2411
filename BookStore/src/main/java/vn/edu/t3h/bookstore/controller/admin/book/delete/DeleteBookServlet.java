package vn.edu.t3h.bookstore.controller.admin.book.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.bookstore.dao.BookDao;
import vn.edu.t3h.bookstore.dao.impl.BookDaoImpl;
import vn.edu.t3h.bookstore.service.BookService;
import vn.edu.t3h.bookstore.service.impl.BookServiceImpl;

import java.io.IOException;

@WebServlet(name = "DeleteBook", value = "/cms/delete-book")
public class DeleteBookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        BookDao bookDao = new BookDaoImpl();
        bookService = new BookServiceImpl(bookDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.parseInt(req.getParameter("id"));
       bookService.deleteBookById(id);
       resp.sendRedirect("/cms/admin-manager");

    }
}
