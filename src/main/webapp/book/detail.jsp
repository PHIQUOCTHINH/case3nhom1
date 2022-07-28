<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/07/2022
  Time: 7:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 >Detail Book</h1>
<table border="1" width="200px">
    <tr>
        <th>Id</th>
        <td>${b.getId()}</td>
    </tr>
    <tr>
        <th>Name</th>
        <td>${b.getNameBook()}</td>
    </tr>
    <tr>
        <th>Describe</th>
        <td>${b.getDescribeBook()}</td>
    </tr>
    <tr>
        <th>Image</th>
        <td style="text-align: center"><img src="${b.getImage()}" width="100px" height="100px"  >  </td>
    </tr>
    <tr>
        <th>Status</th>
        <td>${b.getStatusBook()}</td>
    </tr>
    <tr>
        <th>Category</th>
        <td>${b.getCategory().getNameCategory()}</td>
    </tr>
    <tr>
        <th>PublishingCompany</th>
        <td>${b.getPublishingCompany().getNamePublishing()}</td>
    </tr>
    <tr>
        <th>Location</th>
        <td>${b.getLocation().getNameLocation()}</td>
    </tr>
</table>
<button style="margin-top: 10px"><a href="/bookServlet?action=">Back to home</a></button>
</body>
</html>
