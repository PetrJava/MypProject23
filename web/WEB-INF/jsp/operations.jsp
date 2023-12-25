<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Operations</title>
</head>
<body>
<%@ include file="header.jsp"%>

<h1>Выбери тип операции: </h1>

<button type="submit"><a href="${pageContext.request.contextPath}${"/transfer"}">
    <img src="https://i2.imageban.ru/out/2019/06/30/9255dffc527afbc161c94b25d6790d9f.jpg" width="200" height="140" >
    </a></button>


<button type="submit"><a href="${pageContext.request.contextPath}${"/payment"}">
    <img src="https://sun1-15.userapi.com/impf/parJXdpEWkSNyXnd9DpvwbmNuuu3A2l1SOD70Q/TbbLMU5P2BU.jpg?size=1044x720&quality=96&sign=aaf266d009b39b40a816786ce74c97f3&type=album" width="200" height="140" >
</a></button>
</br>
</br>


<button type="submit"><a href="${pageContext.request.contextPath}${"/deposit"}">
    <img src="https://sun9-78.userapi.com/impf/mD4iMwan2zh3vQ5UyIaHeDhLz5p885pnKVt2lA/xLPSQ4RuibA.jpg?size=768x572&quality=96&sign=84836a93bb8dcefea0ac2d66441659a8&type=album" width="200" height="140">
</a></button>



<button type="submit"><a href="${pageContext.request.contextPath}${"/block"}">
    <img src="https://u2.9111s.ru/uploads/202207/02/0cb1be716f65ab129f7ad5213af706cf.jpg" width="200" height="140">
</a></button>
</br>


</body>
</html>
