<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 1/22/2019
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" %> <!-- error page is to handle the exception -->
<%@ page autoFlush="true" %> <!-- Clear the file auto -->
<%--    <%@ page import="java.lang.ArithmeticException" %>  --%>
<%--    <%@ page extends="java.lang.Thread" %>  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%@ include file="index.jsp" %>
        <%=
    //        if (exception.getClass().equals("ArithmeticException")) {
    //            out.println("There is an ArithmeticException");
    //        }
            exception
        %>
        <br>
        <%@ include file="index.jsp" %> <!-- Generate Dynamic Content -->
    </body>
</html>
