<%--
  Created by IntelliJ IDEA.
  User: micolen
  Date: 2021/11/23
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="books/m/1">首页</a>
    <c:if test="${Page.hasPreviousPage }">
        <a href="books/m/${requestScope.Page.currentPage-1 }">上一页</a>
    </c:if>
    <c:if test="${Page.hasNextPage}">
        <a href="books/m/${requestScope.Page.currentPage+1 }">下一页</a>
    </c:if>
    <a href="books/m/${requestScope.Page.totalPage}">末页</a>
    共 ${Page.currentPage } / ${Page.totalPage }页, ${Page.totalRecode}条记录
    到第<input value="" name="pn" id="pn_input"/>页
    <input id="sub_page" type="button" value="确定">
</div>
</div>
