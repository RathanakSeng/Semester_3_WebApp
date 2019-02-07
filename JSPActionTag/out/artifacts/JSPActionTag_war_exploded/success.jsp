<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/29/2019
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <jsp:useBean id="student" class="com.bean.Student" scope="session"></jsp:useBean>
    <jsp:setProperty name="student" property="id" value="1111"/>
    <jsp:setProperty name="student" property="name" value="${param.myName}"/>
    <%
        application.setAttribute("school", "KIT");
    %>
    <jsp:include page="welcome.jsp"/>
</body>
</html>
<!--
    Expression Language - set the dynamic value inside java bean
    + Cannot set the value, only retrieve
    + Access the implicit obj parameter
    + Using it make code more cleaner and get out from java
    + Expression tag will throw exception | express language not throws exception

    Objects are :
        sessionScope,
        requestScope: to get the attribute,
        param: to get the parameter,
        paramValues: not implement toString function
-->
