package vn.com.t3h.claim_manager.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.com.t3h.claim_manager.security.JwtService;
import vn.com.t3h.claim_manager.utils.Constant;
import vn.com.t3h.claim_manager.utils.Constant.JWT;


@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private JwtService jwtService;

  private String[] urlIgnore = {"/process_login", "/logout", "/home", "/login"};

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    /*
     bỏ qua các url login, process-login,logout,home
	     bỏ qua vì đây là các url không cần authen
     * */
    boolean ignore = false;
    for (String url : urlIgnore) {
      if (request.getRequestURI().contains(url)) {
        ignore = true;
        break;
      }
    }
    if (ignore) {
      filterChain.doFilter(request, response);
      return;
    }
    /*
    * Lay ra token tu cookie đẻ kiem tra
    * */
    String tokenJwt = null;
    Cookie [] cookies = request.getCookies();
    if (cookies == null) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No cookies");
      return;
    }

    for (Cookie cookie : cookies) {
      if (JWT.JWT.name().equals(cookie.getName())) {
        tokenJwt = cookie.getValue();
        break;
      }
    }

    if (!StringUtils.hasText(tokenJwt) || !jwtService.validateToken(tokenJwt)) {
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");

    }
    System.out.println("Token in cookie: " + tokenJwt);
    System.out.println("Token valid: " + jwtService.validateToken(tokenJwt));


//    token hop le => cho qua den tang rest controller hoac tang controller
    filterChain.doFilter(request, response);
  }
}
