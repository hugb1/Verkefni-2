<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<head>
    <title>Allir kennarar </title>  
    
</head>
<body>
    <c:choose>
        <c:when test="${not empty veislusalir}">
            <table class="veislusalir">
                <thead>
                    <tr>
                        <th>Heiti</th>
                        <th>Fjöldi</th>
                        <th>Bær</th>
                        <th>Verð</th>
                        </tr>
                        </thead>
                        <c:forEach var = "banquet" items = "${veislusalir }">
                        	<tr>
                        		<td>${banquet.name} </td>
                        		<td>${banquet.getMax()} </td>
                        		<td>${banquet.getLocation()} </td>
                        		<td>${banquet.getPrice()} </td>
                        	</tr>
                        </c:forEach>
                     </table>
                 </c:when>
             	 <c:otherwise>
             	 	<h3> Engir veislusalir </h3>
             	 </c:otherwise>
             </c:choose>
</body>
</html>