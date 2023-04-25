<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        Budget Calculator
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form method="post" action="calculate">
                        <div class="form-group">
                            <label for="income">Income:</label>
                            <select class="form-control" name="income" id="income">
                                <option value="single">Single</option>
                                <option value="couple">Couple</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="incomeAmount">Income amount:</label>
                            <input type="text" class="form-control" id="incomeAmount" name="incomeAmount">
                        </div>
                        <button type="submit" class="btn btn-primary" name="action" value="add">Add</button>
                        <br>
                        <br>
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
                            <input type="text" class="form-control" id="expenseAmount" name="expenseAmount">
                        </div>
                        <button type="submit" class="btn btn-primary" name="action" value="add">Add</button>
                    </form>
                    <br>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Income/Expense</th>
                            <th>Name</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${selectedItems}" var="item">
                            <tr>
                                <td>${item.incomeExpense}</td>
                                <td>${item.name}</td>
                                <td>${item.getAmount()}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td colspan="2"><strong>Total:</strong></td>
                            <td>${totalIncome - totalExpense}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</t:pagetemplate>