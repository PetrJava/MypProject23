<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Список клиентов</h1>
<ul>
    <c:forEach var="client" items="${requestScope.clients}">
        <li>
            <a href="${pageContext.request.contextPath}/accounts?bankAccountId=${client.accountId}"> ${client.clientId} - ${client.info}</a>
        </li>

    </c:forEach>
</ul>
</body>
</html>
<%--<a href="${pageContext.request.contextPath}/accounts?bankAccountId=${clients.accountId}">${clients.id} - ${clients.info}</a>--%>