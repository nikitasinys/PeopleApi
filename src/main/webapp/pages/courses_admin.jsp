<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="dao.SubjectDaoImpl" %>
<%@ page import="dao.LecturerDaoImpl" %>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="message"/>
<fmt:setLocale value="${cookie['lang'].value}" scope="application"/>

<html>
<head>
    <title><fmt:message key="site_title"/></title>

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">

    <style>
        @import "../styles/dropbox.css";
        @import "../bootstrap/css/bootstrap.css";
        @import "../bootstrap/css/bootstrap.min.css";
    </style>
</head>
<body>

<%
    request.setAttribute("listLecturers", new LecturerDaoImpl().listNames());
    request.setAttribute("listCourses", new SubjectDaoImpl().listSubjects());
%>

<div style="padding: 20px">

    <h1><fmt:message key="site_title"/></h1>
    <div class="row">
        <div class="col-sm-4">
            <form method="post" action="/user/save">
                </br>
                <div align="left">
                    <label class="form-label"><fmt:message key="title"/></label>
                    <input type="text" class="form-control" placeholder=
                    <fmt:message key="entity.title"/> name="course" id="course"
                           required>
                </div>
                <div align="left">
                    <label class="form-label"><fmt:message key="entity.lecturer"/></label>

                    <select class="form-control" name="lecturer" id="lecturer" required>
                        <c:forEach items="${listLecturers}" var="lecturer">
                            <option value="${lecturer.key}">${lecturer.value}</option>
                        </c:forEach>
                    </select>

                </div>
                <div align="left">
                    <label class="form-label"><fmt:message key="entity.credits"/></label>
                    <input type="number" class="form-control" placeholder=
                    <fmt:message key="entity.credits"/> name="credit" id="credit" required>
                </div>
                </br>
                <div align="rigth">
                    <input type="submit" id="submit" value=
                    <fmt:message key="button.submit"/> name="submit" class="btn btn-info">
                    <input type="reset" id="reset" value=
                    <fmt:message key="button.cancel"/> name="reset" class="btn btn-warning">
                </div>
            </form>
        </div>

        <div class="col-sm-8">
            <div class="panel-body">
                <table id="tbl-subjects" class="table table-responsive table-bordered" cellpadding="0" width="100%">
                    <thead>
                    <tr>
                        <th><fmt:message key="entity.title"/></th>
                        <th><fmt:message key="entity.lecturer"/></th>
                        <th><fmt:message key="entity.credits"/></th>
                        <th><fmt:message key="data.edit"/></th>
                        <th><fmt:message key="data.delete"/></th>
                    </tr>

                    <c:forEach items="${listCourses}" var="subject">
                    <tr>
                        <td>${subject.title}</td>
                        <td>${subject.lecturer}</td>
                        <td align="center">${subject.credits}</td>
                        <td align="center"><a href="/user/update?id=${subject.id}"><img
                                src="../images/edit.png" alt="Edit" width="24"></a></td>
                        <td align="center"><a href="/delete?id=${subject.id}"><img
                                src="../images/delete.png" alt="Delete" width="24"></a></td>
                    </tr>

                    </c:forEach>

                </table>
            </div>
        </div>
    </div>
</div>

<div>
    <h5>
        <fmt:message key="cookie.ChooseLocale"/>
    </h5>
    <ul>
        <li><a href="confirm?cookieLocale=en_US"><fmt:message key="lang.en"/></a></li>
        <li><a href="confirm?cookieLocale=uk_UA"><fmt:message key="lang.ua"/></a></li>
        <li><a href="confirm?cookieLocale=de_DE"><fmt:message key="lang.de"/></a></li>
    </ul>
</div>

<div id="report_div">
    <p><a href="/getPdfFile" target="_blank">Get report in PDF</a></p>
    <p><a href="/downloadJson">Отримати звіт-файл у форматі JSON</a></p>
</div>

<form action="/logout" method="get">
    <input type="submit" value=
    <fmt:message key="user.logout"/> id="frm1_submit"/>
</form>

</body>
</html>
