package vn.edu.t3h.bookstore.controller.admin.book;

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
import java.util.List;
import java.io.IOException;

@WebServlet(name = "findBook", value = "/cms/admin-manager")
public class BookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        BookDao bookDao = new BookDaoImpl();
        bookService = new BookServiceImpl(bookDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cms/admin-productManager.jsp");
        List<Book> books = bookService.getAllBook();
        System.out.println("Số lượng sách: " + books.size());

        req.setAttribute("books", books);
        requestDispatcher.forward(req, resp);



    }
}
