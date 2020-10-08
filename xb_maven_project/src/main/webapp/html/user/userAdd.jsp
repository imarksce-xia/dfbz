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
    <form action="/user/add" method="post">
        <input type="text" name="id" hidden>
        username：<input type="text" name="username" value="sss"><br><br>
        password：<input type="password" name="password" value="sss"><br><br>
        email：<input type="text" name="email" value="sss"><br><br>
        name：<input type="text" name="realName" value="sss"><br><br>
        age：<input type="text" name="age" value="18"><br><br>

        sex：<input type="radio" name="sex" value="1">男
        <input type="radio" name="sex" value="0">女<br><br>


        <select name="deptId" id="deptId">

        </select><br><br>

        <input type="submit" value="保存">
    </form>
</div>
</body>
<script>
    $(function () {
        $.ajax({
            url: "/user/listDept",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var html = '<option value="-1">请选择</option>';
                for (var i = 0; i < data.length; i++) {
                    html += '<option value="' + data[i].id + '">' + data[i].name + '</option>';
                }
                $("#deptId").append(html);
            }
        });
    })


</script>
</html>
