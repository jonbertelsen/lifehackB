<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:body>
        <t:info>
            <h1 class="card-title">Welcome to the SmokeStop Calculator</h1>
            <p class="card-text">
                This calculator will help you to see how much money you can save if you quit smoking, or if you cut down on the amount of cigarettes you smoke.
            </p>
        </t:info>
        <t:content>

            <div>
                <section class="py-4 py-xl-5">
                    <div class="container">
                        <div class="bg-dark border rounded border-dark overflow-hidden">
                            <div class="row no-gutters">
                                <div class="col-md-6">
                                    <div class="text-white p-4 p-md-5">
                                        <p class="mb-4">How many cigarettes do you consume in a day?&nbsp;</p>
                                        <form action="smokestop" method="POST">
                                            <input type="number" name="cigarettesPerDay"
                                                   style="padding-bottom: 0px;margin-top: -4px;margin-bottom: 19px;">
                                            <p>How much does a single cigarette cost you?</p>
                                            <input type="number" step="0.01" name="pricePerCigarette"
                                                   style="padding-bottom: 0px;margin-top: -4px;margin-bottom: 19px;">
                                            <br/>
                                            <button type="submit" class="btn btn-primary btn-lg mr-2"
                                                    style="margin-top: 1px;padding-bottom: 0px;padding-top: 0px;margin-bottom: 2px;margin-left: 6px;">
                                                Submit
                                            </button>
                                        </form>
                                        <c:if test="${not empty error}">
                                            <div class="alert alert-danger mt-3" role="alert">
                                                    ${error}
                                            </div>
                                        </c:if>
                                        <div class="results mt-3">
                                            <c:if test="${not empty totalSavedAWeek}">
                                                <div>If you quit smoking, you would save:</div>
                                                <br/>
                                                <div> DKK <fmt:formatNumber value="${totalSavedAWeek}" type="number"
                                                                            minFractionDigits="2"
                                                                            maxFractionDigits="2"/> a week
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty totalSavedAMonth}">
                                                <div> DKK <fmt:formatNumber value="${totalSavedAMonth}" type="number"
                                                                            minFractionDigits="2"
                                                                            maxFractionDigits="2"/> a month
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty totalSavedAYear}">
                                                <div> DKK <fmt:formatNumber value="${totalSavedAYear}" type="number"
                                                                            minFractionDigits="2"
                                                                            maxFractionDigits="2"/> a year
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty savings10}">
                                                <div> If you cut down by 10%, you would save: DKK <fmt:formatNumber
                                                        value="${savings10}" type="number" minFractionDigits="2"
                                                        maxFractionDigits="2"/> a year
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty savings20}">
                                                <div> If you cut down by 20%, you would save: DKK <fmt:formatNumber
                                                        value="${savings20}" type="number" minFractionDigits="2"
                                                        maxFractionDigits="2"/> a year
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty savings50}">
                                                <div> If you cut down by 50%, you would save: DKK <fmt:formatNumber
                                                        value="${savings50}" type="number" minFractionDigits="2"
                                                        maxFractionDigits="2"/> a year
                                                </div>
                                            </c:if>
                                            <c:if test="${not empty savings100}">
                                                <div> If you cut down by 100%, you would save: DKK <fmt:formatNumber
                                                        value="${savings100}" type="number" minFractionDigits="2"
                                                        maxFractionDigits="2"/> a year
                                                </div>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 order-first order-md-last" style="min-height: 250px;"><img
                                        class="w-100 h-100 fit-cover"
                                        src="images/ImageForSmokeStopCalculator/unnamed.png"></div>
                            </div>
                        </div>
                    </div>
                </section>
            </div>

        </t:content>
    </jsp:body>
</t:pagetemplate>

<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>




