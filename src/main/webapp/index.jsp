<%--
  Created by IntelliJ IDEA.
  User: mstc
  Date: 2022/6/9
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function jump(){
            var requestUrl = '/'+Math.random().toString(36).substr(3, 5);
             window.location.href = requestUrl;
        }
    </script>
</head>
<body onload="jump()">

</body>
</html>
