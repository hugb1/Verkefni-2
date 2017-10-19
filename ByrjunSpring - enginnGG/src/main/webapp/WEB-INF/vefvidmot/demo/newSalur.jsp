<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: Vilhjállmur Jónsson & Pétur L Pétursson -->
<!-- email: vij7@hi.is -->
<!-- vefur fyrir skráningu nýrra sala -->
<html>
    <head>
        <title>Search</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
         
    </head>
    <body>
    	<header>
    		<section class ="headerSection">
    			<div class = "header1">
    				<div class = "loginToAdmin">
    					<p> Innskráning </p>
    				</div>	
    			</div>
    		</section>
   		 </header>
   		 <main>
   		 	<section class="GunnarSection">
   		 	<img class="salirIMG" src="https://notendur.hi.is/~vij7/asdf/salirLogo.jpg" alt="Salir.com logo">
   		 
   			 </section>
   		<section class="searchSection">

        	<div class="searchForm">
        		<form class="LoL" action="/demo/submit" method="post">

       			<div class ="locationID">
            		<select name=loc>
            			<option name=zero value="0">Staðsetning</option>
            			<option name=one value="1">Reykjavík</option>
            			<option name=two value="2">Hafnarfjörður</option>
            			<option name=three value="3">Garðsbær</option>
            			<option name=four value="4">Kópsvogur</option> 
           			</select>
            	</div>

				<div class ="maxRoom">
           			<select name=cap>
           				<option name=zero value="0">max Fjöldi</option>
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
            	
            	<form class="LoL1" action="/demo/nyrSalur">
            	<div class="skraningarTakki">
            		<button class="skraButton" name="1" type="submit" value="Skrá sal">Skrá</button>
            	</div>
            	</form>
            </div>
        </section>
        <section class="infoSection">
        	<div class="infoInfoNyrSalur">
				<h1>Skráningar síða</h1>
				<form class="LoL4" action="/demo/skraSal" method="post">
				<p class="salurHausTexti">Fylltu inn eftirfarandi upplýsingar til að skrá þinn sal!</p>
				
						<label for="">Tegund sals</label>
						<div class="salurTegund">
						<select name=myradio>
           					<option name=zero value="">Tegund sals</option>
           					<option name=one value="1">Veislusalir</option>
           					<option name=two value="2">íþróttasalir</option>
            			</select>
            			</div>
            			
						<label for="stadur">Staðsetning sals</label>
						<div class="selStadur">
							<select id="stadur" name=loc>
								<option name=one value="1">Staðsetning</option>
  								<option name=one value="1">Reykjavík</option>
  								<option name=two value="2">Hafnarfjörður</option>
  								<option name=three value="3">Garðsbær</option>
  								<option name=four value="4">Kópsvogur</option>
  							</select> 
  						</div>

  						<label for="nafn">Nafn á sal</label>
  						<div class="salurNafn">
  							<input id="nafn" name="heiti" type="text" placeholder="Name of place" </label>
  						</div>
  						
  						<label for="gata">Götuheiti</label>
  						<div class="salurGata">
  							<input id="gata" name="streetAddress" type="text" placeholder="Street" </label>
  						</div>
  						
  						<label for="fjoldi">Max fjöldi</label>
  						<div class="salurFjoldi">
  							<input id="fjoldi" name="maxppl" type="text" placeholder="Max people">
  						</div>
  						
  						<label for="verd"> Verð í Kr.</lable>
  						<div class="salurVerd">
  							<input id="verd" name="price" type="text" placeholder="Price">
  						</div>
  						
  						<label for="simi"> Símanúmer</lable>
  						<div class="salurSimi">
  							<input id="simi" name="phone" type="text" placeholder="Phone number">
  						</div>
  						
  						<label for="netfang"> Netfang</lable>
  						<div class="salurNetfang">
  							<input id="netfang" name="mail" type="text" placeholder="Email">
  						</div>
  						
  						<label for="lykill"> Lykilorð</lable>
  						<div class="salurLykill">
  							<input id="lykill" name="key" type="text" placeholder="Password">
  						</div>
  						
  						<div class="stadfestaTakki">
  							<button class="stadfesta" type="submit" value="Staðfesta">Staðfesta </button>
						</div>
						
				</form>
				<form class="LoL2" action="/demo/innskra">
					<div class="innskratakki">
						<button class="innskra" name="1" type="submit" value="innskra">Innskrá</button>
					</div>
				</form>
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
