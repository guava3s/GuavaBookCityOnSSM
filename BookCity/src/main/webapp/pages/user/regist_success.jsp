<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>番石榴会员注册页面</title>
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
    <img class="logo_img2" alt="" src="static/img/log_regist_success.png">
    <span class="wel_word"></span>
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>

<div id="main">

    <h1>注册成功! <a href="pages/user/login.jsp">转到登录页面</a></h1>

</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>