<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>番石榴会员登录页面</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }
    </style>
</head>
<body background="static/img/welcome.jpg">
    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif">
        <img class="logo_img2" alt="" src="static/img/LoginSuccess.png">
<%--        <span class="wel_word">Book City</span>--%>
        <%@ include file="/WEB-INF/include/welcome.jsp" %>
    </div>

    <div id="main">
        <h1>欢迎回来 <a href="books/1">转到主页</a></h1>
    </div>

    <%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>