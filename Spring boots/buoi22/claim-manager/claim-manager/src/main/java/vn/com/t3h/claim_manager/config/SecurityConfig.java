package vn.com.t3h.claim_manager.config;

import com.sun.tools.javac.Main;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import vn.com.t3h.claim_manager.security.CustomAuthenticationSuccessHandler;
import vn.com.t3h.claim_manager.security.JwtService;
import vn.com.t3h.claim_manager.security.filter.JwtAuthenticationFilter;
import vn.com.t3h.claim_manager.utils.Constant;
import vn.com.t3h.claim_manager.utils.Constant.JWT;

@Configuration
@EnableWebSecurity
//@EnableWebSecurity là một annotation (chú thích) trong Spring, được dùng để kích hoạt cơ chế bảo mật (security) của Spring Security trong ứng dụng web.
public class SecurityConfig {

  @Autowired
  private JwtAuthenticationFilter jwtAuthenticationFilter;
  //config cho spring security tiep nhan class customAuthenticationSuccessHandler
// xu ly sau khi login thanh cong
  @Autowired
  private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

  /*
  * PasswordEncoder sử dụng làm gì:?
		  1.Tạo Bean để spring security biết nên sử dụng  giải thuật nào để mã hóa password,
		    khi đó spring sẽ mã hóa password ở fontend với giải thuật này và so sánh giá trị
		    đã mã hóa ra xem có giống với password của userEntity trong database ko
  * */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /*
  SecurityFilterChain:
      - Là class config chính đảm nhận tất cả các
      config của spring security(túc là phải config hết trong th này )
  */
  @Bean
  public SecurityFilterChain configure(HttpSecurity http, View error,
      HandlerMappingIntrospector mvcHandlerMappingIntrospector) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(request -> { // config các request
          request.requestMatchers("/cms/**").hasAnyRole(
                  "ADMIN") // tất cả các đường đãn bắt từ từ /cms/ đều phải có role ADMIN mới được truy cập vào
              .requestMatchers("/", "/home", "/login", "/logout", "/process_login")
              .permitAll()// tất cả các đường dẫn này có thể truy cạp mà không càn login
              .requestMatchers(
                  "/assets/**", "/fonts/**", "/homeguest_files/**",
                  "/js/**", "/libs/**", "/loginmetlife/**",
                  "/page404/**", "/scss/**", "/tasks/**", "/css/**", "/images/**", "/cms-rs/**",
                  "/file/**").permitAll()
              .requestMatchers("/resource/**").permitAll()
              .requestMatchers("/kaira/**").permitAll()
              .anyRequest().authenticated();
        })
        .formLogin(// custom form login ko su dung form login mac dinh cua spring security
            form ->
                form.loginPage("/login")// page login duoc custom
                    .loginProcessingUrl("/process_login")//  url de view gui username, password len cho server, config tai form login o page login
                    .successHandler(customAuthenticationSuccessHandler) //		Tức là config xử lý trong class này customAuthenticationSuccessHandler khi login thành công
//                    .defaultSuccessUrl("/process-after-login-susscess",
//                        true)///process-after-login-susscess URL duoc dieu huong den khi login thanh cong, su dung de xu ly tu dong dieu huong login page theo role, vi du : admin -> cms/home , user -> /home
                    .failureUrl("/login?error=true")
        )
        .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .deleteCookies(JWT.JWT.name()) // xoa bo cookie nay sau khi da logout
            .permitAll());
//Chỗ này để thằng spring security bắt buộc chạy qua tầng filter này trước khi đến controller
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();

  }

  public static void main(String[] args) {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    System.out.println("password admin:" + passwordEncoder.encode("admin"));
    System.out.println("password user:" + passwordEncoder.encode("user"));
    System.out.println("secretKey:" + generateSafeToken());
  }

  private static String generateSafeToken() {
    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    return java.util.Base64.getEncoder().encodeToString(key.getEncoded());
  }
}