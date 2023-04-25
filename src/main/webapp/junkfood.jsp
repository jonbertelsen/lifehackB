<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
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
                    aria-label="Default select example" name="junk">
                <option selected>Vælg din mad</option>
                <c:forEach var="junk" items="${requestScope.foodsanddrinks}" varStatus="loop">
                    <option value="${loop.index}">${junk.food} ${junk.kcal}</option>
                </c:forEach>
            </select>
            <div class="btn-toolbar justify-content-between mt-4" role="toolbar">
                <div class="btn-group" role="group">
                    <button formaction="Junkfood" type="submit"
                            class="btn btn-primary">Add
                    </button>
                </div>
        </form>
    </div>
</div>


<c:forEach var="junk" items="${requestScope.selectedChoices}" varStatus="loop">
    <p>food: ${junk.food}</p>
<p> kcal: ${junk.kcal}</p>
</c:forEach>



</body>
</html>
