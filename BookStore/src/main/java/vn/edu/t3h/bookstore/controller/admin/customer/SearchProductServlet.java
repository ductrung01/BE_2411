package vn.edu.t3h.bookstore.controller.admin.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.bookstore.dao.CustomerDao;
import vn.edu.t3h.bookstore.dao.impl.CustomerDaoImpl;
import vn.edu.t3h.bookstore.model.Book;
import vn.edu.t3h.bookstore.service.CustomerService;
import vn.edu.t3h.bookstore.service.impl.CustomerServiceImpl;

import java.util.List;
import java.io.IOException;
@WebServlet(name = "SearchProduct", value = "/searchProduct")
public class SearchProductServlet extends HttpServlet {
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        CustomerDao customerDao = new CustomerDaoImpl();
        customerService = new CustomerServiceImpl(customerDao);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<Book> searchResults = customerService.findByCondition(keyword);
        req.setAttribute("searchResults", searchResults);
        req.setAttribute("hasResults", !searchResults.isEmpty());
        req.getRequestDispatcher("searchProduct.jsp").forward(req, resp);



    }
}
