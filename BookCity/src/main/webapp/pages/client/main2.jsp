<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>书城首页</title>
    <%@include file="/WEB-INF/base/base.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 加入购物车
            $(".book_add button").click(function () {
                var bookId = $(this).attr("id");
                var min = $("input[name='min']").val();
                var max = $("input[name='max']").val();
                // 添加购物项
                location = "car/" + bookId + "?min=" + min + "&max=" + max;
            });

            //带价格区间的分页查询
            $(".book_cond :button").click(function () {
                //取pageNo,min,max值
                var min = $("input[name='min']").val();
                var max = $("input[name='max']").val();
                if (min >= max) {
                    alert("请输入合理范围.");
                }
                //请求BookClientServlet
                location = "books/1?min=" + min + "&max=" + max;
            });

            // 页面输入跳转
            $(".page_nav_bottom :button").click(function () {
                var pageNumber = $("input[name='pn']").val();
                if (pageNumber > ${Page.totalPage}) {
                    pageNumber = ${Page.totalPage};
                }
                location = "books/" + pageNumber;
            });
        });
    </script>
</head>
<body background="static/img/main.jpg">
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif">
    <img class="logo_img2" alt="" src="static/img/BookCity.png">
    <%@include file="/WEB-INF/include/welcome.jsp" %>
</div>
<div id="main">
    <div id="book">
        <div class="book_cond">
            价格：<input type="text" name="min" value="${min}"> 元 - <input type="text" name="max"
                                                                        value="${max}">
            元
            <button><span style="color: green">查询</span></button>
            <button><span style="color: cadetblue">重置</span></button>
        </div>
        <div style="text-align: center">
            <div>
                <c:if test="${not empty User}">
                    您的购物车中有<span style="color: red">${sessionScope.bookCount}</span>件商品
                    <br>
                    <c:if test="${not empty sessionScope.bookName}">
                        您刚刚将<span style="color: red">${sessionScope.bookName}</span>加入到了购物车中
                    </c:if>
                    <br>
                </c:if>
                <c:if test="${empty User}">
                    <br>
                    游客请先登录或注册
                </c:if>
            </div>
        </div>

        <c:forEach items="${requestScope.Page.displayList}" var="book">
            <div class="b_list">
                <div class="img_div">
                    <img class="book_img" alt="" src="${book.imgPath}"/>
                </div>
                <div class="book_info">
                    <div class="book_name">
                        <span class="sp1">书名:</span>
                        <span class="sp2">${book.title}</span>
                    </div>
                    <div class="book_author">
                        <span class="sp1">作者:</span>
                        <span class="sp2">${book.author}</span>
                    </div>
                    <div class="book_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${book.price}</span>
                    </div>
                    <div class="book_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${book.sales}</span>
                    </div>
                    <div class="book_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${book.stock}</span>
                    </div>
                    <div class="book_add">
                        <button id="${book.id}">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div id="page_nav" class="page_nav_bottom">
        <a href="books/1?min=${min}&max=${max}">首页</a>
        <c:if test="${Page.hasPreviousPage }">
            <a href="books/${Page.prePage}?min=${min}&max=${max}">上一页</a>
        </c:if>
        <c:if test="${Page.hasNextPage}">
            <a href="books/${Page.nextPage}?min=${min}&max=${max}">下一页</a>
        </c:if>
        <a href="books/${Page.totalPage}?min=${min}&max=${max}">末页</a>
        共 ${Page.currentPage } / ${Page.totalPage }页, ${Page.totalRecode}条记录
        到第<input value="" name="pn" id="pn_input"/>页
        <input id="sub_page" type="button" value="确定">
    </div>

</div>

<%@include file="/WEB-INF/include/version.jsp" %>


</body>
</html>
