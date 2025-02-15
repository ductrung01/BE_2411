package vn.edu.t3h.homeworkservlet1.controller.insert;

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

import java.io.IOException;

@WebServlet(name = "InsertEmployeeServlet" , value = "/insert-employee")
public class InsertEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String position = req.getParameter("position");
        Double salary = Double.valueOf(req.getParameter("salary"));
        Integer departmentId = Integer.valueOf(req.getParameter("department_id"));
        String hireDate = req.getParameter("hire_date");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setPosition(position);
        employee.setSalary(salary);
        employee.setDepartmentId(departmentId);
        employee.setHireDate(hireDate);

        employeeService.insertEmployee(employee);
        resp.sendRedirect("/employee");


    }
}
