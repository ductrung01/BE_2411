package vn.edu.t3h.homeworkservlet1.DAO.impl;

import vn.edu.t3h.homeworkservlet1.DAO.RoleDAO;
import vn.edu.t3h.homeworkservlet1.model.RoleModel;
import vn.edu.t3h.homeworkservlet1.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAO {

    public RoleModel findRoleById(Integer roleId) {
        RoleModel role = null;
        String sql = "SELECT id, name, code FROM role WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, roleId); // Set roleId

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy dữ liệu từ kết quả truy vấn và gán vào đối tượng Role
                    Integer id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String code = resultSet.getString("code");

                    // Tạo đối tượng Role từ dữ liệu truy vấn
                    role = new RoleModel(id, name, code);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }
}