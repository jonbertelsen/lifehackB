<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>


    <jsp:body>

        <t:info>
            <h1 class="card-title">Velkommen</h1>
            <p class="card-text">
                På denne side kan se en masse forskellige lifehacks, der vil hjælpe dig til en nemmere hverdag forhåbentlig
            </p>
        </t:info>
        <t:content>
            <ul class="list-group">
                <a class="link" href="${pageContext.request.contextPath}/runningcalculator.jsp"><li class="list-group-item">Løbeberegner</li></a>
                <a class="link" href="${pageContext.request.contextPath}/loancalc.jsp"><li class="list-group-item">Låneberegner</li></a>
                <a class="link" href="${pageContext.request.contextPath}/sodaconsumption.jsp"><li class="list-group-item">Sodavandsindtag</li></a>
                <a class="link" href="${pageContext.request.contextPath}/onerepmax.jsp"><li class="list-group-item">1rm-beregner</li></a>
            </ul>
        </t:content>
    </jsp:body>

</t:pagetemplate>