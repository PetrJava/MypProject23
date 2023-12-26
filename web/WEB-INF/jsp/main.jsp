<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<%@ include file="header.jsp" %>

<h1>Выбери раздел: </h1>

<button type="submit"><a href="${pageContext.request.contextPath}${"/operations"}">
    Платежи</a>
</button>

<button type="submit"><a href="${pageContext.request.contextPath}${"/clients"}">

Список клиентов</a></button>
</br>
</br>

<button type="submit"><a href="${pageContext.request.contextPath}${"/createdCard"}">
Выпустить новую карту</a></button>

</body>
</html>
