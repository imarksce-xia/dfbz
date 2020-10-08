<%--
  Created by IntelliJ IDEA.
  User: lifeng
  Date: 2020/9/16
  Time: 15:33
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
<form action="user/update" method="post">
    <input type="text" name="id" hidden value="${user3.id}">
    姓名：<input type="text" name="name" value="${user3.name}"><br><br>
    年龄：<input type="text" name="age" value="${user3.age}"><br><br>

    性别：<input type="radio" name="sex" value="1" <c:if test="${user3.sex==1}">checked</c:if>>男
    <input type="radio" name="sex" value="0" <c:if test="${user3.sex==0}">checked</c:if>>女<br><br>

    工资：<input type="text" name="sal" value="${user3.sal}"><br><br>
    出生日期：<input type="date" name="birth" value="${user3.birth}"><br><br>

    <input type="submit" value="保存">
</form>
</body>
</html>
