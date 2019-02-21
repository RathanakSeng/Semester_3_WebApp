<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>$Title$</title>
    </head>
    <body>
        <form action="StudentController" method="post">
            <input type="text" name="id" placeholder="Enter your id"/>
            <input type="text" name="name" placeholder="Enter your name"/>
            <input type="submit" value="login"/>
        </form>
        <br>
        <button onclick="loadDoc()">Get Locker</button>
        <div id="show">Hello</div>
        <script>
            function loadDoc () {
                let xhr = new XMLHttpRequest()
                xhr.open("GET", "http://localhost:3000/getLocker", true)
                xhr.send()
                xhr.onload = function () {
                    let res = this.responseText
                    let resJ = JSON.parse(res)
                    document.getElementById("show").innerText = resJ[1]._id
                }
            }
        </script>
    </body>
</html>
<!--Separation of the concept-->
<!--

    + Ajax: Asynchronous Javascript And XML
    + Send data without loading web page (XMLHttpRequest, XMLHttpResponse)
    + Synchronous: The whole web page need to be load
    + Asynchronous:  Load only the things that is need

-->

