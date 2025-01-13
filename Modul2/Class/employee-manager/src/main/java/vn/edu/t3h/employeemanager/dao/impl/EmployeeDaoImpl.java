package vn.edu.t3h.employeemanager.dao.impl;


import vn.edu.t3h.employeemanager.dao.EmployeeDao;
import vn.edu.t3h.employeemanager.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getAllEmployees() {
//        + Tạo connection đến db
            Connection connection = getConnection();
            List<Employee> employeesResult = new ArrayList<>();
//        + Tạo câu query
        String sql = "SELECT * From employees e inner join " +
                "departments d on e.department_id = d.department_id;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
//       + Thực thi câu query
            ResultSet resultSet = statement.executeQuery();
//        + Lấy ra dữ liệu từ câu query đưa vào object java
//            Để lấy ra dữ liệu ta dùng vòng lặp while
            while (resultSet.next()) { // .next là nếu có data
            Employee employee = new Employee();
            employee.setEmployeeId(resultSet.getInt("employee_id"));
            employee.setName(resultSet.getString("name"));
            employee.setPosition(resultSet.getString("position"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setDepartment(resultSet.getString("department_name"));
            employee.setHireDate(resultSet.getString("hire_date"));
//          Sau khi lấy ra được toàn bộ thông tin thì phải add vào List employee đó
//          thì dữ liệu mới trả về được
            employeesResult.add(employee);
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
//        + Trả về kết quả là danh sách employee

        return employeesResult;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/quanlynhansur";
        String username = "root";
        String password = "01112003";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("get connection success");
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
//PreparedStatement preparedStatement = connection.prepareStatement(sql);
//trong Java được sử dụng để tạo một đối tượng PreparedStatement,
//cho phép thực hiện các câu lệnh SQL an toàn và hiệu quả hơn.
//connection: Là đối tượng Connection mà bạn đã tạo trước đó, kết nối đến cơ sở dữ liệu.
//sql: Là chuỗi chứa câu lệnh SQL mà bạn muốn thực hiện, có thể bao gồm các tham
// số được đánh dấu bằng dấu hỏi (?).


//ResultSet: Là một giao diện trong Java JDBC đại diện cho tập hợp
// các kết quả của một câu lệnh SQL truy vấn. Nó cho phép bạn duyệt qua
// các hàng dữ liệu mà câu lệnh truy vấn trả về.


//statement.executeQuery():
//statement: Là đối tượng Statement hoặc PreparedStatement mà bạn đã tạo trước
// đó để thực hiện câu lệnh SQL.
//executeQuery(): Là phương thức được gọi để thực hiện câu lệnh SQL
// kiểu SELECT và trả về một đối tượng ResultSet.



//Truyền các biến đã khởi tạo ở trên vào đây
//            DriverManager: Là một lớp trong Java cung cấp phương thức
//            để quản lý các driver JDBC (Java Database Connectivity).
//            Nó cho phép bạn lấy một kết nối đến cơ sở dữ liệu.
