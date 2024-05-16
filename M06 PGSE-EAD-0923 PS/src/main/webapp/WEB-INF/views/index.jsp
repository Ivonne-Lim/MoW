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

      <h1> <u>Meals on Wheels</u> </h1>

      <h2> Launch Event </h2>   
      May Day in year 2024 marked the launch of the Meals on Wheels service by MerryMeals.<br>
      <br>

      MerryMeals is a charitable organization that prepares and delivers a hot noon meal to qualified adults living at home<br>
      who are unable to cook for themselves or maintain their nutritional status due to age, disease or disability.<br>
      <br>

      <img src = "/delivery.jpg" alt = "Delivery" width = "299" height = "166"><br>
      <br>

      The service will be available Monday through Friday. Frozen meals will be provided to members who are not<br>
      within a 10-kilometer radius of their outsourced kitchens and support over the weekend. MerryMeals has partnered with<br>
      several food service providers across the country to provide the quickest delivery possible.<br>
      <br>
      Already 100 qualified members have registered and partnership made with 25 delivery volunteers and 6 food service providers<br>
      located at the north-west, north, north-east, south-west, south and south-east regions of Singapore. Games and<br>
      a lunch reception were held with them to celebrate the launch.<br>
      <br>

      <img src = "/meal-preparation.jpg" alt = "Meal Preparation" width = "299" height = "257"> 

      <br>
      <br>

    </main>

    <footer>

      <%@ include file = "footer.jsp" %>

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
