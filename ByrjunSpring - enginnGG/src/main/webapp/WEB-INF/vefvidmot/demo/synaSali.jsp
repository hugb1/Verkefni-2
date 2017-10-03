<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<head>
    <title>Allir kennarar </title>  
    
</head>
<body>
    <c:choose>
        <c:when test="${not empty veislusalir}">
            <table class="veislusalir">
            
                <thead>
                	<table border="1">
                    <tr>
                        <th>Heiti</th>
                        <th>Fjöldi</th>
                        <th>Bær</th>
                        <th>Gata</th>
                        <th>Verð</th>
                        <th>Bókunar Nr.</th>
                        </tr>
                        </thead>
                        <c:forEach var = "banquet" items = "${veislusalir }">
                        	<tr>
                        		<td>${banquet.name} </td>
                        		<td>${banquet.getMax()} </td>
                        		<td>${banquet.getLocation()} </td>
                        		<td>${banquet.getAddress()} </td>
                        		<td>${banquet.getPrice()} </td>
                        		<td>${banquet.getId()} </td>
                        	</tr>
                        </c:forEach>
                     </table>
                 </c:when>
             	 <c:otherwise>
             	 	<h3> Engir veislusalir </h3>
             	 </c:otherwise>
             </c:choose>
</body>
<footer>
</footer>
</html>