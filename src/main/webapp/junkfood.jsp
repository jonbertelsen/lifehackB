<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<html>
<head>
    <title>Junkfood</title>
</head>
<body>
<h1>The worlds worst calorie calculator.</h1>

<div style="display: flex; justify-content: center;">
    <div>
        <form method="post">

            <select class="form-select" style="color: #6f42c1; width: 600px; text-align-last: center;"
                    aria-label="Default select example" name="junk">
                <option selected>Choose your food</option>
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
<div class="container py-4">

    <div class="row align-items-md-stretch">
        <div class="col-md-8">
            <div class="h-100 p-5 bg-light border rounded-3">

                <h2>Overview:</h2>
                <form method="post">
                    <table class="table table-striped mt-4">
                        <thead>
                        <tr>
                            <td class="text-start align-middle" style="color: #6f42c1"><h5>Food</h5>
                            </td>
                            <td class="text-center align-middle" style="color: #6f42c1"><h5>Kcal</h5>
                            </td>
                            <td class="text-center align-middle" style="color: #6f42c1"><h5>Total</h5>
                            </td>
                            <td class="text-end"></td>
                        </tr>
                        </thead>
                        <c:forEach var="junk" items="${requestScope.selectedChoices}"
                                   varStatus="loop">
                        <tr>
                            <td class="text-center align-middle">${junk.food}</td>
                            <td class="text-center align-middle">${junk.kcal}<br></td>
                            <td class="text-center align-middle">${requestScope.totalKcal}<br></td>
                            </c:forEach>

                        </tr>

                    </table>
                </form>

                </div>
            </div>

        </div>

</body>
</html>
