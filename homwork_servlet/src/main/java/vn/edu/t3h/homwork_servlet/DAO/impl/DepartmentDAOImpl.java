package vn.edu.t3h.homwork_servlet.DAO.impl;

import jakarta.servlet.RequestDispatcher;
import vn.edu.t3h.homwork_servlet.DAO.DepartmentDAO;
import vn.edu.t3h.homwork_servlet.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    public List<Department> findByCondition(String departmentName, String location) {

        String sql = "SELECT d.department_id, d.department_name, d.location " +
                "FROM departments d " +
                "WHERE (d.department_name LIKE ? OR ? IS NULL) " +
                "AND (d.location LIKE ? OR ? IS NULL)";

        Connection connection = null;
        List<Department> departments = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(departmentName != null){
                preparedStatement.setString(1, "%"+ departmentName +"%");
                preparedStatement.setString(2, "%"+ departmentName +"%");
            }else{
                preparedStatement.setNull(1, Types.VARCHAR);
                preparedStatement.setNull(2, Types.VARCHAR);
            }
            if(location != null){
                preparedStatement.setString(3, "%"+ location +"%");
                preparedStatement.setString(4, "%"+ location +"%");
            }else{
                preparedStatement.setNull(3, Types.VARCHAR);
                preparedStatement.setNull(4, Types.VARCHAR);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentLocation(resultSet.getString("location"));
                departments.add(department);
            }
        }catch(Exception e){
        e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return departments;
    }



    @Override
    public List<Department> getAllDepartments() {
       Connection connection = getConnection();
       List<Department> departmentResult = new ArrayList<Department>();
       String sql = "select * from departments";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department department = new Department();
                department.setId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentLocation(resultSet.getString("location"));
                departmentResult.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(connection);
        }
        return departmentResult;
    }




    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/quanlynhansu";
        String user = "root";
        String password = "01112003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }



    }
    public static void closeConnection(Connection connection) {// Hàm để đóng connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
