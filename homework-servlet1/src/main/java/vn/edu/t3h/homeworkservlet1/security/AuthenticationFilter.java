//package vn.edu.t3h.homeworkservlet1.security;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import vn.edu.t3h.homeworkservlet1.DAO.RoleDAO;
//import vn.edu.t3h.homeworkservlet1.DAO.UserDAO;
//import vn.edu.t3h.homeworkservlet1.DAO.impl.RoleDAOImpl;
//import vn.edu.t3h.homeworkservlet1.model.RoleModel;
//import vn.edu.t3h.homeworkservlet1.model.UserModel;
//import vn.edu.t3h.homeworkservlet1.service.RoleService;
//import vn.edu.t3h.homeworkservlet1.service.impl.RoleServiceImpl;
//import vn.edu.t3h.homeworkservlet1.util.Constans;
////@WebFilter: Đánh  class này là 1 Filter của Servlet
////    /*: regex để bắt tất cả request  đều phải đi qua Filter này trước khi vào được Servlet
//import java.io.IOException;
//@WebFilter("/*")
//public class AuthenticationFilter implements Filter {
//    private RoleService roleService;
//    public AuthenticationFilter(RoleService roleService) {
//        // invert of controll(IOC)
//        RoleDAO roleDAO = new RoleDAOImpl();
//        this.roleService = new RoleServiceImpl( roleDAO);
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        String url = request.getRequestURI();
//        /*
//        /cms : user muon truy cap vao cms
//        */
//        String urlRedirect = "";
//        if (url.startsWith("/cms")) {
//            UserModel currentUser = (UserModel) request.getSession().getAttribute(Constans.SESSION_ID_CURRENT_USER);
//            if (currentUser != null) {
//                response.sendRedirect("/login?message"+Constans.DONT_LOGIN);
//            }else{
//                // Kiem tra role cua currentUser co phai la role admin hay ko
//                RoleModel roleCurrentUser = roleService.getRoleById(currentUser.getRoleId());
//                if(!roleCurrentUser.getCode().equals(Constans.ROLE.ROLE_ADMIN.name())){
//                    response.sendRedirect("/login?message"+Constans.PERMISSION_DENIED);
//                }else{
//                    filterChain.doFilter(request, response);
//                }
//            }
//
//        }else{
//            filterChain.doFilter(request, response);
//        }
//
//
//    }
//
//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
//}
package vn.edu.t3h.homeworkservlet1.security;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.t3h.homeworkservlet1.DAO.RoleDAO;
import vn.edu.t3h.homeworkservlet1.DAO.UserDAO;
import vn.edu.t3h.homeworkservlet1.DAO.impl.RoleDAOImpl;
import vn.edu.t3h.homeworkservlet1.model.RoleModel;
import vn.edu.t3h.homeworkservlet1.model.UserModel;
import vn.edu.t3h.homeworkservlet1.service.RoleService;
import vn.edu.t3h.homeworkservlet1.service.impl.RoleServiceImpl;
import vn.edu.t3h.homeworkservlet1.util.Constans;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    private RoleService roleService;

    public AuthenticationFilter() {
        RoleDAO roleDAO = new RoleDAOImpl();
        this.roleService = new RoleServiceImpl(roleDAO);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic if needed
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURI();

        if (url.startsWith("/cms")) {
            UserModel currentUser = (UserModel) request.getSession().getAttribute(Constans.SESSION_ID_CURRENT_USER);
            if (currentUser == null) {
                response.sendRedirect("/login?message=" + Constans.DONT_LOGIN);
                return; // Ngưng xử lý tiếp
            } else {
                // Kiểm tra vai trò của currentUser
                RoleModel roleCurrentUser = roleService.getRoleById(currentUser.getRoleId());
                if (!roleCurrentUser.getCode().equals(Constans.ROLE.ROLE_ADMIN.name())) {
                    response.sendRedirect("/login?message=" + Constans.PERMISSION_DENIED);
                    return; // Ngưng xử lý tiếp
                }
            }
        }
        // Nếu tất cả điều kiện đều ổn, tiếp tục xử lý request
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup logic if needed
    }
}
