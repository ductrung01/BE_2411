package vn.edu.t3h.homeworkservlet1.controller.delete;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homeworkservlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homeworkservlet1.DAO.impl.EmployeeDAOImpl;
import vn.edu.t3h.homeworkservlet1.service.EmployeeService;
import vn.edu.t3h.homeworkservlet1.service.impl.EmployeeServiceImpl;

import java.io.IOException;

@WebServlet(name = "DeleteEmployeeServlet" , value = "/delete-employee")
public class DeleteEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        super.init();
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeService = new EmployeeServiceImpl(employeeDAO);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        employeeService.deleteEmployeeById(id);
        resp.sendRedirect("/employee");
    }
}
