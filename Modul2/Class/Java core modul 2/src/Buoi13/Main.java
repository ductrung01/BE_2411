package Buoi13;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static final String url = "jdbc:mysql://localhost:3307/quanlyduan";
    public static final String user = "root";
    public static final String password = "01112003";

    public static void main(String[] args) {
        //Taoj connection den dataabase
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database");

        } catch (SQLException e) {
            System.out.println("Connection error");
            throw new RuntimeException(e);
        }finally {
            // đóng connection sau khi thực thi thành công, quan trọng!
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}