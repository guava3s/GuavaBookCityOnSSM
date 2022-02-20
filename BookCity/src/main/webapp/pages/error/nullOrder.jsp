<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的订单</title>
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
    <img class="logo_img2" alt="" src="static/img/logo_orders.png">
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>

<%@include file="/WEB-INF/include/nullTarget.jsp"%>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>