package vn.edu.t3h.homeworkservlet1.controller.update;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homeworkservlet1.DAO.DepartmentDAO;
import vn.edu.t3h.homeworkservlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homeworkservlet1.DAO.impl.DepartmentDAOImpl;
import vn.edu.t3h.homeworkservlet1.DAO.impl.EmployeeDAOImpl;
import vn.edu.t3h.homeworkservlet1.model.Department;
import vn.edu.t3h.homeworkservlet1.model.Employee;
import vn.edu.t3h.homeworkservlet1.service.DepartmentService;
import vn.edu.t3h.homeworkservlet1.service.EmployeeService;
import vn.edu.t3h.homeworkservlet1.service.impl.DepartmentServiceImpl;
import vn.edu.t3h.homeworkservlet1.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.io.IOException;

@WebServlet(name = "EditEmployee", value = "/edit-employee")
public class ShowTableEdit extends HttpServlet {
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        super.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeService = new EmployeeServiceImpl(employeeDAO);
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentService = new DepartmentServiceImpl(departmentDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Employee employee = employeeService.getEmployeeById(Integer.parseInt(id));
        req.setAttribute("employee", employee);
        List<Department> departments = departmentService.getAllDepartments();
        req.setAttribute("departments", departments);
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("edit-employee.jsp");
        requestDispatcher.forward(req, resp);
    }
}
