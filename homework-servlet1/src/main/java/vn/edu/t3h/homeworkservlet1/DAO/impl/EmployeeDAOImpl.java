package vn.edu.t3h.homeworkservlet1.DAO.impl;

import vn.edu.t3h.homeworkservlet1.DAO.EmployeeDAO;
import vn.edu.t3h.homeworkservlet1.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> getAllEmployees() {
        String sql = "select e.employee_id, e.name, e.position, e.salary, d.department_name, e.hire_date from employees e inner join departments d" +
                " on e.department_id = d.department_id";
        Connection connection = null;
        List<Employee> employeeResult = new ArrayList<>();
        try{
        connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("employee_id"));
            employee.setName(resultSet.getString("name"));
            employee.setPosition(resultSet.getString("position"));
            employee.setSalary(resultSet.getDouble("salary"));
            employee.setDepartmentName(resultSet.getString("department_name"));
            employee.setHireDate(resultSet.getString("hire_date"));
            employeeResult.add(employee);
        }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return employeeResult;
    }

    @Override
    public int insertEmployee(Employee employee) {
        int employeeId = 0;
        String sql = "INSERT INTO employees (name, salary, position, department_id, hire_date) " +
                "VALUES (?, ?, ?, ?, ?)";
        Connection connection = null;

        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setDouble(2, employee.getSalary());
            preparedStatement.setString(3, employee.getPosition());
            preparedStatement.setInt(4, employee.getDepartmentId());
            preparedStatement.setString(5, employee.getHireDate());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return employeeId;
    }

    @Override
    public List<Employee> findByCondition(String name, String salary, String fromDate, String toDate, String position) {
        String sql = "SELECT e.employee_id, e.name, e.position, e.salary, d.department_name, e.hire_date\n" +
                "FROM employees e\n" +
                "         LEFT JOIN departments d ON e.department_id = d.department_id\n" +
                "WHERE (e.name LIKE ? OR ? IS NULL)\n" +
                "  AND (e.salary = ? OR ? IS NULL)\n" +
                "  AND (e.hire_date >= ? or ? is NULL)\n" +
                "  AND (e.hire_date <= ? or ? is NULL)\n" +
                "  AND (e.position LIKE ? OR ? IS NULL)\n;";
        Connection connection = null;
        List<Employee> employeeResult = new ArrayList<>();
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            setConditionFilter(name, salary, fromDate, toDate, position, preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepartmentName(resultSet.getString("department_name"));
                employee.setHireDate(resultSet.getString("hire_date"));
                employeeResult.add(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return employeeResult;
    }

    @Override
    public int deleteEmployeeById(int id) {
        int employeeId = 0;
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            employeeId = preparedStatement.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return employeeId;
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "SELECT  e.employee_id, e.name, e.position, e.salary, e.department_id, e.hire_date" +
                " FROM employees e WHERE employee_id = ?";
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("employee_id"));
                employee.setName(resultSet.getString("name"));
                employee.setPosition(resultSet.getString("position"));
                employee.setSalary(resultSet.getDouble("salary"));
                employee.setDepartmentName(resultSet.getString("department_id"));
                employee.setHireDate(resultSet.getString("hire_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return employee;
    }

    @Override
    public int updateEmployee(Employee employee) {
        int affectedRows = 0;
        String sql = "UPDATE employees SET name = ?, position = ?, salary = ?, department_id = ?, hire_date = ? \n" +
                "                      WHERE employee_id = ?";
        Connection connection = null;
        try{
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getPosition());
            preparedStatement.setDouble(3, employee.getSalary());
            preparedStatement.setInt(4, employee.getDepartmentId());
            preparedStatement.setString(5, employee.getHireDate());
            preparedStatement.setInt(6, employee.getId());
            affectedRows = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return affectedRows;
    }

    private static void setConditionFilter(String name, String salary, String fromDate, String toDate, String position, PreparedStatement preparedStatement) throws SQLException {
        if(name != null){
            preparedStatement.setString(1,"%"+ name +"%");
            preparedStatement.setString(2,"%"+ name +"%");
        }else {
            preparedStatement.setNull(1, Types.VARCHAR);
            preparedStatement.setNull(2, Types.VARCHAR);
        }
        if(salary != null){
            preparedStatement.setLong(3,Long.parseLong(salary));
            preparedStatement.setLong(4,Long.parseLong(salary));
        }else {
            preparedStatement.setNull(3, Types.DECIMAL);
            preparedStatement.setNull(4, Types.DECIMAL);
        }
        if(fromDate != null){
            preparedStatement.setString(5, fromDate);
            preparedStatement.setString(6, fromDate);
        }else {
            preparedStatement.setNull(5, Types.VARCHAR);
            preparedStatement.setNull(6, Types.VARCHAR);
        }
        if(toDate != null){
            preparedStatement.setString(7, toDate);
            preparedStatement.setString(8, toDate);
        }else {
            preparedStatement.setNull(7, Types.VARCHAR);
            preparedStatement.setNull(8, Types.VARCHAR);
        }
        if(position != null){
            preparedStatement.setString(9,"%"+ position +"%");
            preparedStatement.setString(10,"%"+ position +"%");
        }else {
            preparedStatement.setNull(9, Types.VARCHAR);
            preparedStatement.setNull(10, Types.VARCHAR);
        }
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3307/quanlynhansu";
        String user = "root";
        String password = "01112003";
        try{
            Class.forName("com.mysql.jdbc.Driver");
           Connection connection = DriverManager.getConnection(url, user, password);
           return connection;
        }catch (ClassNotFoundException|SQLException e) {
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
