package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.PhotosPersonDao;
import dao.PhotosPersonDaoImpl;
import model.PhotosPerson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PhotosPersonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String json = req.getParameter("json");
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(json);
            PhotosPerson photosPerson = objectMapper.readValue(json, PhotosPerson.class);
            if (req.getParameter("actionT").equals("put"))
            {
                new PhotosPersonDaoImpl().putPhotosPerson(photosPerson);
            }else if(req.getParameter("actionT").equals("update"))
            {
                new PhotosPersonDaoImpl().updatePhotosPerson(photosPerson);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhotosPersonDao photosPersonDao = new PhotosPersonDaoImpl();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        String sid = req.getParameter("id");
        try {
            if (sid != null)
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(photosPersonDao.getPhotosPersonById(Integer.parseInt(sid)));
            else
                json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(photosPersonDao.getAllPhotosPerson());
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
