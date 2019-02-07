<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 2/4/2019
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <c:set var="name" value="${param.name}" scope="session"/>
        <c:out value="name"/>
        <c:remove var="name" scope="session"/>

        <!--Use XML-->
        <c:import url="WEB-INF/school.xml" var="school"/>
        <x:parse xml="${school}" var="details"/>
        <x:forEach select="$details/school/section" var="record">
            <x:out select="record/sid"/> :
            <x:out select="record/sname"/> :
            <x:out select="record/ssection"/>
            <br>
        </x:forEach>
    </body>
</html>
