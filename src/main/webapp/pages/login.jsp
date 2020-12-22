<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setBundle basename="message"/>

<html>
<head>
    <title>Title</title>
    <style>
        @import "../bootstrap/css/bootstrap.css";
        @import "../bootstrap/css/bootstrap.min.css";
    </style>
</head>
<body>
<div style="display: block; margin: auto; width: 300px; height: 200px">
<form method="post" action="">
    </br>
    <div align="left">
        <label for="login" class="form-label"><fmt:message key="user.login"/></label>
        <input type="text" class="form-control" placeholder=<fmt:message key="user.login"/> name="login" id="login"
               required>
    </div>
    <div align="left">
        <label for="pwd" class="form-label"><fmt:message key="user.password"/></label>
        <input type="password" class="form-control" placeholder=<fmt:message key="user.password"/> name="pwd" id="pwd" required>
    </div>
    <br>
    <div align="rigth">
        <input type="submit" class="btn btn-info" value=<fmt:message key="button.enter"/> >
    </div>
</form>
</div>
</body>
</html>
