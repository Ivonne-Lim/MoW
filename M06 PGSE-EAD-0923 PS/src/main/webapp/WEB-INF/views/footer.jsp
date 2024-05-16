<div style = "background-color: lightblue">

  <table cellpadding = "10">

    <tr style = "vertical-align: top">

      <td> About Us </td>

      <td> Contact Us </td>

      <td width = "100"> <p> </p> </td>

      <td> <p> </p> </td>

      <td colspan = "2">

        Sitemap<br>
        
      </td>

      <td> <p> </p> </td>

      <td width = "100"> <p> </p> </td>

      <td> Privacy Policy </td>

      <td> Terms of Use </td>

    </tr>

    <tr style = "vertical-align: top">

      <td> <p> </p> </td>

      <td>

        <i>

          Telephone: <br>
          6324 9730 <br>

          <br>

          Email: <br>
          support@mow.mm.org <br>

          <br>

        </i>

      </td>

      <td width = "100"> <p> </p> </td>

      <td width = "100"> <p> </p> </td>

      <td>

        <i>

          <a href = "/home"> Home </a> <br>

          <br>

        </i>

        <br>

        <sec:authorize access = "!isAuthenticated()">
        <!-- Used with Spring Security -->

        <!-- c:if test = "${empty username}" -->
        <!-- Used without Spring Security -->

          <p> </p> <br>

          <p> </p> <br>

          <br>

        <!-- Used without Spring Security -->
        <!-- /c:if -->

        <!-- Used with Spring Security -->
        </sec:authorize>

        <sec:authorize access = "isAuthenticated()">
        <!-- Used with Spring Security -->

        <!-- c:if test = "${not empty username}" -->
        <!-- Used without Spring Security -->

        <i>

          <a href = "/management/plans"> Meal Plans </a> <br>

          Member / Caregiver <br>

          <br>

        </i>

        <!-- Used without Spring Security -->
        <!-- /c:if -->

        <!-- Used with Spring Security -->
        </sec:authorize>

      </td>

      <td>

        <i>

          <a href = "/register"> Register </a> <br>

          <sec:authorize access = "!isAuthenticated()">

          <form action = "/access" method = "get" name = "access">
            <a href = "javascript:document.forms['access'].submit()"> Login </a>
          </form>

          </sec:authorize>

          <sec:authorize access = "isAuthenticated()">
        
          <form action = "/access" method = "post" name = "access">
            <input type = "hidden" name = "${_csrf.parameterName}" value = "${_csrf.token}"> </input>
            <a href = "javascript:document.forms['access'].submit()"> Logout </a>
          </form>

          </sec:authorize>

        </i>

        <br>

        <sec:authorize access = "!isAuthenticated()">
        <!-- Used with Spring Security -->

        <!-- c:if test = "${empty username}" -->
        <!-- Used without Spring Security -->

          <p> </p> <br>

          <p> </p> <br>

          <p> </p> <br>

        <!-- Used without Spring Security -->
        <!-- /c:if -->

        <!-- Used with Spring Security -->
        </sec:authorize>

        <sec:authorize access = "isAuthenticated()">
        <!-- Used with Spring Security -->

        <!-- c:if test = "${not empty username}" -->
        <!-- Used without Spring Security -->

        <i>

          <a href = "/management/reports"> Reports </a> <br>

          Food Service Provider (FSP) <br>

          Rider <br>

        </i>

        <!-- Used without Spring Security -->
        <!-- /c:if -->

        <!-- Used without Spring Security -->
        </sec:authorize>

      </td>

      <td width = "100"> <p> </p> </td>

      <td width = "100"> <p> </p> </td>
         
      <td style = "border: 1px solid black">

        <i>

          Website by: <br>
          Ivonne Lim <br>

          <br>

          Copyright: <br>
          MerryWheels <br>

          <br>

        </i>

      </td>

      <td style = "border: 1px solid black"> <img src = "/ivonne-lim.jpg" alt = "Ivonne Lim" width = "90" height = "100"> </td>

    </tr>

  </table>

</div>
