package servlets.cookies;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.CollationKey;

public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        Cookie[] cookies = req.getCookies();
        pw.println("<html>");
        for (Cookie c: cookies) {
            pw.println("<p>" + c.getName() + " : " + c.getValue() + "</p>");
        }
        pw.println("</html>");
    }
}
