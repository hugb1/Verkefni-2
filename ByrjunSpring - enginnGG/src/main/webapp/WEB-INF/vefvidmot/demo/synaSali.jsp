<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">

<!-- author: Vilhjállmur Jónsson -->
<!-- email: vij7@hi.is -->
<!-- vefur sem birtir okkur töfluna með veislusölum -->
<!-- hér byrjar einnig bókunarferlið -->

<html>
    <head>
        <title>Veislusalir</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>

    </head>
    <body>
    	<header>
    		<section class ="headerSection">
    			<div class = "header1">
    				<div class = "loginToAdmin">
    					
    				</div>
    			</div>
    		</section>
   		 </header>
   		 <main>
   		 	<section class="GunnarSection">
   		 	<img class="salirIMG" src="https://notendur.hi.is/~vij7/asdf/salirLogo.jpg" alt="Salir.com logo">

   			 </section>
   		<section class="searchSection">

        	<div class="leitarTakkar">
        		<form class="nytt1" action="/demo/submit" method="post">

       			<div class ="locationID">
            		<select name=loc>
            			<option name=zero value="0">Staðsetning</option>
            			<option name=one value="1">Reykjavík</option>
            			<option name=two value="2">Hafnarfjörður</option>
            			<option name=three value="3">Garðsbær</option>
            			<option name=four value="4">Kópsvogur</option> 
           			</select>
            	</div>
            	</form>
				
				<form class="nytt2" action="/demo/submit" method="post">
				<div class ="maxRoom">
           			<select name=cap>
           				<option name=zero value="1">max Fjöldi</option>
           				<option name=one value="1">50</option>
           				<option name=two value="2">100</option>
            			<option name=three value="3">150</option>
            			<option name=four value="4">200+</option>
            		</select>
            	</div>
            	</form>
            	
            	<form class="nytt3" action="/demo/submit" method="post">
            	<div class ="tegundSals">
           			<select name=myradio>
           				<option name=zero value="">Tegund sals</option>
           				<option name=one value="1">Veislusalir</option>
           				<option name=two value="2">íþróttasalir</option>
            		</select>
            	</div>
            	</form>
            	
				<form class="nytt3" action="/demo/submit" method="post">
				<div class="leitarTakki">
					<button class="leitButton" name="1" type="submit" value="Leita">Leita</button>
            		
            	</div>
            	</form>
            	
            	<form class="nytt4" action="/demo/nyrSalur">
            	<div class="skraningarTakki">
            		<button class="skraButton" name="1" type="submit" value="Skrá sal">Skrá</button>
            	</div>
            	</form>
            </div>        	<div class="leitarTakkarr">
        		<form class="nytt1" action="/demo/submit" method="post">
        		<div class="leitarTakkar">

       			<div class ="locationID">
            		<select name=loc>
            			<option name=zero value="0">Staðsetning</option>
            			<option name=one value="1">Reykjavík</option>
            			<option name=two value="2">Hafnarfjörður</option>
            			<option name=three value="3">Garðabær</option>
            			<option name=four value="4">Kópsvogur</option> 
           			</select>
            	</div>
            	
				
				
				<div class ="maxRoom">
           			<select name=cap>
           				<option name=zero value="1">max Fjöldi</option>
           				<option name=one value="1">50</option>
           				<option name=two value="2">100</option>
            			<option name=three value="3">150</option>
            			<option name=four value="4">200+</option>
            		</select>
            	</div>
            	
            	
            	
            	<div class ="tegundSals">
           			<select name=myradio>
           				<option name=zero value="">Tegund sals</option>
           				<option name=one value="1">Veislusalir</option>
           				<option name=two value="2">íþróttasalir</option>
            		</select>
            	</div>
            	
            	
				
				<div class="leitarTakki">
					<button class="leitButton" name="1" type="submit" value="Leita">Leita</button>
            		
            	</div>
            	
            	</form>
            	<form class="nytt4" action="/demo/nyrSalur">
            	<div class="skraningarTakki">
            		<button class="skraButton" name="1" type="submit" value="Skrá sal">Skrá</button>
            	</div>
            	</form>
            	</div>
            </div>
        </section>
        <section class="infoSection">
        	<div class="infoInfo">
				<c:choose>
        			<c:when test="${not empty veislusalir}">
            			<table class="veislusalir">
                			<thead>
                    			<tr>
                        			<th>Heiti</th>
				                    <th>Fjöldi</th>
				                    <th>Bær</th>
				                    <th>Gata</th>
				                    <th>Verð</th>
				                    <th>Bókunar Nr.</th>
                       		 </tr>
                        	</thead>
                       		<c:forEach var = "banquet" items = "${veislusalir}">
                        		<tbody>
                        		<tr>
                        			<td>${banquet.name} </td>
                        			<td>${banquet.getMax()} </td>
                        			<td>${banquet.getLocation()} </td>
                        			<td>${banquet.getAddress()} </td>
                        			<td>${banquet.getPrice()} </td>
                        			<td>${banquet.getId()} </td>
                        		</tr>
                        		</tbody>
                        	</c:forEach>
                     	</table>
                	 </c:when>
             	 	<c:otherwise>
             	 		<h3>Engir veislusalir</h3>
             	 	</c:otherwise>
             	</c:choose>
             	<div class="bokasalinn">
                <form action="/demo/bokaSal" method="post">

					<p class="bokunarTexti1"> Sláðu inn Bókunar Nr:<p> <input name = "bokunNr" required minlength="1" maxlength="1000" type = "text"/>



					<input type = "submit" value = "Bóka!"/>
				</form>
				</div>
        	</div>


        </section>

        </main>
        <footer>
        	<div class="followUs">
        		<p>Follow us for more information!<p>
        		<img class="facebook" src="https://notendur.hi.is/~vij7/asdf/facebook-icon@3x.png" alt="facebook icon" height="42" width="42">
        		<img class="twitter" src="https://notendur.hi.is/~vij7/asdf/twitter-icon@3x.png" alt="facebook icon" height="42" width="42">

        		<p class="SalirTexti1">Salir.com</p>
        	</div>
     	</footer>
    </body>
</html>

  
