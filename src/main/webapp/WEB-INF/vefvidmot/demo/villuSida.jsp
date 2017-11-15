<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: Pétur Logi Pétursson -->
<!-- email: plp2@hi.is -->
<!-- vefur fyrir /error, whitelabel villur -->

<head>
    <title>Villa í slóðinni </title>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
</head>
<body>
    		<section class ="headerSection">
    				<div class = "loginToAdmin">
    				<form action="/demo/innskra">
						<div class="innskratakki">
						<button class="innskraLog" name="1" type="submit" value="innskra">Innskrá</button>
					</form>
    				</div>	
    		</section>
   		 </header>
   		 <main>
   		 	<section class="GunnarSection">
   		 	<img class="salirIMG" src="https://notendur.hi.is/~vij7/asdf/salirLogo.jpg" alt="Salir.com logo">
   		 
   			 </section>
   		<section class="searchSection">

        	<div class="leitarTakkarr">
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
         	<div class="skraLokidInfo">
        		<p class="skraningTokstTexti">Komið hefur upp villa við innslátt á upplýsingum</p>
   	 			<p class="villuTexti"> ${attrs.status} ${attrs.error} </h3>
    			<p class="takkFyrirTexti">${attrs.message}</p>
        	</div>
        </section>
        
        </main>
        <footer>
        	<div class="followUs">
        		<p>Fylgið okkur á samfélagsmiðlum!<p>
        		<img class="facebook" src="https://notendur.hi.is/~vij7/asdf/facebook-icon@3x.png" alt="facebook icon" height="42" width="42">
        		<img class="twitter" src="https://notendur.hi.is/~vij7/asdf/twitter-icon@3x.png" alt="facebook icon" height="42" width="42">
        		
        		<p class="SalirTexti1">Salir.com</p>
        	</div>
     	</footer>  
</body>

</html>