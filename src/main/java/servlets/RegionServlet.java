package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.RegionDao;
import dao.RegionDaoImpl;
import model.Region;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String json = req.getParameter("json");
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            Region region = objectMapper.readValue(json, Region.class);
            if (req.getParameter("actionT").equals("put"))
            {
                new RegionDaoImpl().putRegion(region);
            }else if(req.getParameter("actionT").equals("update"))
            {
                new RegionDaoImpl().updateRegion(region);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegionDao regionDao = new RegionDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        String sid = req.getParameter("id");
        try {
            if (sid != null)
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(regionDao.getRegionById(Integer.parseInt(sid)));
            else
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(regionDao.getAllRegion());
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
