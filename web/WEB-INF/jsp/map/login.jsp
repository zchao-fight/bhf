<%--
  Created by IntelliJ IDEA.
  User: zc
  Date: 2018/1/10
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/LoginServlet" method="get" >
    name:<input name="username"><br>
    <input type="submit">
</form>

</body>
</html>
