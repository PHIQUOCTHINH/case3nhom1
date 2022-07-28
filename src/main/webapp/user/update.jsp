<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28/07/2022
  Time: 7:47 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form   method="post" action="/loginServlet?action=updateUser">
    <div class="form-outline mb-4">
        <input type="email" id="form0Example2"  value="${u.getEmail()}" name="email"  class="form-control"  readonly/>
        <label class="form-label" for="form2Example2">Email</label>
    </div>
        <div class="form-outline mb-4">
            <input type="text" id="form3Example2" value="${u.getName_user()}"  name="name"  class="form-control" />
            <label class="form-label" for="form2Example2">Name</label>
        </div>
        <div class="form-outline mb-4">
            <input type="date" id="form4Example2"  value="${u.getBirth()}" name="date"  class="form-control" />
            <label class="form-label" for="form2Example2">Date of Birth</label>
        </div>

    <!-- Email input -->
<%--    <div class="form-outline mb-4">--%>
<%--        <input type="email" id="form2Example1" name="email" class="form-control" />--%>
<%--        <label class="form-label" for="form2Example1">Email address</label>--%>
<%--    </div>--%>

    <!-- Password input -->
    <div class="form-outline mb-4">
        <input type="password" id="form2Example2" value="${u.getPassword_user()}"  name="pass"  class="form-control" />
        <label class="form-label" for="form2Example2">Password</label>
    </div>

        <div class="form-outline mb-4">
            <input type="text" id="form5Example2" value="${u.getPhoneNumber()}"  name="phone"  class="form-control" />
            <label class="form-label" for="form2Example2">Phone Number</label>
        </div>
        <div class="form-outline mb-4">
            <input type="text" id="form6Example2" value="${u.getImage()}"  name="image"  class="form-control" />
            <label class="form-label" for="form2Example2">Image</label>
        </div>

    <!-- 2 column grid layout for inline styling -->

    <!-- Submit button -->
    <button type="submit" class="btn btn-primary btn-block mb-4">Sign in</button>

</form>


</body>
</html>
