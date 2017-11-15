<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: Vilhjállmur Jónsson-->
<!-- email: vij7@hi.is -->
<!-- vefur fyrir breytingu veitingasala -->
<html>
    <head>
        <title>Breyta upplýsingum</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
         
    </head>
    <body>
    	<header>
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
        	<div class="infoInfoNyrSalur">
				<form class="LoL4" action="/demo/breytaSal" method="post">
				<p class="salurHausTexti">Breyttu upplýsingum um salinn hér!</p>
            			
						<label for="stadur">Staðsetning sals</label>
						<div class="selStadur">
							<select id="stadur" name="location">
								<option name=default value = "${locNr}">${banquet.getLocation()}</option>
  								<option name=one value="1">Reykjavík</option>
  								<option name=two value="2">Hafnarfjörður</option>
  								<option name=three value="3">Garðabær</option>
  								<option name=four value="4">Kópavogur</option>
  							</select> 
  						</div>

  						<label for="nafn">Nafn á sal</label>
  						<div class="salurNafn">
  							<input id="nafn" name="nafn" type="text" required minlength="1" maxlength="30" value = "${banquet.getName()}">
  						</div>
  						
  						<label for="gata">Götuheiti</label>
  						<div class="salurGata">
  							<input id="gata" name="streetAddrs" type="text" required minlength="1" maxlength="30" value = "${banquet.getAddress()}">
  						</div>
  						
  						<label for="fjoldi">Max fjöldi</label>
  						<div class="salurFjoldi">
  							<input id="fjoldi" name="maxppl" type="text" required minlength="1" maxlength="5000" placeholder="Max people"value = "${banquet.getMax()}">
  						</div>
  						
  						<label for="verd"> Verð í Kr.</label>
  						<div class="salurVerd">
  							<input id="verd" name="price" type="text" required minlength="1" maxlength="9999999999999" value = "${banquet.getPrice()}">
  						</div>
  						
  						<label for="simi"> Símanúmer</lable>
  						<div class="salurSimi">
  							<input id="simi" name="phonenr" type="text" required minlength="7" maxlength="7" value = "${banquet.getPhonenr()}">
  						</div>
  						
  						<label for="netfang"> Netfang</lable>
  						<div class="salurNetfang">
  							<input id="netfang" name="email" type="email"  value = "${banquet.getEmail()}">
  						</div>
  						<label for="Lýsing á sal"> Lýsing á sal</lable>
  						<div class="salurdescript"> 
  							<textarea id = "lysing" name="lysing" maxlength="600">${banquet.getDescription()}</textarea>
  						</div>
  						<div class="drasl2">
  							<input type="hidden" name="id" value = "${banquet.getId()}">
  						</div>
  						
  						<div class="drasl1">
  							<input type="hidden" name="origLoc" value = "${banquet.getLocation()}">
  						</div>
  						
  						<div class="stadfestaTakki">
  							<button class="stadfesta" type="submit" value="Staðfesta">Staðfesta breytingar</button>
						</div>
						
				</form>
				<form class="LoL2" action="/demo/eydaSal" method="post">
					<div class="innskratakki">
						<button class="innskra" type="submit" value="Eyða Sal">Eyða sal</button>
					</div>
					<div class="innskratakki">
  						<input type="hidden" name="id" value = "${banquet.getId()}">
  					</div>
				</form>
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
