package servlets;

import dao.SubjectDaoImpl;
import model.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CourseSaveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit") != null) {
            String title = req.getParameter("course");
            int lecturerId = Integer.parseInt(req.getParameter("lecturer"));
            int credit = Integer.parseInt(req.getParameter("credit"));
            Subject subject = new Subject(0, title, lecturerId, credit);
            new SubjectDaoImpl().saveSubject(subject);
        }
        resp.sendRedirect("/courses");
    }
}
