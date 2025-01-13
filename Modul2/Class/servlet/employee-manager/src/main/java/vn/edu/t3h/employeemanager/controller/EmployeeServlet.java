package vn.edu.t3h.employeemanager.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.employeemanager.model.Employee;
import vn.edu.t3h.employeemanager.service.EmployeeService;
import vn.edu.t3h.employeemanager.service.EmployeeServiceImpl;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employees = employeeService.getAllEmployees();
// Nãy đã lấy được dữ liệu lên  bh phải gắn dữ liệu này vào trong request
// để hiển thị được dữ liệu lên trên màn hình thì ta có
// req.setAttribute("employees", employees);
        req.setAttribute("employeeData", employees);
// Ba dòng trên là đã trả được d liệu từ backend len controller rồi sau đó chúng ta
//        sẽ gắn dữ liệu lên phía fontend



        //       dùng  RequestDispatcher nó sẽ trả về file giao diện
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee-list.jsp");
       requestDispatcher.forward(req, resp);


        // config kiểu dữ liệu trả về là html text
//        resp.setContentType("text/html");
        // ghi dữ lệu vào response
//        PrintWriter out = resp.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>Danh sách nhân viên </h1>");
//        out.println("</body></html>");
    }
}
