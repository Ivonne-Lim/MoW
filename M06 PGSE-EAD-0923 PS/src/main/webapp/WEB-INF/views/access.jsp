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

      <p> <a href = "/home">Home</a> > Access </p> <br>

      <h1> <u>Access</u> </h1>

      <notification>

        <c:if test = "${empty login_error && empty login_success && empty logout_success}">
        <br>
        <br>
        <br>
        <br>
        </c:if>

        <c:if test = "${not empty login_error}">
        ${login_error} <br>
        <br>
        <i> Click here for <a href = "/register">Register</a>. </i> <br>
        <br>
        </c:if>

        <c:if test = "${not empty login_success}">
        ${login_success} <br>
        <br>
        <i> Click here for <a href = "/home">Home</a>. </i> <br>
        <br>
        </c:if>

        <c:if test = "${not empty logout_success}">
        ${logout_success} <br>
        <br>
        <i> Click here for <a href = "/access">Access</a>. </i> <br>
        <br>
        </c:if>

      </notification>

      <access>

        <c:if test = "${not empty login_success || not empty logout_success}">

        <br>
        <br>
        <br>
        <br>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>

        </c:if>

        <c:if test = "${empty login_success && empty logout_success}">

        <form action = "/login" method = "post">

          <table cellpadding = "10" cellspacing = "0">

            <tr>

              <td style = "border: 1px solid black" colspan = "2"> <h3> Credentials </h3> </td>

            </tr>
              
            <tr height = "38">

              <td> <p> </p> </td>

              <td> <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}"> </input> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <label for = "addressEmail"> Email Address / Login ID: </label> </td>

              <td style = "border: 1px solid black"> <input type = "text" id = "addressEmail" name = "address_email" size = "40" required = "true" /> <br>
                <br> </td>

            <tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <label for = "password"> Password: </label> </td>

              <td style = "border: 1px solid black"> <input type = "password" id = "password" name = "password" size = "10" required = "true" /> <br>
                <br> </td>

            <tr>

          </table>

          <br>
          <br>
        
          <input type = "submit" value = "Submit" />

          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>

          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>
          <br>

        </form>

        </c:if>

      </access>

    </main>

    <footer>

      <%@ include file = "footer.jsp" %>

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
