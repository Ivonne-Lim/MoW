<div style = "background-color: lightblue">

  <table cellpadding = "10">

    <tr style = "vertical-align: top">

      <td> <a href = "/home"> <img src = "/logo.jpg" alt = "Logo" width = "43" height = "40"> </a> </td>

      <td width = "100"> <p> </p> </td>

      <sec:authorize access = "!isAuthenticated()">
      <!-- Used with Spring Security -->

      <!-- c:if test = "${empty username}" -->
      <!-- Used without Spring Security -->

        <td width = "100"> <p> </p> </td>

        <td width = "100"> <p> </p> </td>

        <td width = "100"> <p> </p> </td>

        <td width = "100"> <p> </p> </td>

        <td width = "100"> <p> </p> </td>

      <!-- Used without Spring Security -->
      <!-- /c:if -->

      <!-- Used with Spring Security -->
      </sec:authorize>

      <sec:authorize access = "isAuthenticated()">
      <!-- Used with Spring Security -->

      <!-- c:if test = "${not empty username}" -->
      <!-- Used without Spring Security -->

        <td> <a href = "/management/plans"> Meal Plans </a> </td>

        <td> Member / Caregiver </td>

        <td> Food Service Provider (FSP) </td>

        <td> Rider </td>

        <td> <a href = "/management/reports"> Reports </a> </td>

      <!-- Used without Spring Security -->
      <!-- /c:if -->

      <!-- Used with Spring Security -->
      </sec:authorize>

      <td width = "100"> <p> </p> </td>

      <td> <a href = "/register"> Register </a> </td>

      <td>

      <sec:authorize access = "!isAuthenticated()">

        <form action = "/access" method = "get">
          <input type = "submit" name = "Access" value = "Login"> </input>
        </form>

      </sec:authorize>

      <sec:authorize access = "isAuthenticated()">

        <form action = "/access" method = "post">
          <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}"> </input>
          <input type = "submit" name = "Access" value = "Logout"> </input>
        </form>

      </sec:authorize>

      </td>

    </tr>

  </table>

</div>
