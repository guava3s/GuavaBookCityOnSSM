<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>番石榴图书管理</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
</head>
<body  background="static/img/main.jpg">
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/BookEdit.png">
    <%@include file="/WEB-INF/include/book_header.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>

        <c:forEach items="${requestScope.Page.displayList}" var="book">
            <tr>
                <td>${book.title}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="book/${book.title}">修改</a></td>
                <td><a href="book/${book.title}/delete">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
        </tr>
    </table>
    <br>
    <%@include file="/WEB-INF/include/bottomManagerIndex.jsp" %>
</div>
<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>