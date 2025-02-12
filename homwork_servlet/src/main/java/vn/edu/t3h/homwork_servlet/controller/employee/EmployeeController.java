package vn.edu.t3h.homwork_servlet.controller.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homwork_servlet.DAO.EmployeeDAO;
import vn.edu.t3h.homwork_servlet.DAO.impl.EmployeeDAOImpl;
import vn.edu.t3h.homwork_servlet.model.Employee;
import vn.edu.t3h.homwork_servlet.service.EmployeeService;
import vn.edu.t3h.homwork_servlet.service.EmployeeServiceImpl;

import java.util.List;
import java.io.IOException;

@WebServlet (name = "employee", value = "/employee")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
         employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //get param from request
        String name = req.getParameter("name");
        String salary = req.getParameter("salary");
        String fromDate = req.getParameter("fromDate");
        String toDate = req.getParameter("toDate");
        String position = req.getParameter("position");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("employee-list.jsp");

        List<Employee> employees = employeeService.findByFilter(name,salary,fromDate,toDate,position);
        req.setAttribute("employeeData", employees);
        requestDispatcher.forward(req, resp);

    }
}
