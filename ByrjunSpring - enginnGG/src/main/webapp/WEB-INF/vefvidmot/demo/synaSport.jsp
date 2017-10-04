<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
    <title>Allir kennarar </title>  
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
</head>
<body>
    <c:choose>
        <c:when test="${not empty sportsalir}">
            <table class="sportsalir">
                <thead>
                	<table border="1">
                    <tr>
                        <th>Heiti</th>
                        <th>Bær</th>
                        <th>Gata</th>
                        <th>Verð</th>
                        <th>Bókunar Nr.</th>
                        </tr>
                        </thead>
                        <c:forEach var = "sportVenues" items = "${sportsalir }">
                        	<tr>
                        		<td>${sportVenues.name} </td>
                        		<td>${sportVenues.getLocation()} </td>
                        		<td>${SportVenues.getAddress()} </td>
                        		<td>${SportVenues.getPrice()} </td>
                        		<td>${SportVenues.getID()} </td>
                        	</tr>
                        </c:forEach>
                     </table>
                 </c:when>
             	 <c:otherwise>
             	 	<h3> Engir sportsalir </h3>
             	 </c:otherwise>
             </c:choose>
</body>
<footer>
	<form action="/demo/bokaSport" method="post">
	<table><tr>
		<td> Sláðu inn Bókunar Nr:</td><td> <input name = "bokunNr" type = "text"/></td>
		</tr>
	</table>
		<input type = "submit" value = "Bóka!"/>
	</form>
</footer>
</html>