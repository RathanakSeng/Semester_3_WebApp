<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/24/2019
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Next</title>
</head>
<body>
    <%!
        String name;
    %>
    <%
        name = request.getParameter("name");
        if (name.equalsIgnoreCase("Rathanak")) {
//            session.setAttribute("name", name);
            pageContext.setAttribute("name", name, PageContext.SESSION_SCOPE);
            session.setMaxInactiveInterval(20);
            response.sendRedirect("success.jsp");
        } else {
            throw new Exception("Name is not correct");
        }
    %>
</body>
</html>
