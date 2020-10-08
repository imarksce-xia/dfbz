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
    <title>添加用户信息</title>
</head>
<body>
<jsp:include page="/html/common/top.jsp"></jsp:include>
<jsp:include page="/html/common/menu.jsp"></jsp:include>
<div id="right">
    <form action="/user/update" method="post">
        <input type="text" name="id" hidden value="${user.id}">

        username：<input type="text" name="username" value="${user.username}"><br><br>

        password：<input type="password" name="password" value="${user.password}"><br><br>

        email：<input type="text" name="email" value="${user.email}"><br><br>

        <input type="text" name="qqOpenid" hidden value="${user.qqOpenid}">

        <input type="text" name="wxOpenid" hidden value="${user.wxOpenid}">

        realName：<input type="text" name="realName" value="${user.realName}"><br><br>

        age：<input type="text" name="age" value="${user.age}"><br><br>

        <input type="text" name="phone" hidden value="${user.phone}">

        sex：<input type="radio" name="sex" value="1" <c:if test="${user.sex==1}">checked</c:if>>男
        <input type="radio" name="sex" value="0" <c:if test="${user.sex==0}">checked</c:if>>女<br><br>

        <input type="text" name="desc" hidden value="${user.desc}">

        <input type="text" name="registerTime" hidden value="${user.registerTime}">

        <input type="text" name="pic" hidden value="${user.pic}">

        <input type="text" name="look" hidden value="${user.look}">

        <input type="text" name="isSecret" hidden value="${user.isSecret}">

        部门： <select id="dept" name="deptId">

        <c:forEach items="${list}" var="dept">
            <option value="${dept.id}" <c:if test="${dept.id==user.deptId}">selected</c:if>>${dept.name}</option>
        </c:forEach>

    </select><br><br>

        <input type="submit" value="修改">
    </form>
</div>
</body>
</html>
