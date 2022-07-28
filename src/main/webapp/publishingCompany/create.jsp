<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/07/2022
  Time: 11:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
<h1>Create new PublishingCompany</h1>
<form action="/bookServlet?action=createP" method="post">
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>

    </table>
</form></div>
</body>
</html>