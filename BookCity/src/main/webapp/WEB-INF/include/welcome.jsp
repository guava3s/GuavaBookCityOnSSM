<%--
  Created by IntelliJ IDEA.
  User: micolen
  Date: 2021/11/20
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${not empty User }">
    <div>
        <span>欢迎<span class="um_span">${User.username}</span>光临番石榴书城</span>
        <c:choose>
            <c:when test="${User.permission == 'ROOT'}">
                <a href="pages/manager/manager.jsp">后台管理</a>
            </c:when>
            <c:otherwise>
                <a href="order/1">我的订单</a>
                <a href="car/${User.username}/1">购物车</a>
            </c:otherwise>
        </c:choose>
        <a href="user/${User.username}">注销</a>&nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</c:if>
<c:if test="${empty User }">
    <div>
        <a href="pages/user/login.jsp">登录</a> |
        <a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
        <a href="index.jsp">返回</a>
    </div>
</c:if>
