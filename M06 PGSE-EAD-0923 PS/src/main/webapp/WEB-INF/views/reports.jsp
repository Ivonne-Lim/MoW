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

      <p> <a href = "/home">Home</a> > Reports </p> <br>

      <h1> <u>Reports</u> </h1>

      Date of Reports: <span id = "date-display"> </span> <br>
      <br>

      <script type = "text/javascript">

        var today = new Date();
        var date = today.getFullYear() + '-' + (today.getMonth()+1) + '-' + today.getDate();

        document.getElementById("date-display").innerHTML = date;

      </script>

      <report-1>

        <table cellpadding = "10" cellspacing = "0">

          <tr>

            <td style = "border: 1px solid black" colspan = "2"> <h3> Report #1: Stakeholders </h3> </td>

          </tr>
              
          <tr>

            <td> <p> </p> </td>

            <td> <p> </p> </td>

          </tr>

          <tr>

            <td style = "border: 1px solid black"> Number of Caregivers: </td>

            <td style = "border: 1px solid black"> ${caregivers} </td>

          </tr>

          <tr>

            <td style = "border: 1px solid black"> Number of Members: </td>

            <td style = "border: 1px solid black"> ${members} </td>

          </tr>

          <tr>

            <td style = "border: 1px solid black"> Number of Food Service Providers (FSPs): </td>

            <td style = "border: 1px solid black"> ${fsps} </td>

          </tr>

          <tr>

            <td style = "border: 1px solid black"> Number of Riders: </td>

            <td style = "border: 1px solid black"> ${riders} </td>

          </tr>

          <tr>

            <td style = "border: 1px solid black"> Number of Managers: </td>

            <td style = "border: 1px solid black"> ${managers} </td>

          </tr>

        </table>

      </report-1>

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

    </main>

    <footer>

      <%@ include file = "footer.jsp" %>

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
