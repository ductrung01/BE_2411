package vn.edu.t3h.homeworkservlet1.DAO;

import vn.edu.t3h.homeworkservlet1.model.UserModel;

public interface UserDAO {
    UserModel findUserByUserNameAndPassword(String username, String password);
    // ở day la tim kiem theo username va password roi tra ve 1 doi tuong usserModel
}
