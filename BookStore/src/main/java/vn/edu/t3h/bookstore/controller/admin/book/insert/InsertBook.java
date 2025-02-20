package vn.edu.t3h.bookstore.controller.admin.book.insert;

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

import java.awt.*;
import java.io.IOException;
import java.util.Base64;

@WebServlet(name = "InsertBook", value = "/cms/insert-book")
public class InsertBook extends HttpServlet {
    private BookService bookService;

    @Override
    public void init() throws ServletException {
        super.init();
        BookDao bookDao = new BookDaoImpl();
        bookService = new BookServiceImpl(bookDao);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenSach = req.getParameter("tenSach");
        String tacGia = req.getParameter("tacGia");
        int soTrang = Integer.parseInt(req.getParameter("soTrang"));
        String nhaXuatBan = req.getParameter("nhaXuatBan");
        int namXuatBan = Integer.parseInt(req.getParameter("namXuatBan"));
        double gia = Double.parseDouble(req.getParameter("gia"));
        double khuyenMai = Double.parseDouble(req.getParameter("khuyenMai"));
        int tonKho = Integer.parseInt(req.getParameter("tonKho"));
        String moTa = req.getParameter("moTa");
        String hinhAnh = req.getParameter("hinhAnh");

        int tongSoLuotMua = Integer.parseInt(req.getParameter("tongSoLuotMua"));
        boolean shop = req.getParameter("shop") != null;

        Book books = new Book();
        books.setTenSach(tenSach);
        books.setTacGia(tacGia);
        books.setSoTrang(soTrang);
        books.setNhaXuatBan(nhaXuatBan);
        books.setNamXuatBan(namXuatBan);
        books.setGia(gia);
        books.setGiamGia(khuyenMai);
        books.setSoLuongTonKho(tonKho);
        books.setMoTa(moTa);
        books.setHinhAnh(hinhAnh);
        books.setTongSoLuotMua(tongSoLuotMua);
        books.setShop(shop);
        bookService.addBook(books);

        resp.sendRedirect("/cms/admin-manager");



    }
}
