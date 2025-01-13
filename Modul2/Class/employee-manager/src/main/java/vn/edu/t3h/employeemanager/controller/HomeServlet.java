package vn.edu.t3h.employeemanager.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "HomeController" , value = "/home-servlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // config kiểu dữ liệu trả về là html text
        resp.setContentType("text/html");

        // ghi dữ lệu vào response
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Chào t3h </h1>");
        out.println("</body></html>");
    }
}
