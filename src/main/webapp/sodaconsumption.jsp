<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<t:pagetemplate>
    <html>
    <head>
        <title>sodaconsumption</title>
    </head>
    <body>
    <form action="sodacalculator" method="post">
        <label for="soda"> Hvor meget sodavand drikker du til daglig?</label>
        <input type="number" class="form-control w-25 d-inline" id="soda" required name="soda" value="soda" placeholder="antal liter">
        <input type="number" class="form-control w-25 d-inline" required name="price" value="price" placeholder="pris pr liter">
        <input type="checkbox" id="sugarFree" name="sugarFree" value="true">
        <label for="sugarFree">Sukkerfri</label>
        <button class="btn btn-primary align-top" type="submit">Beregn</button>
        <br>
    </form>

    Antal:
    Du drikker ${requestScope.soda.litersPerDay} liter pr. dag.
        ${requestScope.soda.litersPerMonth} liter om måneden og
        ${requestScope.soda.litersPerYear} liter om året.
    <br/>

    Priser:
    Din sodavandsudgift pr. dag er ${requestScope.soda.pricePerDay} kroner,
    ${requestScope.soda.pricePerMonth} kroner om måned og
    ${requestScope.soda.pricePerYear} kroner om året.
    <br/>



    <table class="table">
        <tr>
            <th>Nedskæring i procent</th>
            <th>Nyt daglig indtag</th>
            <th>Reduceret daglig indtag</th>
            <th>kr. sparet per dag</th>
            <th>kr. sparet per måned</th>
            <th>kr. sparet per år</th>
            <c:if test="${!requestScope.sugarFree}">
                <th>Kalorier</th>
            </c:if>
        </tr>
        <c:forEach items="${requestScope.soda.percentages}" var="item">
            <tr>
                <c:forEach items="${item}" varStatus="index" var="value">
                    <c:choose>
                        <c:when test="${index.last}">
                            <c:if test="${!requestScope.sugarFree}">
                                <td>
                                    ${value}
                                </td>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <td>
                                ${value}
                            </td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>

        </c:forEach>
    </table>

    </body>
    </html>
</t:pagetemplate>