package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");

        PrintWriter pw = resp.getWriter();
        pw.println("<html>\n" +
                "    <body>\n" +
                "        <h1>Hello, " + name + " (" + login + ")</h1>\n" +
                "    </body>\n" +
                "</html>");
    }
}
