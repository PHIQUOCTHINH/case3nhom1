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
<h1>Update Book</h1>
<form action="/bookServlet?action=update" method="post">
    <label><input type="text" name="id" value="${b.getId()}" hidden></label>
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name" value="${b.getNameBook()}"></td>
        </tr>
        <tr>
            <td><label for="describe">Describe</label></td>
            <td><input type="text" name="describe" id="describe" value="${b.getDescribeBook()}"></td>
        </tr>
        <tr>
            <td><label for="image">Image</label></td>
            <td><input type="text" name="image" id="image" value="${b.getImage()}"></td>
        </tr>
        <tr>
            <td><label for="status">Status</label></td>
            <td><select name="status" id="status">
                <option value="${"New"}">Mới</option>
                <option value="${"Old"}">Cũ</option>
            </select>
            </td>
        </tr>
        <tr>
            <td><label for="category">Category</label></td>
            <td>
                <select name="category" id="category">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.getId()}">${c.getNameCategory()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="writer">Writer</label></td>
            <td>
                <select name="writer" id="writer">
                    <c:forEach items="${writers}" var="w">
                        <option value="${w.getId()}">${w.getNamePublishing()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><label for="location">Location</label></td>
            <td>
                <select name="location" id="location">
                    <c:forEach items="${locations}" var="l">
                        <option value="${l.getId()}">${l.getNameLocation()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Update</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
