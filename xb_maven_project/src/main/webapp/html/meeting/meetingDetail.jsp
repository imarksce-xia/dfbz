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
    <c:if test="${map.flag!=1}">
        <c:if test="${map.flag==2}">
            <a href="/meeting/unJoinMeeting?id=${meeting.id}" name="id" class="btn btn-primary">取消</a>
        </c:if>
        <c:if test="${map.flag==3}">
            <a href="/meeting/joinMeeting?id=${meeting.id}" name="id" class="btn btn-primary">参加</a>
        </c:if>
    </c:if>

    <c:if test="${map.flag==1}">不需要参加会议</c:if>

    <br><br>
    标题：${meeting.title}<br><br>
    选择部门：${meeting.deptName}<br><br>
    应到：${map.should}<br><br>
    实到：${map.realCount}<br><br>
    未到：${map.should-map.realCount}<br><br>
    <br><br>
    开始时间：${meeting.startTime}<br><br>
    结束时间：${meeting.endTime}<br><br>
    会议内容：${meeting.content} <br><br>
</div>
</body>
</html>
