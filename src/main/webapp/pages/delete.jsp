<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.sql.*" %>

<%
    Integer id = Integer.valueOf(request.getParameter("id"));
    Connection connection;
    PreparedStatement pst;
    ResultSet resultSet;

    try {
        Class.forName("org.postgresql.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webdb", "postgres", "postgres");
        pst = connection.prepareStatement("delete from subjects where id = ?");
        pst.setInt(1, id);
        pst.executeUpdate();
        connection.close();

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    response.sendRedirect("/courses");
%>

<html>
<body>

</body>
</html>
