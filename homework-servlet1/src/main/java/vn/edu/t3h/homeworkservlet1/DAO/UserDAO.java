package vn.edu.t3h.homeworkservlet1.DAO;

import vn.edu.t3h.homeworkservlet1.model.UserModel;

public interface UserDAO {
    UserModel findUserByUserNameAndPassword(String username, String password);
}
