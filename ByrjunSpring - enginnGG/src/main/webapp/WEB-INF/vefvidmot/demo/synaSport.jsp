<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Allir kennarar </title>  
    
</head>
<body>
    <c:choose>
        <c:when test="${not empty sportsalir}">
            <table class="sportsalir">
                <thead>
                    <tr>
                        <th>Heiti</th>
                        <th>Bær</th>
                        <th>Verð</th>
                        </tr>
                        </thead>
                        <c:forEach var = "sportVenues" items = "${sportsalir }">
                        	<tr>
                        		<td>${sportVenues.name} </td>
                        		<td>${sportVenues.getLocation()} </td>
                        		<td>${SportVenues.getPrice()} </td>
                        	</tr>
                        </c:forEach>
                     </table>
                 </c:when>
             	 <c:otherwise>
             	 	<h3> Engir sportsalir </h3>
             	 </c:otherwise>
             </c:choose>
</body>
</html>