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
    </style>
</head>
<body background="static/img/welcome.jpg">

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/logo_orders.png">
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>日期</td>
            <td>金额</td>
            <td>状态</td>
            <td>详情</td>
        </tr>
        <c:forEach items="${requestScope.Page.displayList}" var="OrderItem">
            <tr>
                <td>${OrderItem.oiDate}</td>
                <td>${OrderItem.oiAmount}</td>
                <td>${OrderItem.oiState}</td>
                <td><a href="#">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>

    <br>

    <div id="page_nav">
        <a href="order/1">首页</a>
        <c:if test="${Page.hasPreviousPage}">
            <a href="order/${Page.prePage}">上一页</a>
        </c:if>
        <c:if test="${Page.hasNextPage}">
            <a href="order/${Page.nextPage}">下一页</a>
        </c:if>
        <a href="order/${Page.totalPage}">末页</a>
        共 ${Page.currentPage } / ${Page.totalPage }页, ${Page.totalRecode}条记录
        到第<input value="" name="pn" id="pn_input"/>页
        <input id="sub_page" type="button" value="确定">
    </div>


</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>