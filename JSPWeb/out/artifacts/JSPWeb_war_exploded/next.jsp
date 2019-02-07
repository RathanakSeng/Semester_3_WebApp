<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/21/2019
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page errorPage="exception.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <!--Declaration tag
        To create function and variable
    -->
    <!--Action tag-->
    <jsp:useBean id="student" class="com.bean.MyBean" scope="session"></jsp:useBean>
    <jsp:setProperty name="student" property="id" value="1111"/>
    <jsp:setProperty name="student" property="username" value="Rathanak"/>

    <jsp:forward page="error.jsp">
        <jsp:param name="name" value="Rathanak"/>
    </jsp:forward>
    <%--<jsp:include page="error.jsp"/>--%>
    <%!
//        String name;
        public Integer sum(Integer a, Integer b) {
            return a + b;
        }
    %>

    <!--Expression tag
        Directly print whatever it gets
    -->
    <h1><%=sum(10, 10)%></h1>
    <h2><%=sum(20, 10)%></h2>

    <!--Scriptlet tag
        To write some logic
    -->
    <%
        String name = request.getParameter("name");
        if (name.equalsIgnoreCase("rathanak")) {
            int a = 1/0; // for exception testing
            session.setAttribute("school", "KIT");
            pageContext.setAttribute("sureName", "Seng", PageContext.SESSION_SCOPE); // store in the session
            pageContext.setAttribute("nextName", "Paev", PageContext.APPLICATION_SCOPE);
            session.setMaxInactiveInterval(20);
            request.getRequestDispatcher("success.jsp").forward(request, response);
//            response.sendRedirect("success.jsp");
        }
    %>
</body>
</html>
