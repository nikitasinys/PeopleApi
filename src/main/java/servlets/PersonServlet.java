package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PersonDao;
import dao.PersonDaoImpl;
import model.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String json = req.getParameter("json");
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            Person person = objectMapper.readValue(json, Person.class);
            if (req.getParameter("actionT").equals("put"))
            {
                new PersonDaoImpl().putPerson(person);
            }else if(req.getParameter("actionT").equals("update"))
            {
                new PersonDaoImpl().updatePerson(person);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonDao personDao = new PersonDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        String sid = req.getParameter("id");
        try {
            if (sid != null)
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDao.getPersonById(Integer.parseInt(sid)));
            else
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDao.getAllPerson());
            System.out.println(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}
