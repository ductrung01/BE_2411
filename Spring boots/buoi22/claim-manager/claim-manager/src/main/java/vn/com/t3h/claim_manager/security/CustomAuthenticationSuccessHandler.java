package vn.com.t3h.claim_manager.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.service.LoginService;
import vn.com.t3h.claim_manager.utils.Constant;
import vn.com.t3h.claim_manager.utils.Constant.JWT;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
@Autowired
private JwtService jwtService;
@Autowired
  private LoginService loginService;
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authentication) throws IOException, ServletException {
    AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain,
        authentication);
  }
/*
Xuwr ly logic sau khi login thanh cong
+ Tao ra token jwt
+ ghi token vao cookie
+ Dieu huong ve page theo role
*/
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
// Tao token
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    String jwt = jwtService.generateToken(userDetails);
//    Tao ra cookie, them token vao cookie
    Cookie jwtCookie = new Cookie(JWT.JWT.name(), jwt);
    jwtCookie.setPath("/");
    jwtCookie.setHttpOnly(true);// chi cho phep trinh duyet truy cap, khong cho phep js cua trinh duyet truy cap vao va su dung
    jwtCookie.setSecure(true);// Su dung https
//    jwtCookie.setDomain("localhost:8080"); // chi cho pheps domain gui di tu domain
    jwtCookie.setMaxAge(24 * 60 * 60);// 1 ngay thoi gian toi da de cookie song
//    set cookie cho respond
    response.addCookie(jwtCookie);
//    Lay ra url de dieu huong url theo role
    String urlRedirect = loginService.processAfterLoginSuccess();
    response.sendRedirect(urlRedirect);
  }
}
