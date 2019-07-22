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
    ${pageContext.session.id}
</body>
</html>
