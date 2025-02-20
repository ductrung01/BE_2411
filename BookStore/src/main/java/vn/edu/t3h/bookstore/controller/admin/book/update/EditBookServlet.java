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
import java.util.Base64;

@WebServlet(name = "UpdateBook",value = "/update-book")
public class EditBookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        BookDao bookDao = new BookDaoImpl();
        bookService = new BookServiceImpl(bookDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idSach"));
        String name = req.getParameter("tenSach");
        String author = req.getParameter("tacGia");
        int pages = Integer.parseInt(req.getParameter("soTrang"));
        String publisher = req.getParameter("nhaXuatBan");
        int yearPublishing = Integer.parseInt(req.getParameter("namXuatBan"));
        double price = Double.parseDouble(req.getParameter("gia"));
        double discount = Double.parseDouble(req.getParameter("khuyenMai"));
        int quantity = Integer.parseInt(req.getParameter("tonKho"));
        String description = req.getParameter("description");
        String image = req.getParameter("hinhAnh");

          int totalBuy = Integer.parseInt(req.getParameter("tongSoLuotMua"));

        Book book = new Book();
        book.setIdSach(id);
        book.setTenSach(name);
        book.setTacGia(author);
        book.setSoTrang(pages);
        book.setNhaXuatBan(publisher);
        book.setNamXuatBan(yearPublishing);
        book.setGia(price);
        book.setGiamGia(discount);
        book.setSoLuongTonKho(quantity);
        book.setMoTa(description);
        book.setHinhAnh(image);
        book.setTongSoLuotMua(totalBuy);
        bookService.updateBook(book);
        resp.sendRedirect("cms/admin-manager");




    }
}
