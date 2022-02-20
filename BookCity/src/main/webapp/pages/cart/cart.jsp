<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
</head>
<body background="static/img/main.jpg">

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/shopping.png">
    <%--<span class="wel_word">Shopping Trolley</span>--%>
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${CarItemPage.bookList}" var="caritem">
            <tr>
                <td>${caritem.ciTitle}</td>
                <td>${caritem.ciTotal}</td>
                <td>${caritem.ciPrice}</td>
                <td>${caritem.ciAmount}</td>
                <td><a href="#">删除</a></td>
            </tr>
        </c:forEach>

    </table>

    <br>
    <div id="page_nav">
        <a href="car/${User.username}/1">首页</a>
        <c:if test="${CarItemPage.currentPage > 1 }">
            <a href="car/${User.username}/${CarItemPage.currentPage - 1 }">上一页</a>
        </c:if>
        <c:if test="${CarItemPage.currentPage < CarItemPage.totalPage }">
            <a href="car/${User.username}/${CarItemPage.currentPage + 1 }">下一页</a>
        </c:if>
        <a href="car/${User.username}/${CarItemPage.totalPage}">末页</a>
        共 ${CarItemPage.currentPage } / ${CarItemPage.totalPage }页, ${CarItemPage.totalItems}条记录
        到第<input value="" name="pn" id="pn_input"/>页
        <input id="sub_page" type="button" value="确定">
    </div>
    <br>

    <div class="cart_info">
        <span class="cart_span">购物车中共有<span class="b_count">${CarItemPage.totalRecode}</span>件商品</span>
        <span class="cart_span">总金额<span class="b_price">${CarItemPage.amount}</span>元</span>
        <span class="cart_span"><a href="car/${User.username}">清空购物车</a></span>
        <c:if test="${CarItemPage.totalItems>0}">
            <span class="cart_span"><a href="cars/${User.username}">去结账</a></span>
        </c:if>
        <span class="cart_span"><a href="books/1">继续购物</a></span>
    </div>

</div>

<%@include file="/WEB-INF/include/version.jsp" %>
</body>
</html>
