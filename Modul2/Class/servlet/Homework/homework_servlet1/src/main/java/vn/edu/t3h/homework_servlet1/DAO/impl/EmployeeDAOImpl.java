package vn.edu.t3h.homework_servlet1.DAO.impl;

import vn.edu.t3h.homework_servlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homework_servlet1.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getEmployees() {
        Connection connection = getConnection();
        List<Employee> employeeResult = new ArrayList<Employee>();
//        Câu lệnh truy vấn
        String sql = "SELECT * FROM employees e inner join departments d " +
                "on e.department_id = d.department_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepartment(resultSet.getString("department_id"));
                employee.setPosition(resultSet.getString("position"));
                employee.setHireDate(resultSet.getString("hire_date"));
                employeeResult.add(employee);
            }
            System.out.println("getAllEmployees success") ;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return employeeResult;
    }
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/quanlynhansu";
        String user = "root";
        String password = "01112003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (ClassNotFoundException |SQLException  e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
