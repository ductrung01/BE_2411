package vn.com.t3h.claim_manager.service.impl;



import static vn.com.t3h.claim_manager.utils.SessionUtils.getUserPrinciple;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.List;

import vn.com.t3h.claim_manager.service.LoginService;
import vn.com.t3h.claim_manager.utils.Constant;
import vn.com.t3h.claim_manager.utils.SessionUtils;

@Service
public class LoginServiceImpl implements LoginService {

  public String processAfterLoginSuccess(){

    UserDetails userDetails = SessionUtils.getUserPrinciple();
    System.out.println(String.format("User %s logged in", userDetails.getUsername()));
    // lấy ra danh sách quyền của user
    List<String> roleCode = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    System.out.println(String.format("Role code: %s", roleCode));
    // kiểm tra xem có phải admin không
    boolean isAdmin = roleCode.contains(Constant.PREFIX_ROLE + Constant.ROLE_ADMIN_CODE);
//   save username to session

    if(isAdmin){
      return "/cms/dashboard"; // role admin
    }
    return "/home"; // role user
  }


}
