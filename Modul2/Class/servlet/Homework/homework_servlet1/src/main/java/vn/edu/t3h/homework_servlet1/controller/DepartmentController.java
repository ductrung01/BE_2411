package vn.edu.t3h.homework_servlet1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homework_servlet1.model.Department;
import vn.edu.t3h.homework_servlet1.service.DepartmentService;
import vn.edu.t3h.homework_servlet1.service.DepartmentServiceImpl;

import java.util.List;
import java.io.IOException;

@WebServlet(name = "department" , value = "/department")
public class DepartmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentService departmentService = new DepartmentServiceImpl();
        List<Department> departments = departmentService.getAllDepartments();
        req.setAttribute("departmentData", departments);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("department-list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
