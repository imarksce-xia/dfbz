<%--
  Created by IntelliJ IDEA.
  User: lifeng
  Date: 2020/9/16
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="/userAdd.jsp">添加</a>
<form action="user/list">
    姓名：<input type="text" value="${name}" name="name">
    <input type="submit" value="查询">
</form>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>工资</td>
        <td>出生日期</td>
        <td>创建日期</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="user" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.sex}</td>
            <td>${user.sal}</td>
            <td>${user.birth}</td>
            <td>${user.createTime}</td>
            <td><a href="delete?id=${user.id}">删除</a>
                <a href="toUpdate?id=${user.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/user/list?page=1&name=${name}">首页</a>
<a href="/user/list?page=${page-1}&name=${name}">上一页</a>
<a href="/user/list?page=${page+1}&name=${name}">下一页</a>
<a href="/user/list?page=${pageTotal}&name=${name}">尾页</a><br>

当前${page},每页3条，共${count}条，共${pageTotal}页。
</body>
</html>
