<%--
  Created by IntelliJ IDEA.
  User: bsg
  Date: 12/13/2018
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container my-form">
            <form action="FirstServe" method="POST">
                <div class="form-group">
                    <label for="name">Username:</label>
                    <input type="text" name="name" class="form-control" id="name">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" name="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" name="pass" class="form-control" id="password">
                </div>
                <br>
                <button type="submit" class="btn btn-outline-primary">Submit</button>
            </form>
        </div>
    </body>
    <style>
        .my-form {
            padding: 1em;
            margin-top: 1em;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }
    </style>
</html>
