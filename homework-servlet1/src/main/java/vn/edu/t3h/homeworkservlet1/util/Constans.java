package vn.edu.t3h.homeworkservlet1.util;

public class Constans {
    public static final String SESSION_ID_CURRENT_USER = "SESSION_ID_CURRENT_USER"; // đây sẽ là key của cái xóa session kia
    public static final String PERMISSION_DENIED = "permissionDenied";
    public static final String DONT_LOGIN = "dontLogin";
    public static final String LOGIN_SUCCESS = "loginSuccess";
    public static final String LOGIN_ERROR = "loginError";
    public static  enum ROLE{
        ROLE_ADMIN,ROLE_USER;
    }
    //enum là một kiểu dữ liệu đặc biệt trong Java, cho phép định nghĩa một
    // tập hợp các hằng số. Enum giúp tăng tính
    // rõ ràng và an toàn cho mã nguồn khi làm việc với các giá trị cố định
}
