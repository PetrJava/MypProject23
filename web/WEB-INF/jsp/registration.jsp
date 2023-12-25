
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/registration" method="post">
    <label for="login">Login
        <input type="text" name="login" id="login">
    </label><br>
    <label for="email">Email
        <input type="email" name="email" id="email">
    </label><br>
    <label for="pass">Password
        <input type="password" name="password" id="pass">
    </label><br>
    <select name="role" id="role">
        <c:forEach var="role" items="${requestScope.role}">
            <option value="${role}">${role}</option>
        </c:forEach>
        <label for="date">Date
            <input type="date" name="date" id="date">
        </label><br>
    </select><br>
    <button type="submit"> Send
    </button>
    <button type="reset"> Reset</button>
    <div>
        <c:if test="${not empty requestScope.errors}">
            <div style="color: red">
                <c:forEach var="error" items="${requestScope.errors}">
                <span>${error.message}</span>
                </c:forEach>
            </div>

        </c:if>
    </div>

</form>


</body>
</html>
