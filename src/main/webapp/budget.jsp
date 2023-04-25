<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:body>

        <t:info>
            <h1 class="card-title">Budget Calculator</h1>
            <p class="card-text">
                You can use this to make a budget and see your incomes and expenses.
            </p>
            <form method="post" action="budgetcalculate">
                <div class="form-group">
                    <label for="income">Income:</label>
                    <select class="form-control" name="income" id="income">
                        <option value="single">Single</option>
                        <option value="couple">Couple</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="incomeAmount">Income amount:</label>
                    <input type="text" class="form-control" id="incomeAmount" name="amount">
                </div>
                <button type="submit" class="btn btn-primary" name="action" value="income">Add</button>
            </form>
            <form method="post" action="budgetcalculate">
                <div class="form-group">
                    <label for="expense">Expense:</label>
                    <select class="form-control" name="expense" id="expense">
                        <option value="rent">Rent</option>
                        <option value="food">Food</option>
                        <option value="transport">Transport</option>
                        <option value="insurance">Insurance</option>
                        <option value="subscription">Subscription</option>
                        <option value="miscellaneous">Miscellaneous</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="expenseAmount">Expense amount:</label>
                    <input type="text" class="form-control" id="expenseAmount" name="amount">
                </div>
                <button type="submit" class="btn btn-primary" name="action" value="expense">Add</button>
            </form>
        </t:info>

        <t:content>

                <table class="table">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Amount</th>
                        <th>
                            <form method="post" action="budgetcalculate">
                                <button type="submit" class="btn btn-danger" name="action" value="clear">clear</button>
                            </form>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="2"><strong>Income:</strong></td>
                    </tr>

                    <c:forEach items="${requestScope.budgetCalcSelectedIncomes}" var="income">
                        <tr>
                            <td>${income.name}</td>
                            <td>${income.amount}</td>
                        </tr>

                    </c:forEach>

                    <tr>
                        <td colspan="2"><strong>Expense:</strong></td>
                    </tr>
                    <c:forEach items="${requestScope.budgetCalcSelectedExpenses}" var="expense">
                        <tr>
                            <td>${expense.name}</td>
                            <td>-${expense.amount}</td>
                        </tr>

                    </c:forEach>
                    <tr>
                        <td colspan="2"><strong>Balance:</strong></td>
                        <td><h4>${requestScope.budgetCalcBalance}</h4></td>
                    </tr>
                    </tbody>
                </table>
            <form method="post" action="budgetcalculate">
                <button type="submit" class="btn btn-primary" name="action" value="download">Download CSV</button>
            </form>

        </t:content>
    </jsp:body>
</t:pagetemplate>