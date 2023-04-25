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
                <li class="list-group-item">An item</li>
                <li class="list-group-item">A second item</li>
                <li class="list-group-item">A third item</li>
                <li class="list-group-item">A fourth item</li>
                <li class="list-group-item">And a fifth one</li>
            </ul>
        </t:content>
    </jsp:body>

</t:pagetemplate>