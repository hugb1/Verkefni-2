<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- author: Brynjar Árnason -->
<!-- email: bra13@hi.is -->
<!-- vefur fyrir bókun veislusala viðmót-->

<html lang="is">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>2 Column Layout &mdash; Left Menu with Header &amp; Footer</title>
<style type="text/css">
		
body {
		margin:0;
		padding:0;
		font-family: Sans-Serif;
		line-height: 1.5em;
	 }
			
#header {
		background: #ccc;
		height: 100px;
		background-color: #982149;
		}
			
#header h1 {
		margin: 0;
		padding-top: 15px;
		}
			
main {
		padding-bottom: 10010px;
		margin-bottom: -10000px;
		float: left;
		width: 100%;
		}
			
#nav {
		position: relative;
		padding:40px 0 60px 0; 
    	margin:0 auto 0 auto; 
		float: left;
		width: 230px;
		margin-left: -100%;
		background: #eee;
	  }
			
#footer {
		position: absolute;
		height: 60px;
		bottom:0;
		clear: left;
		width: 100%;
		background: #ccc;
		text-align: center;
		padding: 4px 0;
		background-color: #000000;
		}
	
#wrapper {
		overflow: hidden;
		}
						
#content {
		margin-left: 230px; 
		}
			
.innertube {
		margin: 15px; 
		margin-top: 0;
		}
		
p {
		color: #F0F8FF;
		}
	
nav ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
		}
			
nav ul a {
		color: darkgreen;
		text-decoration: none;
		}
		
</style>
	</head>
		<body>		
			<header id="header">
			<div class="innertube">
				<h1><center>Bókun á Veislusal</center></h1>
			</div>
		</header>
		
		<div id="wrapper">
			<main>
				<div id="content">
					<div class="innertube">
					<h1>Bókunarupplýsingar</h1>
					<h2>Vinsamlegast skráðu persónuupplýsingar:</h2>
						<form action="/demo/salurStadfest" method="POST" >
      					<table width="75%">
        			<tr> 
          				<td width="48%">Nafn:</td>
          				<td width="52%">
            			<input type="text" name="name" />
          				</td>
        			</tr>
        			<tr> 
          				<td width="48%">kennitala:</td>
          				<td width="52%">
            			<input type="text" name="kt" />
          				</td>
        			</tr>
        			<tr> 
          				<td width="48%">email:</td>
          				<td width="52%">
            			<input type="text" name="mail" />
          				</td>
        			</tr>
        			<tr> 
          				<td width="48%">sími:</td>
          				<td width="52%">
            			<input type="text" name="phone" />
          				</td>
        			</tr>
        			<tr>
        				<td> <input type = "hidden" name = "id" value = "${banquet.getId()}"/>
        				</td>
        			</tr>
      					</table>
      				<p> 
        			<input type="submit" name="Submit" value="Bóka" />
      				</p>
						</form>
					
					</div>
				</div>
			</main>
			
<nav id="nav">
	<div class="innertube">
		<h2>Upplýsingar um salinn</h2>
			<ul>
			<h4>Nafn: ${banquet.getName()}</h4>
			<h4>Gata: ${banquet.getAddress()}</h4>
			<h4>Verð: ${banquet.getPrice()} kr.</h4>
			<h4>Fjöldi: ${banquet.getMax()}</h4>
			<h4>Sími: ${banquet.getPhonenr()}</h4>
			<h4>Mail: ${banquet.getEmail()}</h4>	
			</ul>
	</div>
</nav>
		
</div>
		<footer id="footer">
<div class="innertube">
		<p></p>
</div>
</footer>
</html>