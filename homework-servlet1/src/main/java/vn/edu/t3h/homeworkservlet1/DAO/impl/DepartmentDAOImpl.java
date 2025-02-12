package vn.edu.t3h.homeworkservlet1.DAO.impl;

import vn.edu.t3h.homeworkservlet1.DAO.DepartmentDAO;
import vn.edu.t3h.homeworkservlet1.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public List<Department> getAllDepartments() {
        String sql = "select * from departments";
        List<Department> departmentResult = new ArrayList<>();
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Department department = new Department();
                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setLocation(resultSet.getString("location"));
                departmentResult.add(department);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return departmentResult;
    }
    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/quanlynhansu";
        String user = "root";
        String password = "01112003";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        }catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private static void closeConnection(Connection connection) {// Hàm để đóng connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


