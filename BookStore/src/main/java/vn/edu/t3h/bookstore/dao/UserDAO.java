package vn.edu.t3h.bookstore.dao;


import vn.edu.t3h.bookstore.model.UserModel;

public interface UserDAO {
    UserModel findUserByUserNameAndPassword(String username, String password);
}
