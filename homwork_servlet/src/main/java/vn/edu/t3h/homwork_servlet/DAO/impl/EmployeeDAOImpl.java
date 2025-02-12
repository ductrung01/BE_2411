package vn.edu.t3h.homwork_servlet.DAO.impl;

import vn.edu.t3h.homwork_servlet.DAO.EmployeeDAO;
import vn.edu.t3h.homwork_servlet.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployees() {
        Connection connection = getConnection();
        List<Employee> employeeResult = new ArrayList<Employee>();// Lưu kết quả truy vấn ở đây
        // Tạo ra câu query
        String sql = "SELECT * From employees e inner join " +
                "departments d on e.department_id = d.department_id;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setHireDate(resultSet.getString("hire_date"));
                employee.setDepartmentName(resultSet.getString("department_id"));
                employeeResult.add(employee);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            closeConnection(connection);
        }
        return employeeResult;
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
    public List<Employee> findByCondition(String name, String salary, String fromDate, String toDate, String positon){
        String sql = "SELECT e.employee_id, e.name, e.position, e.salary, d.department_name, e.hire_date\n" +
                "FROM employees e\n" +
                "         LEFT JOIN departments d ON e.department_id = d.department_id\n" +
                "WHERE (e.name LIKE ? OR ? IS NULL)\n" +
                "  AND (e.salary = ? OR ? IS NULL)\n" +
                "  AND (e.hire_date >= ? or ? is NULL)\n" +
                "  AND (e.hire_date <= ? or ? is NULL)\n" +
                "  AND (e.position LIKE ? OR ? IS NULL)\n;";
        Connection connection = null;
        List<Employee> employees = new ArrayList<>();
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setConditonFilter(name, salary, fromDate, toDate, positon, preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setHireDate(resultSet.getString("hire_date"));
                employee.setDepartmentName(resultSet.getString("department_name"));

                employees.add(employee);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return employees;
    }


    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, salary, position, department_id, hire_date) " +
                "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setString(4, employee.getDepartmentName());
            preparedStatement.setString(5, employee.getHireDate());
            preparedStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }

    private static void setConditonFilter(String name, String salary, String fromDate, String toDate, String positon, PreparedStatement preparedStatement) throws SQLException {
        if(name != null){
            preparedStatement.setString(1,"%"+ name +"%");
            preparedStatement.setString(2,"%"+ name +"%");
        }else{
            preparedStatement.setNull(1, Types.VARCHAR);
            preparedStatement.setNull(2, Types.VARCHAR);
        }
        if(salary != null){
            preparedStatement.setLong(3, Long.parseLong(salary));
            preparedStatement.setLong(4,Long.parseLong(salary));
        }else{
            preparedStatement.setNull(3, Types.DECIMAL);
            preparedStatement.setNull(4, Types.DECIMAL);
        }
        if(fromDate != null){
            preparedStatement.setString(5, fromDate);
            preparedStatement.setString(6, fromDate);
        }else{
            preparedStatement.setNull(5, Types.VARCHAR);
            preparedStatement.setNull(6, Types.VARCHAR);
        }
        if(toDate != null){
            preparedStatement.setString(7, toDate);
            preparedStatement.setString(8, toDate);
        }else{
            preparedStatement.setNull(7, Types.VARCHAR);
            preparedStatement.setNull(8, Types.VARCHAR);
        }
        if(positon != null){
            preparedStatement.setString(9,"%"+ positon +"%");// có dấu % là sẽ kiểu tìm kiếm theo line
            preparedStatement.setString(10,"%"+ positon +"%");
        }else{
            preparedStatement.setNull(9, Types.VARCHAR);
            preparedStatement.setNull(10, Types.VARCHAR);
        }
    }

    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3307/quanlynhansu";
        String user = "root";
        String password = "01112003";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

}
