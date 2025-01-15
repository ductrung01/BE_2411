package vn.edu.t3h.homework_servlet1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homework_servlet1.model.Employee;
import vn.edu.t3h.homework_servlet1.service.DepartmentService;
import vn.edu.t3h.homework_servlet1.service.DepartmentServiceImpl;
import vn.edu.t3h.homework_servlet1.service.EmployeeService;
import vn.edu.t3h.homework_servlet1.service.EmployeeServiceImpl;

import java.util.List;
import java.io.IOException;

@WebServlet(name = "employee" ,value="/employee")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService employeeService = new EmployeeServiceImpl();
        List<Employee> employees = employeeService.getAllEmployees();
        req.setAttribute("employeeData", employees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee-list.jsp");
        requestDispatcher.forward(req,resp);
    }
}
