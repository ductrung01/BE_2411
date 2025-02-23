package vn.edu.t3h.bookstore.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import vn.edu.t3h.bookstore.dao.RoleDAO;
import vn.edu.t3h.bookstore.dao.UserDAO;
import vn.edu.t3h.bookstore.model.RoleModel;
import vn.edu.t3h.bookstore.model.UserModel;
import vn.edu.t3h.bookstore.service.UserService;
import vn.edu.t3h.bookstore.util.Constans;
import vn.edu.t3h.bookstore.util.PasswordUtils;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    private RoleDAO roleDAO;

    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public String login(String username, String password, HttpServletRequest request) {
        String passwordEncrypted = PasswordUtils.encryptPassword(password); // Mã hóa mật khẩu
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
            return urlRedirect;
        }
        request.getSession().setAttribute(Constans.SESSION_ID_CURRENT_USER ,user);
        // Kiểm tra vai trò của người dùng
        if (roleModel.getCode().equals(Constans.ROLE.ROLE_ADMIN.name())) { //.name lchuyeeryen doi hang so thanh dang chuoi
            urlRedirect = "/cms/admin-manager";
        } else {
            urlRedirect = "/";
        }
        return urlRedirect; // Trả về đường dẫn để điều hướng

    }


}
