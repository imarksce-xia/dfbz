<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script>
    function changePicCode() {
        $("#picCode").attr("src", "/img/getPicCode?noCache=" + new Date());
    }
</script>
<body>
<form action="login/login" method="post">
    username<input type="text" name="username" value=""><br><br>
    password:<input type="password" name="password" value=""><br><br>
    <input type="checkbox" value="1" name="automatic">自动登录<br><br>

    验证码：<input value="" type="text" name="code">
    <img src="/img/getPicCode" id="picCode" alt="加载中" onclick="changePicCode()">
    <br><br>

    <input type="submit" value="登录">
</form>
<a href="/forget.jsp">忘记密码</a><br><br>
<a href="/weChat/weChatLogin">微信登录</a><br><br>
<form action="register.jsp" method="service">
    <input type="submit" value="注册">
</form>
</body>
</html>
