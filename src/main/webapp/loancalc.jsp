<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<%-- DEV: This JSP page is used to display the visuals of the Loan Calculator.
 It displays a form which takes positive numbers as input from the user and calculates the cost, interest with more
 and displays the new information in a table in the bottom of the page. --%>

<t:pagetemplate>
    <jsp:attribute name="header">
             Loan Calculator
    </jsp:attribute>

     <jsp:body>
       <%-- <t:info>
           <h1 class="card-title> Loan calculator </h1>
               <p class="card-text"> This program is designed to show you variations of a loan you have taken or maybe
           will take in the future. The loan calculator is designed to calculate different aspects of your loan
           including, but not limited to, the total cost of the loan, and your interest rate. The program will also
           showcase different prices with a shorter/longer loan period or even a lower APRC. </p>
        <%-- </t:info> --%>


        <%-- <t:content> --%>
         <%-- Form for user input --%>
        <form action="loancalc" method="POST">
            <div class="form-group">
                <label for="loanAmount">Loan amount</label>
                <input type="number" class="form-control" id="loanAmount" name="loanAmount" min="1" step="0.01" placeholder="Enter loan amount">
            </div>
            <div class="form-group">
                <label for="APRC">APRC</label>
                <input type="number" class="form-control" id="APRC" name="APRC" min="0.1" step="0.01" aria-describedby="APRChelp" placeholder="Enter APRC">
                <small id="APRChelp" class="form-text text-muted">Annual Percentage Rate of Charge (ÅOP)</small>
            </div>
            <div class="form-group">
                <label for="duration">Duration in months</label>
                <input type="number" class="form-control" id="duration" name="duration" min="1" step="1" placeholder="Enter length of loan">
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="monthYearChange" name="monthYearChange">
                <label class="form-check-label" for="monthYearChange">Tick to change duration to years instead of months</label>
            </div>
            <button type="submit" class="btn btn-primary">Calculate</button>
        </form>

        <%-- Table for displaying result of user input --%>
            <table class="table table-striped mt-4">
                <tr>
                    <th>Total amount to pay back</th>
                    <th>Monthly payments</th>
                    <th>Interest</th>
                    <th>Loan Length (months)</th>
                </tr>
                <tr>
                    <%-- Data output based on user input limited to 2 decimals --%>
                    <td>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.totalcostofloan}"/>DKK
                    </td>
                    <td>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.monthlypayment}"/>DKK
                    </td>
                    <td>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.interest}"/>DKK
                    </td>
                    <td>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.loanlength}"/>
                    </td>
                </tr>
                <tr>
                    <%-- Calculates user input but with shorter duration and lower APRC --%>
                    <th>Total: Shorter duration (33%)</th>
                    <th>Total: Lower APRC (50%)</th>
                </tr>
                <tr>
                    <td>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.totalcostshorterduration}"/>DKK
                    </td>
                    <td>
                        <fmt:formatNumber type="number" maxFractionDigits="2" value="${requestScope.totalcostwithlowerAPRC}"/>DKK
                    </td>

                </tr>
            </table>
    <%-- </t:content> --%>
</jsp:body>
</t:pagetemplate>