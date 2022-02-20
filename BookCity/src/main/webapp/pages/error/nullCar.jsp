<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
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
<body background="static/img/main.jpg">

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/shopping.png">
    <%--<span class="wel_word">Shopping Trolley</span>--%>
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>

<%@include file="/WEB-INF/include/nullTarget.jsp" %>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>
