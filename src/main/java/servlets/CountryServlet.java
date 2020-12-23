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

        try {
//            StringBuilder sb = new StringBuilder();
//            BufferedReader reader = req.getReader();
//            try {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    sb.append(line).append('\n');
//                }
//            } finally {
//                reader.close();
//            }
//            System.out.println(sb.toString());
//            Country country = objectMapper.readValue(sb.toString(), Country.class);
            String json = req.getParameter("json");
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            Country country = objectMapper.readValue(json, Country.class);
        if (req.getParameter("actionT").equals("put"))
        {
            new CountryDaoImpl().putCountry(country);
        }else if(req.getParameter("actionT").equals("update"))
        {
            new CountryDaoImpl().updateCountry(country);
        }

        } catch(Exception e) {
            e.printStackTrace();
        }
//            int id = Integer.parseInt(req.getParameter("id"));
//            String name = req.getParameter("name");
//            List<Region> regions = null;
//            List<Person> people = null;
//        Country country = new Country(id, name, regions, people);
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
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(json);
        out.flush();
//curl -X POST -d "json={\"id\":\"3\",\"name\":\"UK\",\"regions\":null,\"people\":null}&login=admin&pwd=admin&actionT=put" http://localhost:8079/PeopleApi_war/country
//curl -v -H "Content-Type: application/json" -X POST -d '{"id":"3","name":"UK","regions":null,"people":null}' http://localhost:8079/PeopleApi_war/country
//curl -X POST http://localhost:8079/PeopleApi_war/country -H "Content-Type: application/json" -d '{"id":"3","name":"UK","regions":null,"people":null}'
    }
}
