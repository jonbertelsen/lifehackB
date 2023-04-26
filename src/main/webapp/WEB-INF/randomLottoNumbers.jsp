<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: freed
  Date: 25/04/2023
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Random Lotto Numbers</title>
</head>
<body>
    <h1>Random Lotto Numbers</h1>
    <ol>
       <c:forEach var="number" items="${requestScope.lottoNumbers}">
           <li>${number}</li>
       </c:forEach>

    </ol>
</body>
</html>
