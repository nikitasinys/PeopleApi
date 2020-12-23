package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.TownDao;
import dao.TownDaoImpl;
import model.Town;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TownServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String json = req.getParameter("json");
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            Town town = objectMapper.readValue(json, Town.class);
            if (req.getParameter("actionT").equals("put"))
            {
                new TownDaoImpl().putTown(town);
            }else if(req.getParameter("actionT").equals("update"))
            {
                new TownDaoImpl().updateTown(town);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TownDao townDao = new TownDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        String sid = req.getParameter("id");
        try {
            if (sid != null)
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(townDao.getTownById(Integer.parseInt(sid)));
            else
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(townDao.getAllTown());
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
