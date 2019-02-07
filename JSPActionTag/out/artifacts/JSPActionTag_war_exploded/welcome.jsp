<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/29/2019
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome to my website</h2>
    <jsp:useBean id="student" class="com.bean.Student" scope="session"></jsp:useBean>
    <h3><i>id: <jsp:getProperty name="student" property="id"/></i></h3>
    <h3><i>name: ${sessionScope.student.getName()}</i></h3>
    <h3><i>batch: ${initParam.Batch}</i></h3>
    <h3><i>school: ${applicationScope.school}</i></h3>
</body>
</html>
