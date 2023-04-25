<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Loan Calculator
    </jsp:attribute>

    <jsp:body>

        <h3>You can log in here</h3>

        <%-- Form for user input --%>
        <form action="LoanCalc" method="POST">
            <div class="form-group">
                <label for="loanAmount">Loan amount</label>
                <input type="number" class="form-control" id="loanAmount" name="loanAmount" placeholder="Enter loan amount">
            </div>
            <div class="form-group">
                <label for="ARPC">ARPC</label>
                <input type="number" class="form-control" id="ARPC" name="ARPC" aria-describedby="ARPChelp" placeholder="Enter ARPC">
                <small id="ARPChelp" class="form-text text-muted">Annual Percentage Rate of Charge (ÅOP)</small>
            </div>
            <div class="form-group">
                <label for="duration">Duration in months</label>
                <input type="number" class="form-control" id="duration" name="duration" placeholder="Enter length of loan">
            </div>
            <div class="form-check">
                <input type="checkbox" class="form-check-input" id="monthYearChange">
                <label class="form-check-label" for="monthYearChange">Tick to change duration to years instead of months</label>
            </div>
            <button type="submit" class="btn btn-primary">Calculate</button>
        </form>

        <%-- Table for displaying result of user input --%>
        <div id="result" style="display:none;">
            <form action="/LoanCalc" method="POST">
                <input type="submit" name="showresult" id="txtSubmit" value="Result" />
            </form>
        </div>
        <div id="result">
    <pre>
            ${requestScope.utilOutput}
    </pre>
        </div>

    </jsp:body>
</t:pagetemplate>