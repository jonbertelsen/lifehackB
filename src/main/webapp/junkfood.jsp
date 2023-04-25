<%--
  Created by IntelliJ IDEA.
  User: Marcu
  Date: 25-04-2023
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Junkfood</title>
</head>
<body>
<h1>Rasmus og Marcus' liste af kcal test test</h1>

<div style="display: flex; justify-content: center;">
    <div>
        <form method="post">

            <select class="form-select" style="color: #6f42c1; width: 600px; text-align-last: center;"
                    aria-label="Default select example" name="top">
                <option selected>Vælg en top</option>
                <c:forEach var="junk" items="${requestScope.foodsanddrinks}" varStatus="loop">
                    <option value="${loop.index}">${junk.food} ${junk.kcal}</option>
                </c:forEach>
            </select>
        </form>
    </div>
</div>

</body>
</html>
