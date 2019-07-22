<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/28/2019
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>error</title>
</head>
<body>
    <h1>Status-404</h1>
    <h1><i>Page not found</i></h1>
    <br>
    <jsp:useBean id="student" class="com.bean.MyBean" scope="session"></jsp:useBean>
    <i>id: <jsp:getProperty name="student" property="id"/></i>
    <br>
    <i>name: <jsp:getProperty name="student" property="username"/></i>
    <br>
    <i>myName: ${param.myName}</i> <!--Expression language, directly print every-->
</body>
</html>
