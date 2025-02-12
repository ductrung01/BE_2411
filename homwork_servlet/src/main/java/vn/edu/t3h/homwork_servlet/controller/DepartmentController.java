package vn.edu.t3h.homwork_servlet.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homwork_servlet.DAO.DepartmentDAO;
import vn.edu.t3h.homwork_servlet.DAO.impl.DepartmentDAOImpl;
import vn.edu.t3h.homwork_servlet.model.Department;
import vn.edu.t3h.homwork_servlet.model.Employee;
import vn.edu.t3h.homwork_servlet.service.DepartmentService;
import vn.edu.t3h.homwork_servlet.service.DepartmentServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "department", value = "/department")
public class DepartmentController extends HttpServlet {
    private DepartmentService departmentService ;

    @Override
    public void init() throws ServletException {
        super.init();
       DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentService = new DepartmentServiceImpl(departmentDAO);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //get param from request
        String departmentName = req.getParameter("departmentName");
        String location = req.getParameter("location");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("department-list.jsp");
        List<Department> departments = departmentService.findByFilter(departmentName,location );
        req.setAttribute("departmentData", departments);
        requestDispatcher.forward(req, resp);

    }
}
