<%--
  Created by IntelliJ IDEA.
  User: martinthuren
  Date: 24/04/2023
  Time: 20.12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<style>
    h1 {
        text-align: center;
        color: blue;
    }

    p {
        text-align: center;
        color: black;
    }

    .calculator {
        margin: 10px;
        text-align: center;
    }

    .button {
        margin: 10px;
    }


</style>
<head>
    <title>Calculate your one rep max!</title>
</head>
<body>
<h1>One-rep max calculator</h1>
<p>Calculate your one-rep max (1RM) for any lift. Your one-rep max is the max weight you can lift for a single repetition for a given exercise.</p>

</div>
<div class="calculator">
<form id="calc-form" action="/lifehackB_war_exploded/onerepmax.jsp">
    <label>Enter weight:</label><br>
    <input type="number" name="a" value=""/><br>
    <label>Enter amount of reps:</label><br>
    <input type="number" name="b" value=""><br>
    <input class="button" type="submit" value="Calculate">
    <p>Your one rep max is:</p>
    <output id="res"></output>
</form>
</div>

<script>
    const form = document.getElementById('calc-form');
    const output = document.getElementById('res');

    form.addEventListener('submit', (event) => {
        event.preventDefault();
        const weight = parseInt(form.a.value);
        const reps = parseInt(form.b.value);
        const oneRepMax = (weight / (1.0278 - 0.0278 * reps)).toFixed(2);
        output.value = oneRepMax + " KG";
    });
</script>

</body>
</html>
