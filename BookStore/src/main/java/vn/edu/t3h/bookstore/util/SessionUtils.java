package vn.edu.t3h.bookstore.util;

import jakarta.servlet.http.HttpServletRequest;

public class SessionUtils {

    public static final String SESSION_ID_CURRENT_USER = "SESSION_ID_CURRENT_USER";

    public static void putValue(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    public static Object getValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public static void removeValue(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);
    }
}
