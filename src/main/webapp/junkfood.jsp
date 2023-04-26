<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
    Junkfood
</jsp:attribute>

    <jsp:attribute name="footer">
        The worlds worst calorie calculator.
        </jsp:attribute>
    <jsp:body>
        <t:info>
          This is the worlds worst calorie calculator.
            It gives you a rough estimates of the amount of calories you may indulge in on a saturday night on the couch.<br>
            We highly advice you to eat as much as you, use our calculator and say yes to any add that may pop up while using this excellent, and awful, calculator.
        </t:info>

        <t:content>
            <!-- In our .jsp site we use a template that we also used in "De-4-Data-Amigos Cupcake project.
            Unlucky the template did not fit that well into our junkfood page.
            You can however see the site perfectly, but it's not the most beautiful. -->
                <div>
                    <form method="post">


                        <div class="btn-toolbar justify-content-between mt-3" role="toolbar">
                            <div class="btn-group" role="group">
                                <select class="form-select" style="color: #6f42c1; width: 600px; text-align-last: center;"
                                        aria-label="Default select example" name="junk">
                                    <option selected>Choose your food</option>
                                    <c:forEach var="junk" items="${requestScope.foodsanddrinks}" varStatus="loop">
                                        <option value="${loop.index}">${junk.food} ${junk.kcal}</option>
                                    </c:forEach>
                                </select>
                                <button formaction="Junkfood" type="submit"
                                        class="btn btn-primary">Add
                                </button>
                            </div>
                    </form>
                </div>

            <div class="container py-3">

            <div class="row align-items-md-stretch">
               <!-- <div class="col-md-8"> -->
                    <div class="h-100 p-5 bg-light border rounded-3">

                        <h2>Overview:</h2>
                        <form method="post">
                            <table class="table table-striped mt-3">
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
                                    </c:forEach>
                                    <td class="text-center align-middle">${requestScope.totalKcal}<br></td>


                                </tr>

                            </table>
                        </form>

                    </div>
                </div>

            </div>
        </t:content>
    </jsp:body>
</t:pagetemplate>
