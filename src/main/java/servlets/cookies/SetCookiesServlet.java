package servlets.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("id", "6345");
        cookie1.setMaxAge(60 * 60);

        Cookie cookie2 = new Cookie("name", "WebApplication2020");
        cookie2.setMaxAge(24 * 60 * 60);

        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
    }
}
