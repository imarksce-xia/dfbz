<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>数据界面</title>
</head>
<body>
<jsp:include page="/html/common/top.jsp"></jsp:include>
<jsp:include page="/html/common/menu.jsp"></jsp:include>
<div id="right">
    <a href="/html/user/userAdd.jsp" class="btn btn-success">添加</a>
    <form action="user/list">
        姓名：<input type="text" name="username" value="${username}">
        <input type="submit" value="查询">
    </form>
    <table style="width: 100%;" border="1" cellspacing="0" cellpadding="10">
        <tr>
            <td>序号</td>
            <td>用户名</td>
            <td>邮箱</td>
            <td>真实姓名</td>
            <td>年龄</td>
            <td>性别</td>
            <td>注册时间</td>
            <td>上次登录时间</td>
            <td>部门</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list}" var="meeting" varStatus="status">
            <tr>
                <td>${status.index+1}</td>
                <td>${meeting.username}</td>
                <td>${meeting.email}</td>
                <td>${meeting.realName}</td>
                <td>${meeting.age}</td>
                <td>
                    <c:choose>
                        <c:when test="${meeting.sex==0}">女</c:when>
                        <c:when test="${meeting.sex==1}">男</c:when>
                        <c:otherwise>其他</c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <fmt:parseDate var="registerTime" value="${meeting.registerTime}"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${registerTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
                </td>
                <td>
                    <fmt:parseDate var="loginTime" value="${meeting.loginTime}"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${loginTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
                </td>
                <td>${meeting.deptName}</td>
                <td>
                    <a href="/user/delete?id=${meeting.id}">删除</a>
                    <a href="/user/toUpdate?id=${meeting.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="/user/list?page=1&username=${username}">首页</a>
    <a href="/user/list?page=${page-1}&username=${username}">上一页</a>
    <a href="/user/list?page=${page+1}&username=${username}">下一页</a>
    <a href="/user/list?page=${pageTotal}&username=${username}">尾页</a>
    当前第${page}页，每页3条，共${count}条，共${pageTotal}页
</div>
</body>
</html>
