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

@WebServlet(value = "/action-employee")
public class AddEmployeeControllerServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add-employee.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get param from request
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String departmentId = req.getParameter("department_id");
        String hireDate = req.getParameter("hire_date");
        employeeService.addEmployeeService(name, salary,position,departmentId,hireDate);
        List<Employee> employeeList = employeeService.getAllEmployees();
        req.setAttribute("employeeData", employeeList);
        req.setAttribute("message", "Nhân viên đã được thêm thành công!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(req, resp);

    }
}
