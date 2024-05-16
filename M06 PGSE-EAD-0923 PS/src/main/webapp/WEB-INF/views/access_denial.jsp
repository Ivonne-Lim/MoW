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

      <p> <a href = "/home">Home</a> > Access Denial </p> <br>

      <h1> <u>Access Denial</u> </h1>
      
      <error>

        <table cellpadding = "5" cellspacing = "0">

          <tr>

            <td style = "border: 1px solid black"> <h4> Message: </h4> </td>

            <td style = "border: 1px solid black"> <h4> Your role does not have access to this web page. </h4> </td>

          </tr>

        </table>

        <br>
        <br>

        <form action = "/home" method = "get">
          <input type = "submit" name = "Back" value = "Back"> </input>
        </form>

        <br>
        <br>

      </error>

    </main>

    <footer>

      <!-- Excluded footer.jsp -->

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
