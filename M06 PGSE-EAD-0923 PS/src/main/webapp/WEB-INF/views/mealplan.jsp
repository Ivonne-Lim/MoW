<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form" %>
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

      <p> <a href = "/home">Home</a> > <a href = "/management/plans">Meal Plans</a> > Meal Plan </p> <br>

      <h1> <u>Meal Plan</u> </h1>

      <meal-plan>

        <form:form action = "/management/plan" method = "post" modelAttribute = "mealPlan">

          <table cellpadding = "10" cellspacing = "0">

            <tr height = "38">

              <td style = "border: 1px solid black"> <form:label path = "id"> </form:label> ID: </td>

              <c:if test = "${mealPlan.id == 0}">
              <td style = "border: 1px solid black"> - </td>
              </c:if>

              <c:if test = "${mealPlan.id != 0}">
              <td style = "border: 1px solid black"> <form:hidden path = "id" /> ${mealPlan.id} </td>
              </c:if>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "sequence"> Sequence: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "sequence" size = "10" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <label for = "fsp_id"> FSP: </label> </td>

              <td style = "border: 1px solid black"> <select id = "fsp_id" name = "fsp_id">

                <c:forEach items = "${fsps}" var = "fsp">
                <option value = "${fsp.id}" <c:if test = "${mealPlan.fsp.id == fsp.id}"> selected </c:if> > ${fsp.nameGiven} ${fsp.nameFamily} </option>
                </c:forEach>

                </select> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <label for = "diet_id"> Diet: </label> </td>

              <td style = "border: 1px solid black"> <select id = "diet_id" name = "diet_id">

                <c:forEach items = "${diets}" var = "diet">
                <option value = "${diet.id}" <c:if test = "${mealPlan.diet.id == diet.id}"> selected </c:if> > ${diet.type} </option>
                </c:forEach>

                </select> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "meal"> Meal: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "meal" size = "10" required = "true" /> <br>
                <br> </td>

            </tr>

          </table>

          <br>
          <br>

          <input type = "submit" name = "Submit" value = "Submit" />

          <br>
          <br>

        </form:form>

      </meal-plan>

    </main>

    <footer>

      <!-- Excluded footer.jsp -->

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
