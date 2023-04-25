<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
<jsp:attribute name="header">
    <title>Running Calculator</title>

     <style>
         body
         .background{
             background-image: url("images/ForestTrail.jpg");
             height: 100%;
             background-position:center;
             background-size:cover;
         }
         .no-background{
             background-image: url("images/blank.png");
             height: 100%;
             background-position: center;
             background-size: cover;
         }

     </style>

</jsp:attribute>
    <jsp:body>

        <t:info>

            <h2 class="card-title, no-background"> Løbe Beregner</h2> <br/>
            <p class="card-text"> Med dette lille program kan du beregne: <br/>
                * antal af kilometer <br/>
                * Anslået løbetid<br/>
                * Gennemsnitshastighed<br/>
                ved at udfylde to af kriterierne, vil du få oplyst den tredje. <br/><br/>
                God fornøjelse</p>
        </t:info>


        <t:content>
            <div class="background, card">
                <h2 class="text-center pt-5"> Good-To-Calculate</h2>
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
                                    <%--********************************************
                                    Different respons to the user
                                    ********************************************--%>
                                    <c:if test="${requestScope.distance!=null}">

                                        <td>
                                            <p class="card-text"> Ud fra de valgte kriterier vil du kunne nå at løbe:
                                                <br/>
                                                "${requestScope.distance} km </p>
                                        </td>

                                    </c:if>
                                    <c:if test="${requestScope.time!=null}">
                                        <td>
                                            <p class="card-text"> Ud fra de valgte kriterier vil du løbe distancen på:
                                                <br/>
                                                "${requestScope.time} minutter </p>
                                        </td>
                                    </c:if>

                                    <c:if test="${requestScope.speed!=null}">
                                        <td>
                                            <p class="card-text"> Ud fra de valgte kriterier rammer du en
                                                gennemsnitshastighed på: <br/>
                                                "${requestScope.speed} km/t </p>
                                        </td>
                                    </c:if>

                                    <c:if test="${requestScope.allOptionsChosen == true}">
                                        <td>
                                            <p class="card-text">hva blondie? Hvad er det jeg skal udregne hvis du selv
                                                skriver det hele?</p>
                                        </td>
                                    </c:if>

                                    <c:if test="${requestScope.notEnoughOptionsChosen==true}">
                                        <td>
                                            <p class="card-text">hva så? Skal jeg selv gætte det sidste kriterie, eller
                                                vil du indtaste noget brugbart?<br/>
                                                Jeg skal bruge 2 udfyldte felter</p>
                                        </td>
                                    </c:if>
                                    </td>
                                </tr>
                                        <%--********************************************
                                        Let the user return to the main page
                                        ********************************************--%>
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


        </t:content>
    </jsp:body>
</t:pagetemplate>
