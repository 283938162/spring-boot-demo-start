<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%--Restful 风格--%>
<script type="text/javascript" src="js/jquery/min.js"></script>
<script type="text/javascript">
    /*将post method 改变为delete*/
    $(function(){
        $(".delete").click(function(){
            var href=$(this).attr("href");
            $("#formdelete").attr("action",href).submit();
            return false;
        })
    })
</script>

<div>
    <table border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach items="${page.list}" var="c" varStatus="st">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td><a href="categories/${c.id}">编辑</a></td>
                <td><a class="delete" href="categories/${c.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div>
        <a href="?start=1">[首 页]</a>
        <a href="?start=${page.pageNum -1}">[上一页]</a>
        <a href="?start=${page.pageNum +1}">[下一页]</a>
        <a href="?start=${page.pages}">[末 页]</a>
    </div>

    <form action="categories" method="post">
        name:<input name="name"> <br>
        <button type="submit">提交</button>
    </form>

    <form id="formdelete" action="" method="POST" >
        <input type="hidden" name="_method" value="DELETE">
    </form>
</div>



<%--第一版--%>
<%--<table border="1" cellspacing="0">--%>
    <%--<tr>--%>
        <%--<td>id</td>--%>
        <%--<td>name</td>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${cs}" var="c" varStatus="st">--%>
        <%--<tr>--%>
            <%--<td>${c.id}</td>--%>
            <%--<td>${c.name}</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</table>--%>


<%--通过page.getList遍历当前页面的Category对象。--%>
<%--在分页的时候通过page.pageNum获取当前页面，page.pages获取总页面数。--%>
<%--注：page.getList会返回一个泛型是Category的集合--%>

<%--传统风格--%>
<%--<div>--%>
    <%--<table border="1" cellspacing="0">--%>
        <%--<tr>--%>
            <%--<td>id</td>--%>
            <%--<td>name</td>--%>
            <%--<td>编辑</td>--%>
            <%--<td>删除</td>--%>
        <%--</tr>--%>
        <%--<c:forEach items="${page.list}" var="c" varStatus="st">--%>
            <%--<tr>--%>
                <%--<td>${c.id}</td>--%>
                <%--<td>${c.name}</td>--%>
                <%--<td><a href="editCategory?id=${c.id}">编辑</a></td>--%>
                <%--<td><a href="deleteCategory?id=${c.id}">删除</a></td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
    <%--</table>--%>
    <%--<br>--%>
    <%--<div>--%>
        <%--<a href="?start=1">[首 页]</a>--%>
        <%--<a href="?start=${page.pageNum -1}">[上一页]</a>--%>
        <%--<a href="?start=${page.pageNum +1}">[下一页]</a>--%>
        <%--<a href="?start=${page.pages}">[末 页]</a>--%>
    <%--</div>--%>

    <%--<form action="addCategory" method="post">--%>
        <%--name:<input name="name"> <br>--%>
        <%--<button type="submit">提交</button>--%>
    <%--</form>--%>
<%--</div>--%>


