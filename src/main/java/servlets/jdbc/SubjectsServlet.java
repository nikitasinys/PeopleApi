package servlets.jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class SubjectsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Properties connectionProperties = new Properties();

            connectionProperties.load(getServletContext().
                    getResourceAsStream(
                            "/WEB-INF/properties/db.properties"));

        try {
            Connection connection = DriverManager.getConnection(
                    connectionProperties.getProperty("url"),
                    connectionProperties.getProperty("user"),
                    connectionProperties.getProperty("password"));

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title from subjects");

            while (resultSet.next()) {
                pw.println(resultSet.getString("title"));
            }
            statement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
