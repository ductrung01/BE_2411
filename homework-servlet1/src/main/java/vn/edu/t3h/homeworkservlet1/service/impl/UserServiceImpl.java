package vn.edu.t3h.homeworkservlet1.service.impl;

import vn.edu.t3h.homeworkservlet1.DAO.RoleDAO;
import vn.edu.t3h.homeworkservlet1.DAO.UserDAO;
import vn.edu.t3h.homeworkservlet1.model.RoleModel;
import vn.edu.t3h.homeworkservlet1.model.UserModel;
import vn.edu.t3h.homeworkservlet1.service.UserService;
import vn.edu.t3h.homeworkservlet1.util.Constans;
import vn.edu.t3h.homeworkservlet1.util.PasswordUntils;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }
    @Override
    public String login(String username, String password) {
        String passwordEncrypted = PasswordUntils.encryptPassword(password); // Mã hóa mật khẩu
        // Khởi tạo ra biến password đã được mã hóa
        UserModel user = userDAO.findUserByUserNameAndPassword(username, passwordEncrypted);
        String urlRedirect = "";

        if (user == null) {
            urlRedirect = "/login?message=" + Constans.LOGIN_ERROR; // Đường dẫn nếu không tìm thấy người dùng
            return urlRedirect;
        }

        RoleModel roleModel = roleDAO.findRoleById(user.getRoleId()); // Tìm kiếm vai trò của người dùng
        if (roleModel == null) {
            urlRedirect = "/login?message=" + Constans.PERMISSION_DENIED; // Đường dẫn nếu không tìm thấy vai trò
        } else {
            // Kiểm tra vai trò của người dùng
            if (roleModel.getCode().equals(Constans.ROLE.ROLE_ADMIN)) {
                urlRedirect = "/cms/employee"; // Đường dẫn cho quản trị viên
            } else {
                urlRedirect = "/home"; // Đường dẫn cho người dùng thông thường
            }
        }

        return urlRedirect; // Trả về đường dẫn để điều hướng
    }

}
