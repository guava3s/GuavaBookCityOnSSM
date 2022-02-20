<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
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
    <img class="logo_img2" alt="" src="static/img/BookEdit.png">
    <%@include file="/WEB-INF/include/book_header.jsp" %>
</div>

<div id="main">
    <form action="book" method="post">
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
                <td><input name="title" type="text" value="目标图书"/></td>
                <td><input name="price" type="text" value="00.00"/></td>
                <td><input name="author" type="text" value="name"/></td>
                <td><input name="sales" type="text" value="100"/></td>
                <td><input name="stock" type="text" value="100"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>

</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>