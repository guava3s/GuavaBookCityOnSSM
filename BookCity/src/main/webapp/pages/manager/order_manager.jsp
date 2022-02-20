<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单管理</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/OrderManageSystem.png">
    <%--<span class="wel_word">订单管理系统</span>--%>
    <%@include file="/WEB-INF/include/book_header.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>详情</td>
            <td>发货</td>
        </tr>

        <c:forEach begin="1" step="1" end="4">
            <tr>
                <td>2015.04.23</td>
                <td>90.00</td>
                <td><a href="#">查看详情</a></td>
                <td><a href="#">点击发货</a></td>
            </tr>
        </c:forEach>

    </table>
</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>