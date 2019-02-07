<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/21/2019
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <form action="next.jsp" method="get">
        <input type="text" name="name"/>
        <input type="submit" value="To next"/>
    </form>
</body>
</html>

<!--Action tag-->
<!--
    1. forward - from one jsp to other
    2. include - include other jsps into current jsp
    3. setAttribute - set attribute in any scope
    4. getAttribute get attribute in any scope
    5. param - pass param
    6. useBean -  // Private variable, default constructor, getter and setter, serializable
-->
