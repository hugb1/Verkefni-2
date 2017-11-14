<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: Vilhjállmur Jónsson -->
<!-- email: vij7@hi.is -->
<!-- vefur fyrir bóka sportsal -->
<html>
    <head>
        <title>Bóka sal</title>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
           <link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui.css"/>"/>
        <script src="/javascript/jquery-1.12.4.js"></script>
        <script src="/javascript/jquery-ui.js"></script>
      <script src="/javascript/datepicker.js"></script>
         
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
			<div class="infosalurBox">
				<P class="salurBokBok">Upplýsingar um salinn</p>
				<p class="infoBoxTexti"> Nafn: ${sportvenues.getName()}</p>
				<p class="infoBoxTexti">Gata: ${sportvenues.getAddress()}</p>
				<p class="infoBoxTexti">Verð: ${sportvenues.getPrice()} kr.</p>
				<p class="infoBoxTexti">Sími: ${sportvenues.getPhonenr()}</p>
				<p class="infoBoxTexti">Mail: ${sportvenues.getEmail()}</p>
			</div>
			
        	<div class="infoInfoBokasal">
				<form class="LoL6" action="/demo/sportStadfest" method="post">
				<p class="salurHausTexti1">Fylltu inn eftirfarandi upplýsingar!</p>
				
  						<label for="nafn1">Nafn</label>
  						<div class="salurNafn">
  							<input id="nafn1" name="name" type="text" required minlength="1" maxlength="30" placeholder="Name">
  						</div>
 
   						<label for="kt1">Kennitala</label>
  						<div class="salurNafn">
  							<input id="kt1" name="kt" type="text" required minlength="10" maxlength="10" placeholder="Social Security number">
  						</div>
  						
  						<label for="mail1">Netfang</label>
  						<div class="salurNafn">
  							<input id="mail1" name="mail" type="email" placeholder="email@email.is">
  						</div>  						
  						
  						 <label for="simi1">Símanúmer</label>
  						<div class="salurNafn">
  							<input id="simi1" name="phone" type="text" required minlength="7" maxlength="7" placeholder="Phone number">
  						</div>

  						<label for="datepicker">Dagsetning</label>
  						<div class="salurNafn">
                <input id="datepicker" name="date" type="text">
  						</div>

  	  						<div>
  								<input name="id" type="hidden"  value = "${sportvenues.getId()}">
  							</div>
  										
  						
  				
  						<div class="stadfestaTakki">
  							<button class="stadfesta" type="submit" value="Bóka">Bóka</button>
						</div>
						
				</form>
        	</div>
        </section>

        <%
			String[] params = ((String[])request.getAttribute("dateArray"));
			if(params != null) { %>
				<script>
				var params = new Array(<%
				for(int i = 0; i < params.length; i++) {
  					out.print("\""+params[i]+"\"");
  					if(i+1 < params.length) {
    				out.print(",");
  					}
				}
				%>);
				</script>
		<% } %>
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
