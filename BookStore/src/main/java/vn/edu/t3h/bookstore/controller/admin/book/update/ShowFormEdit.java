package vn.edu.t3h.bookstore.controller.admin.book.update;

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

@WebServlet(name = "FormEditBook", value = "/form-update-book")
public class ShowFormEdit extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        BookDao bookDao = new BookDaoImpl();
        bookService = new BookServiceImpl(bookDao);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.getBookById(Integer.parseInt(id));
        req.setAttribute("book", book);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("cms/admin-productManager-editProduct.jsp");
        requestDispatcher.forward(req, resp);
    }


}
