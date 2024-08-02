package io.wisoft.CookieSession;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/cookie")
public class HelloCookie extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = new Cookie("name", "TEST");
        cookie.setMaxAge(3000);
        response.addCookie(cookie);
    }
}
