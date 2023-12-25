
<%@ page import="paymentsSystem.dto.BankAccountDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="header.jsp"%>
<h1>Банковский счет клиента</h1>
<ul>
    <c:forEach var="accounts" items="${requestScope.accounts}">
        <li>
            ${accounts.bankAccountId} - ${accounts.bankAccountBalance} - ${accounts.createdTime}
        </li>

    </c:forEach>

        </ul>

</body>
</html>
