<%--
  Created by IntelliJ IDEA.
  User: lifeng
  Date: 2020/9/22
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<jsp:include page="/html/common/top.jsp"></jsp:include>
<jsp:include page="/html/common/menu.jsp"></jsp:include>
<div id="right">
    <a href="/html/meeting/meetingAdd.jsp" class="btn btn-primary">发布会议</a>
    <form action="/meeting/list">
        会议主题：<input type="text" name="title" value="${title}">
        <input type="submit" value="查询">
    </form>
    <table style="width: 100%;" border="1" cellspacing="0" cellpadding="10">
        <tr>
            <td>主题</td>
            <td>部门名称</td>
            <td>状态</td>
            <td>开始时间</td>
            <td>会议内容</td>
        </tr>
        <c:forEach items="${list}" var="meeting" varStatus="status">
            <tr>
                <td><a href="/meeting/getMeetingById?id=${meeting.id}">${meeting.title}</a></td>
                <td>${meeting.deptName}</td>
                <td>
                    <c:choose>
                        <c:when test="${meeting.status==0}">未开始</c:when>
                        <c:when test="${meeting.status==1}">进行中</c:when>
                        <c:when test="${meeting.status==2}">已结束</c:when>
                        <c:otherwise></c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <fmt:parseDate var="startTime" value="${meeting.startTime}"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${startTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
                </td>
                <td>
                    <fmt:parseDate var="endTime" value="${meeting.endTime}"
                                   pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                    <fmt:formatDate value="${endTime}" pattern="yyyy年MM月dd日 HH时mm分ss秒"></fmt:formatDate>
                </td>
                <td>${meeting.content}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="/meeting/list?page=1&title=${title}">首页</a>
    <a href="/meeting/list?page=${page-1}&title=${title}">上一页</a>
    <a href="/meeting/list?page=${page+1}&title=${title}">下一页</a>
    <a href="/meeting/list?page=${pageTotal}&title=${title}">尾页</a>
    当前第${page}页，每页3条，共${count}条，共${pageTotal}页
</div>
</body>
</html>
