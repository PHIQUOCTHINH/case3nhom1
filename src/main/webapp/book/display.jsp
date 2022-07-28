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
<div align="center">
<h1>List Book</h1>
<button style="margin-bottom: 10px"><a style="text-decoration: none" href="/bookServlet?action=create">Create new book</a></button>
<table border="1" width="800px">
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Describe</th>
        <th>Image</th>
        <th>Status</th>
        <th>Category</th>
        <th>Writer</th>
        <th>Location</th>
        <th colspan="3">Action</th>
    </tr>
    <c:forEach items="${books}" var="b">
        <tr>
            <td >${b.getId()}</td>
            <td >${b.getNameBook()}</td>
            <td >${b.getDescribeBook()}</td>
            <td style="text-align: center"><img src="${b.getImage()}" alt="" width="100px" height="100px" > </td>
            <td >${b.getStatusBook()}</td>
            <td >${b.getCategory().getNameCategory()}</td>
            <td >${b.getPublishingCompany().getNamePublishing()}</td>
            <td >${b.getLocation().getNameLocation()}</td>
            <td ><button><a style="text-decoration: none" href="/bookServlet?action=update&id=${b.getId()}">Update</a></button></td>
            <td ><button><a style="text-decoration: none" href="/bookServlet?action=delete&id=${b.getId()}">Delete</a></button></td>
            <td ><button><a style="text-decoration: none" href="/bookServlet?action=detail&id=${b.getId()}">Detail</a></button></td>
        </tr>
    </c:forEach>
</table>
    <table>
        <tr>
            <td></td>
        </tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
        <tr></tr>
    </table>
</div>
<div>
    <a href="/loginServlet?action=updateUser&email=${email}">Cập nhật thông tin cá nhân</a>
</div>
<div >
    <a href="/loginServlet">Đăng xuất</a>
</div>
</body>
</html>
