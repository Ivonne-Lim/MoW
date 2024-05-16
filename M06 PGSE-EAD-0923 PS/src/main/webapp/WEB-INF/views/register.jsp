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

      <p> <a href = "/home">Home</a> > Register </p> <br>

      <h1> <u>Register</u> </h1>
      
      <form:form action = "/register" method = "post" modelAttribute = "actor">

        <profile>

          <table cellpadding = "10" cellspacing = "0" style = "float: left">

            <tr>

              <td style = "border: 1px solid black" colspan = "2"> <h3> Profile </h3> </td>

            </tr>
              
            <tr height = "38">

              <td> <form:label path = "id"> </form:label> </td>

              <td> <form:hidden path = "id" /> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "nameGiven"> Given Name: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "nameGiven" size = "40" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "nameFamily"> <span style = "color: blue">Family Name (Optional):</span> </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "nameFamily" size = "40" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "addressEmail"> Email Address / Login ID: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "addressEmail" size = "40" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "password"> Password: </form:label> </td>

              <td style = "border: 1px solid black"> <form:password path = "password" size = "10" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "role"> Role: </form:label> </td>

              <td style = "border: 1px solid black"> <form:select path = "role"> <br>

                  <form:option value = "Caregiver"  label = "Caregiver"  />
                  <form:option value = "Member"     label = "Member"     />
                  <form:option value = "FSP"        label = "FSP"        />
                  <form:option value = "Rider"      label = "Rider"      />
                  <form:option value = "Management" label = "Management" />

                </form:select> <br>
                <br> </td>

            </tr>

            <tr>

            <c:if test = "${empty actor || (actor.role != 'FSP' && actor.role != 'Rider')}">

              <td> <p> </p> </td>

              <td> <p> </p> <br>
                <br> </td>

            </c:if>

            <c:if test = "${not empty actor && (actor.role == 'FSP' || actor.role == 'Rider')}">

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "type"> Type: </form:label> </td>

              <td style = "border: 1px solid black"> <form:select path = "type">

                  <form:option value = "Partner"   label = "Partner"   />
                  <form:option value = "Volunteer" label = "Volunteer" />

                </form:select> <br>
                <br> </td>

            </c:if>

            </tr>

            <tr>

              <td valign = "top"> <form:label path = "status"> Status: </form:label> </td>

              <td> <c:if test = "${empty actor || actor.status == null}"> - </c:if>
                   <c:if test = "${not empty actor && actor.status != null}"> ${actor.status} </c:if> <br>
                <br> </td>

            </tr>

          </table>

        </profile>

        <others>

          <table cellpadding = "10" cellspacing = "0" style = "padding: 0px 20px">

            <tr>

              <td style = "border: 1px solid black" colspan = "2"> <h3> Other Details </h3> </td>

            </tr>
              
            <tr height = "38">

              <td> <p> </p> </td>

              <td> <p> </p> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "contact"> Contact: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "contact" size = "10" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "addressStreet"> Street Address: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "addressStreet" size = "40" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "addressUnit"> <span style = "color: blue">Unit (Optional):</span> </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "addressUnit" size = "10" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "addressPostal"> Postal Code: </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "addressPostal" size = "6" required = "true" /> <br>
                <br> </td>

            </tr>

            <tr>

              <td style = "border: 1px solid black" valign = "top"> <form:label path = "note"> <span style = "color: blue">Note (Optional):</span> </form:label> </td>

              <td style = "border: 1px solid black"> <form:input path = "note" size = "40" /> <br>
                <br> </td>

            </tr>

            <tr>

            <c:if test = "${empty actor || (actor.role != 'Member')}">

              <td> <p> </p> </td>

              <td> <p> </p> <br>
                <br> </td>

            </c:if>

            <c:if test = "${not empty actor && (actor.role == 'Member')}">

              <td style = "border: 1px solid black" valign = "top"> <label for = "diet_id"> Diet: </label> </td>

              <td style = "border: 1px solid black"> <select id = "diet_id" name = "diet_id">

                <c:forEach items = "${diets}" var = "diet">
                <option value = "${diet.id}" <c:if test = "${actor.diet.id == diet.id}"> selected </c:if> > ${diet.type} </option>
                </c:forEach>

                </select> <br>
                <br> </td>

            </c:if>

            </tr>

            <tr>

            <c:if test = "${empty actor || (actor.role != 'Member')}">

              <td> <p> </p> </td>

              <td> <p> </p> <br>
                <br> </td>

            </c:if>

            <c:if test = "${not empty actor && (actor.role == 'Member')}">

              <td style = "border: 1px solid black" valign = "top"> <label for = "caregiver_id"> Caregiver: </label> </td>

              <td style = "border: 1px solid black"> <select id = "caregiver_id" name = "caregiver_id">

                <option value = ""> </option>

                <c:forEach items = "${caregivers}" var = "caregiver">
                <option value = "${caregiver.id}" <c:if test = "${actor.caregiver.id == caregiver.id}"> selected </c:if> > ${caregiver.nameGiven} ${caregiver.nameFamily} </option>
                </c:forEach>

                </select> <br>
                <br> </td>

            </c:if>

            </tr>

          </table>

        </others>

        <br>
        <br>
        
        <form:button> Submit </form:button>

        <br>
        <br>
        <br>
        <br>


      </form:form>

    </main>

    <footer>

      <%@ include file = "footer.jsp" %>

    </footer>

    <script src = "/scripts.js" type = "text/javascript"> </script>

  </body>

</html>
