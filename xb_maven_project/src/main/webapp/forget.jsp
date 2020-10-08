<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>忘记密码</title>
</head>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
<script>
    // function changePicCode() {
    //     $("#picCode").attr("src","/img/getPicCode?noCache="+new Date());
    // }
    function sendEmail() {
        $.ajax({
            url: "/email/sendEmail",
            type: "post",
            data: {"email": $("#email").val()},
            dataType: "text",
            success: function (data) {
                if (data === "1") {
                    alert("邮箱发送成功!")
                } else {
                    alert("邮箱发送失败!")
                }
            }
        })
    }
</script>
<body>
<form action="login/forget" method="post">
    username<input type="text" name="username" value=""><br><br>
    password:<input type="password" name="password" value=""><br><br>
    rePassword:<input type="password" name="rePassword" value=""><br><br>

    请输入邮箱：<input value="" type="text" name="email" id="email">
    <input value="发送邮箱" type="button" name="" onclick="sendEmail()"><br><br>

    验证码：<input value="" type="text" name="code">
    <br><br>

    <input type="submit" value="修改密码">
</form>
</body>
</html>
