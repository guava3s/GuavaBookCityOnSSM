<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>番石榴图书信息更新</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <span class="wel_word">Book Update</span>
    <%@include file="/WEB-INF/include/book_header.jsp" %>
</div>

<div id="main">
    <form action="book/${requestScope.Book.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="title" type="text" value="${requestScope.Book.title}"/></td>
                <td><input name="price" type="text" value="${requestScope.Book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.Book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.Book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.Book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>