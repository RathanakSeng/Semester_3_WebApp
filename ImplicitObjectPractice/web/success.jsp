<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/24/2019
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <%out.println("Welcome to me");%>
    <h3><%=session.getAttribute("name")%>!!... these are your information: </h3>
    <br>
    <h4>your batch: <%=application.getInitParameter("Batch")%></h4>
    <br>
    <i>session's id: <%=session.getId()%></i>
    <br>
    <i>session's inactive interval: <%=session.getMaxInactiveInterval()%></i>
</body>
</html>
