<%--
  Created by IntelliJ IDEA.
  User: lifeng
  Date: 2020/9/16
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="user/add" method="post">
    <input type="text" name="id" hidden>
    姓名：<input type="text" name="name"><br><br>
    年龄：<input type="text" name="age"><br><br>

    性别：<input type="radio" name="sex" value="1">男
    <input type="radio" name="sex" value="0">女<br><br>

    工资：<input type="text" name="sal"><br><br>
    出生日期：<input type="date" name="birth"><br><br>

    <input type="submit" value="保存">
</form>
</body>
</html>
