<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/21/2019
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!-- get from pageContext -->
    <h3>Hi! <%= session.getAttribute("sureName") %> <%= request.getParameter("name") %>, or <%= pageContext.getAttribute("nextName", PageContext.APPLICATION_SCOPE) %>, welcome to: <%= (String)session.getAttribute("school") %>, batch: <%= application.getInitParameter("batch")%></h3>
    <br>
    <br>
    <i>session's id: <%=session.getId()%></i>
    <br>
    <i>session's inactive interval: <%=session.getMaxInactiveInterval()%></i>
</body>
</html>
