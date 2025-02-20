package vn.edu.t3h.bookstore.controller.admin.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.bookstore.dao.BookDao;
import vn.edu.t3h.bookstore.dao.impl.BookDaoImpl;
import vn.edu.t3h.bookstore.model.Book;
import vn.edu.t3h.bookstore.service.BookService;
import vn.edu.t3h.bookstore.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(value = "/")
public class HomeServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        BookDao bookDao = new BookDaoImpl();
        bookService = new BookServiceImpl(bookDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
        List<Book> books = bookService.getAllBook();
        req.setAttribute("books", books);
        requestDispatcher.forward(req, resp);
    }
}
