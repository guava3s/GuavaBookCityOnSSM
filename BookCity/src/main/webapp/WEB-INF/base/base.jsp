<%--
  Created by IntelliJ IDEA.
  User: micolen
  Date: 2021/11/16
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--关闭 el表达式忽略模式--%>
<%@ page isELIgnored="false" %>
<%--设置base路径--%>
<base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>/"/>
<%--引用CSS样式--%>
<link type="text/css" rel="stylesheet" href="static/css/style.css">
<%--引用jQuery--%>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<%--引入jstl标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

