package vn.edu.t3h.employeemanager.dao.impl;

import vn.edu.t3h.employeemanager.dao.DepartmentDao;
import vn.edu.t3h.employeemanager.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {
@Override
public List<Department> getAllDepartments() {
    //        + Tạo connection đến db
    Connection connection = getConnection();
    List<Department> departmentResult = new ArrayList<>();

//        + Tạo câu query
    String sql = "select * from departments";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //        + Thực thi câu query
        ResultSet resultSet = preparedStatement.executeQuery();
//        + Lấy ra dữ liệu từ câu query đưa vào object java
        while (resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getInt("department_id"));
            department.setDepartmentName(resultSet.getString("department_name"));
            department.setLocation((resultSet.getString("location")));
            departmentResult.add(department);

        }
//        + Trả về kết quả là danh sách employee
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
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
