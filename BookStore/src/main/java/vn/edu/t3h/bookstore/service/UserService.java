package vn.edu.t3h.bookstore.service;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {
    public String login(String username, String password, HttpServletRequest request);
}
