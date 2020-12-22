package servlets;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    private final int SPP = 3;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList;
        StudentDao studentDao = new StudentDaoImpl();
        int recordsCount = studentDao.getRecordsCount();
        int pages = recordsCount / SPP;
        if (recordsCount % SPP != 0)
            pages++;
        req.setAttribute("pages", pages);
        if (req.getParameter("page") != null) {
            int page = Integer.parseInt(req.getParameter("page"));
            studentList = studentDao.getPageStudents(page, SPP);
        } else {
            studentList = studentDao.getAllStudents();
        }
        req.setAttribute("studentList", studentList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/students.jsp");
        dispatcher.forward(req, resp);
    }
}
