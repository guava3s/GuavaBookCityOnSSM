<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>结算页面</title>
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
    <img class="logo_img2" alt="" src="static/img/log_car_checkout.png">
    <%--<span class="wel_word">结算</span>--%>
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>

<div id="main">

    <h1>你的订单已结算，订单号为${requestScope.orderNumber}</h1>

</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>
