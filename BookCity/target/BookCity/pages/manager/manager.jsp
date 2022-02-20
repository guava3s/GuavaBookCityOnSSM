<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body background="static/img/welcome.jpg">
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/BookManageSystem.png">
    <%@include file="/WEB-INF/include/book_header.jsp" %>
</div>

<div id="main">
    <h1>欢迎管理员 ${sessionScope.User.username} 进入后台管理系统</h1>
</div>

<%@include file="/WEB-INF/include/version.jsp" %>

</body>
</html>