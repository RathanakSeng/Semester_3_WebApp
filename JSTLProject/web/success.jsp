<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 2/4/2019
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="database" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <c:forEach items="${students}" var="student">
        <c:if test="${true ne false}">
            <c:out value="${student}"/>
        </c:if>
        <c:if test="${false eq true}">
            <c:out value="${student.name}"/>
        </c:if>
    </c:forEach>

    <database:setDataSource var="mydb" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/java_database" user="root" password="n@k123seng" scope="session"/>
    <database:query var="cursor" dataSource="${mydb}">
        select * from student;
    </database:query>

    <c:forEach items="${cursor.rows}" var="student">
        <c:out value="${student.id}"/> :
        <c:out value="${student.name}"/>
    </c:forEach>

    <database:update var="rowsAffected" dataSource="${mydb}">
        insert into student (name, dept_name, score) value ('Vudthi', 'History', 49.50);
    </database:update>

    <database:update var="rowsAffected" dataSource="${mydb}">
        update student set score = 125.00 where dept_name = 'Mathematic';
    </database:update>
</body>
</html>
