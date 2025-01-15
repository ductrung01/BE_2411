package vn.edu.t3h.homework_servlet1.DAO.impl;

import vn.edu.t3h.homework_servlet1.DAO.DepartmentDAO;
import vn.edu.t3h.homework_servlet1.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public List<Department> getAllDepartments() {
        Connection connection = getConnection();
        List<Department> departmentResult = new ArrayList<>();
        String sql = "Select * from departments";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("department_id"));
                department.setName(resultSet.getString("department_name"));
                department.setDepartmentLocation(resultSet.getString("location"));
                departmentResult.add(department);
             }
        } catch (SQLException e) {
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

        return departmentResult;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/quanlynhansu";
        String user = "root";
        String password = "01112003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
