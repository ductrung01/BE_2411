package vn.edu.t3h.homeworkservlet1.service;

import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    public String login(String username, String password, HttpServletRequest request);
}
