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
    <title>menu</title>
</head>
<script>
    window.onload = function (ev) {
        $.ajax({
            url: "/menu/listAll",
            type: "get",
            data: "",
            dataType: "json",
            success: function (data) {
                var parent = data.parent;
                var son = data.son;
                var html = "";
                for (var i = 0; i < parent.length; i++) {
                    html += parent[i].name + '<ul>';
                    for (var j = 0; j < son.length; j++) {
                        if (parent[i].id == son[j].parentId) {
                            html += '<li><a href="' + son[j].url + '">' + son[j].name + '</a></li>';
                        }
                    }
                    html += '</ul>';
                }
                $("#left").append(html);
            }
        })
    }
</script>
<body>
<div id="left">

</div>
</body>
</html>
