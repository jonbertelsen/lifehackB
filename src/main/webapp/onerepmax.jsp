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
    // Get the HTML form element by its ID
    const form = document.getElementById('calc-form');
    // Get the HTML output element by its ID
    const output = document.getElementById('res');

    // Add an event listener to the form for the 'submit' event
    form.addEventListener('submit', (event) => {
        // Prevent the default form submission behavior, which would cause a page reload
        event.preventDefault();
        // Get the value of the 'a' input field and convert it to an integer
        const weight = parseInt(form.a.value);
        // Get the value of the 'b' input field and convert it to an integer
        const reps = parseInt(form.b.value);
        // Calculate the one-rep max for the given weight and reps
        const oneRepMax = (weight / (1.0278 - 0.0278 * reps)).toFixed(2);
        // Set the value of the output element to the one-rep max followed by the string "KG"
        output.value = oneRepMax + " KG";
    });
</script>


</body>
</html>
