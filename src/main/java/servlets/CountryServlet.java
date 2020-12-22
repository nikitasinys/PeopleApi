package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CountryDao;
import dao.CountryDaoImpl;
import model.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class CountryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String json = req.getParameter("json");
//        System.out.println(json);
//        System.out.println(json);
        try {

        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } finally {
            reader.close();
        }
        System.out.println(sb.toString());
        Country country = objectMapper.readValue(sb.toString(), Country.class);
        new CountryDaoImpl().putCountry(country);

    } catch(Exception e) {
        e.printStackTrace();
    }
//            int id = Integer.parseInt(req.getParameter("id"));
//            String name = req.getParameter("name");
//            List<Region> regions = null;
//            List<Person> people = null;
//        Country country = new Country(id, name, regions, people);
//        if (req.getParameter("PostType").equals("put")) {
//        }else if(req.getParameter("PostType").equals("update"))
//        {
//            new CountryDaoImpl().updateCountry(country);
//        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SubjectDao subjectDao = new SubjectDaoImpl();
//        List<Subject> subjectList = subjectDao.listSubjects();
        CountryDao countryDao = new CountryDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        String sid = req.getParameter("id");
        try {
            if(sid != null)
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(countryDao.getCountryById(Integer.parseInt(sid)));
            else
            json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(countryDao.getAllCountry());
            System.out.println(json);
//            Country country2 = new Country();

        } catch(Exception e) {
            e.printStackTrace();
        }
//curl -v -H "Content-Type: application/json" -X POST -d '{"id":"3","name":"UK","regions":null,"people":null}' http://localhost:8079/PeopleApi_war/country
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
    }
}
