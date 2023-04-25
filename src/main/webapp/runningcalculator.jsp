<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

<jsp:attribute name="header">
    <title>Running Calculator</title>

     <style>
         body {
             background-image: url("images/ForestTrail.jpg");
         }
     </style>
</jsp:attribute>


    <jsp:body>
        <div class="card">
            <h2 class="text-center pt-5"> Løbe Beregner</h2>
            <div class="card-body">

                <div class="container">
                    <table class="table align-center mt-5 table-responsive-sm">

                        <form action="list" method="post">
                                <%--********************************************
                                  distance in kilometers the user run
                                ********************************************--%>
                            <tr>
                                <td>
                                    <p> antal km</p>
                                </td>
                                <td>
                                    <input id="km" class="d-inline form-control 2-10" type="number" name="km"
                                           placeholder="afstand" step="0.1" min="0.0"/>
                                </td>
                            </tr>
                                <%--********************************************
                                 How long does it take the user to run
                                ********************************************--%>
                            <tr>
                                <td>
                                    <p> Tid</p>
                                </td>
                                <td>
                                    <input id="time" class="d-inline form-control" type="number" name="time"
                                           placeholder="tid i minuter" min="0"/>
                                </td>
                            </tr>
                                <%--********************************************
                                  The users average speed km/t
                                ********************************************--%>
                            <tr>
                                <td>
                                    <p class="text-align-center"> Gennemsnitshastighed </p>
                                </td>
                                <td>
                                    <div class="input-group mb-3">
                                        <input id="average" class="d-inline form-control 2-10" type="number"
                                               name="average"
                                               value="0.0" step="0.1" min="0.0">
                                        <div class="input-group-append">
                                            <span class="input-group-text" id="basic-addon"> km/t</span>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                                <%--********************************************
                                The user can submit the typed informations
                                ********************************************--%>
                            <tr>
                                <td>
                                    <button
                                            formaction="runningcalculator" class="btn btn-outline-dark"
                                            name="calculate">Beregn
                                    </button>
                                </td>
                                <c:if test="${requestScope.distance!=null}">
                            <tr>
                                <td>
                                    <p> Ud fra de valgte kriterier vil du kunne nå at løbe: <br/>
                                        "${requestScope.distance} km </p>
                                </td>
                            </tr>
                            </c:if>
                            <c:if test="${requestScope.time!=null}">
                                <tr>
                                    <td>
                                        <p> Ud fra de valgte kriterier vil du løbe distancen på: <br/>
                                            "${requestScope.time} minutter </p>
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${requestScope.speed!=null}">
                                <tr>
                                    <td>
                                        <p> Ud fra de valgte kriterier rammer du en gennemsnitshastighed på: <br/>
                                            "${requestScope.speed} km/t </p>
                                    </td>
                                </tr>
                            </c:if>
                            <c:if test="${requestScope.allOptionsChosen!=null}">
                                <tr>
                                    <td>
                                        <p>hva blondie? Hvad er det jeg skal udregne hvis du selv skriver det hele?</p>
                                    </td>
                                </tr>
                            </c:if>
                            </td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="index.jsp">Forside</a>
                                </td>
                            </tr>
                        </form>
                    </table>
                </div>
            </div>
        </div>


    </jsp:body>
</t:pagetemplate>
