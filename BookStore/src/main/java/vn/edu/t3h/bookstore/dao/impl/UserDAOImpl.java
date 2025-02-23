package vn.edu.t3h.bookstore.dao.impl;



import vn.edu.t3h.bookstore.dao.UserDAO;
import vn.edu.t3h.bookstore.model.UserModel;
import vn.edu.t3h.bookstore.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {

    // Phương thức tìm người dùng theo tên đăng nhập và mật khẩu
    public UserModel findUserByUserNameAndPassword(String username, String password) {
        UserModel userModel = null;
        String sql = "SELECT u.id, u.username, u.password, u.fullname, u.email, u.phoneNumber, u.gender, u.address, u.role_id, r.name AS role_name " +
                "FROM user u " +
                "JOIN role r ON u.role_id = r.id " +
                "WHERE u.username = ? AND u.password = ?";


        // nếu viết trong try thì connection sẽ tự động được close, áp dụng cho version jdbc  moi
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, username); // Set tên đăng nhập
            preparedStatement.setString(2, password); // Set mật khẩu
            // tuong tu connection
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Lấy dữ liệu từ kết quả truy vấn và gán vào đối tượng UserModel
                    Integer id = resultSet.getInt("id");
                    String fullName = resultSet.getString("fullname"); // sửa từ full_name thành fullname
                    String email = resultSet.getString("email"); // thêm email
                    String phone = resultSet.getString("phoneNumber"); // thêm phone
                    String gender = resultSet.getString("gender"); // thêm gender
                    String address = resultSet.getString("address"); // thêm address
                    Integer roleId = resultSet.getInt("role_id");

                    // Tạo đối tượng UserModel từ dữ liệu truy vấn
                    userModel = new UserModel(id, username, password, fullName, email, phone, gender, address, roleId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userModel;
    }


}