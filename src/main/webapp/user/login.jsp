<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/07/2022
  Time: 9:03 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Đăng nhập</h3>
<form   method="post"  >
    <%--    <div class="form-outline mb-4">--%>
    <%--        <input type="text" id="form3Example2"   name="name"  class="form-control" />--%>
    <%--        <label class="form-label" for="form2Example2">Name</label>--%>
    <%--    </div>--%>
    <%--    <div class="form-outline mb-4">--%>
    <%--        <input type="date" id="form4Example2"   name="date"  class="form-control" />--%>
    <%--        <label class="form-label" for="form2Example2">Date of Birth</label>--%>
    <%--    </div>--%>
    <!-- Email input -->
    <div class="form-outline mb-4">
        <input type="email" id="form2Example1" name="email" class="form-control" />
        <label class="form-label"   for="form2Example1">Email address</label>
    </div>

    <!-- Password input -->
    <div class="form-outline mb-4">
        <input type="password" id="form2Example2"   name="pass"  class="form-control" />
        <label class="form-label" for="form2Example2">Password</label>
    </div>

    <%--    <div class="form-outline mb-4">--%>
    <%--        <input type="number" id="form5Example2"   name="phone"  class="form-control" />--%>
    <%--        <label class="form-label" for="form2Example2">Phone Number</label>--%>
    <%--    </div>--%>
    <%--    <div class="form-outline mb-4">--%>
    <%--        <input type="text" id="form6Example2"   name="image"  class="form-control" />--%>
    <%--        <label class="form-label" for="form2Example2">Image</label>--%>
    <%--    </div>--%>

    <!-- 2 column grid layout for inline styling -->
    <div class="row mb-4">
        <div class="col d-flex justify-content-center">
            <!-- Checkbox -->
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                <label class="form-check-label" for="form2Example31"> Remember me </label>
            </div>
        </div>

    </div>

    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4">Login </button>

</form>
<br>
<p name="message" var="message" style="color: firebrick">${message}</p>
</body>
</html>
