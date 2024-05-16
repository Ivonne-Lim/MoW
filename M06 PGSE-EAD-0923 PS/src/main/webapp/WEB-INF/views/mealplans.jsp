<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/security/tags" prefix = "sec" %>

<!DOCTYPE html>
<html lang = "en">

  <head>

    <meta charset="UTF-8">

    <meta name = "description" content = "Meals on Wheels">
    <meta name = "author"      content = "Ivonne Lim">

    <meta name = "viewport"    content = "width = device-width, initial-scale = 1.0">

    <title> Meals on Wheels </title>

    <link href = "/styles.css" rel = "stylesheet">

  </head>

  <body>

    <header>

      <%@ include file = "header.jsp" %>

    </header>

    <main style = "margin: 10px">

      <p> <a href = "/home">Home</a> > Meal Plans </p> <br>

      <h1> <u>Meal Plans</u> </h1>

      <meal-plans>

        <table cellpadding = "10" cellspacing = "0">

          <tr>

            <th style = "border: 1px solid black"> ID </th>

            <th style = "border: 1px solid black"> Sequence </th>

            <th style = "border: 1px solid black"> FSP </th>

            <th style = "border: 1px solid black"> Diet </th>

            <th style = "border: 1px solid black"> Meal </th>

            <th style = "border: 1px solid black"> Action </th>

          </tr>

          <c:if test = "${empty mealPlans}">

          <tr>

            <td style = "border: 1px solid black" width = "50"> </td>

            <td style = "border: 1px solid black" width = "50"> </td>

            <td style = "border: 1px solid black" width = "400"> </td>

            <td style = "border: 1px solid black" width = "50"> </td>

            <td style = "border: 1px solid black" width = "100"> </td>

            <td style = "border: 1px solid black" width = "50"> </td>

          <tr>

          </c:if>

          <c:forEach items = "${mealPlans}" var = "mealPlan">

          <tr>

            <td style = "border: 1px solid black"> ${mealPlan.id} </td>

            <td style = "border: 1px solid black"> ${mealPlan.sequence} </td>

            <td style = "border: 1px solid black"> ${mealPlan.fsp.nameGiven} ${mealPlan.fsp.nameFamily} </td>

            <td style = "border: 1px solid black"> ${mealPlan.diet.type} </td>

            <td style = "border: 1px solid black"> ${mealPlan.meal} </td>

            <td style = "border: 1px solid black"> <a href = "/management/plan?id=${mealPlan.id}"> Edit </a> <br> <a href = "/management/plan_deletion?id=${mealPlan.id}"> Delete </a> </td> 

          </tr>

          </c:forEach>

        </table>

        <br>
        <br>

        <form action = "/management/plan" method = "get">
          <input type = "submit" name = "Add" value = "Add" />
        </form>

        <br>
        <br>

      </meal-plans>

    </main>

    <footer>

      <!-- Excluded footer.jsp -->

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
