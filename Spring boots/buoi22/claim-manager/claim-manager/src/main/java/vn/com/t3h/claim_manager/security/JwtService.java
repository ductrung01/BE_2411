//package vn.com.t3h.claim_manager.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.HashMap;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import vn.com.t3h.claim_manager.utils.Constant;
//import vn.com.t3h.claim_manager.utils.Constant.JWT;
//
//@Component // danh dau component de tao bean
//public class JwtService {
//
//  @Value("${authen.jwt.secretkey}")
//  private String secretKey;
//  @Value("${authen.jwt.time.exprie}")
//  private String timeExpire; //1 ngay
//
//  /*
//   method create token by
//         + user info
//         + secret key
//         + time exprire
//      userDetails in spring security
//         + have username
//         + all role of spring security
//   */
//  public String generateToken(UserDetails userDetails) {
//    /*
//     have all data user
//        - username
//        - roles
//     */
//    Map<String, Object> mapDataPayload = new HashMap<>();
////   get roles
//    List<String> roles = userDetails.getAuthorities()
//        .stream()
//        .map(GrantedAuthority::getAuthority)
//        .toList();
//    mapDataPayload.put(JWT.ROLES.name(), roles);
//    mapDataPayload.put(JWT.USERNAME.name(), userDetails.getUsername());
////    create jwt
//    String jwt = Jwts.builder()
//        .setClaims(mapDataPayload) // load data to payload
//        .setSubject(userDetails.getUsername())
//        .setIssuedAt(new Date(System.currentTimeMillis())) // time create token
//        .setExpiration(new Date(System.currentTimeMillis() + Long.valueOf(timeExpire)))// set time expire date curren time + timeExpire
//        .signWith(SignatureAlgorithm.HS256,secretKey) // sign with secretkey and Algorithm HS256
//        .compact();
//    return jwt;
//  }
//  public boolean validateToken(String token ) {
//    try {
//      Jwts.parser() // giải mã và xác thực token
//          .setSigningKey(secretKey) // cung cấp khóa bí mật để xác thực chữ ký
//          .parseClaimsJws(token); // phân tích token, trả về thông tin nếu hợp lệ
//
////     Neu giai ma duoc cai token nay ra thi token hop le con neu ko thi loi
//      return true;
//    }catch (Exception e){
//      return false;
//      // Token không hợp lệ (giả mạo, sai định dạng, hết hạn, v.v.)
//    }
//  }
//  public String getUsername(String token){
//    return Jwts.parser()                      // 1. Tạo đối tượng parser để phân tích JWT
//        .setSigningKey(secretKey)             // 2. Cung cấp khóa bí mật để xác minh chữ ký
//        .parseClaimsJws(token)                // 3. Giải mã và xác minh token
//        .getBody()                            // 4. Lấy phần "payload" (dữ liệu) trong token
//        .getSubject();                        // 5. Trả về giá trị của trường "sub" (thường là username)
//  }
//  public List<String> getRoles(String token){
//   Claims payload  = Jwts.parserBuilder()
//                         .setSigningKey(secretKey)
//                          .build()
//                          .parseClaimsJws(token)
//                          .getBody();
//    return payload.get(JWT.ROLES.name(), List.class);
//  }
//}
package vn.com.t3h.claim_manager.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import vn.com.t3h.claim_manager.utils.Constant.JWT;

@Component
public class JwtService {

  @Value("${authen.jwt.secretkey}")
  private String secretKey;

  @Value("${authen.jwt.time.exprie}")
  private String timeExpire; // Thời gian hết hạn

  public String generateToken(UserDetails userDetails) {
    Map<String, Object> mapDataPayload = new HashMap<>();
    List<String> roles = userDetails.getAuthorities()
        .stream()
        .map(GrantedAuthority::getAuthority)
        .toList();
    mapDataPayload.put(JWT.ROLES.name(), roles);
    mapDataPayload.put(JWT.USERNAME.name(), userDetails.getUsername());

    return Jwts.builder()
        .setClaims(mapDataPayload)
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(timeExpire)))
        .signWith(SignatureAlgorithm.HS256, secretKey)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser()
          .setSigningKey(secretKey)
          .parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false; // Token không hợp lệ
    }
  }

  public String getUsername(String token) {
    return Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }

  public List<String> getRoles(String token) {
    Claims payload = Jwts.parserBuilder()
        .setSigningKey(secretKey)
        .build()
        .parseClaimsJws(token)
        .getBody();
    return payload.get(JWT.ROLES.name(), List.class);
  }
}
