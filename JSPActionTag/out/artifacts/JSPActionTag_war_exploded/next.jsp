<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/29/2019
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Next</title>
</head>
<body>
    <jsp:forward page="success.jsp">
        <jsp:param name="myName" value="${param.name}"/>
    </jsp:forward>
</body>
</html>
