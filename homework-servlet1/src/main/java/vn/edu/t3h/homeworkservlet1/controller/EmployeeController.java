package vn.edu.t3h.homeworkservlet1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homeworkservlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homeworkservlet1.DAO.impl.EmployeeDAOImpl;
import vn.edu.t3h.homeworkservlet1.model.Employee;
import vn.edu.t3h.homeworkservlet1.service.EmployeeService;
import vn.edu.t3h.homeworkservlet1.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "employee",value = "/cms/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeService =new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String fromDate = req.getParameter("fromDate");
        String toDate = req.getParameter("toDate");
        String position = req.getParameter("position");
        List<Employee> employees = employeeService.findByCondition(name,salary,fromDate,toDate,position);
        req.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employees.jsp");
        requestDispatcher.forward(req,resp);
    }
}
