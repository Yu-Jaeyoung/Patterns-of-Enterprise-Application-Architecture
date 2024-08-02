package io.wisoft.CookieSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "/cookie-req")
public class HelloCookieReq extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        final Cookie[] cookies = request.getCookies();

        Map<String, String> result = new HashMap<>();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("name")) {
                result.put(cookie.getName(), cookie.getValue());
            }
        }

        System.out.println(result);

        response.setStatus(200);
    }
}
