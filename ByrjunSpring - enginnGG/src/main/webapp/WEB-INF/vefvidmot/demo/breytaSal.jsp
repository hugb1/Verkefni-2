<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: Pétur Logi Pétursson -->
<!-- email: plp2@hi.is -->
<!-- vefur til að breyta sölum í gagnagrunni -->
<html>
<head>
<title>Breyta sal</title>
</head>
<body>
<form action = "/demo/breytaSal" method = "post">
Nafn: <input type="text" name = "nafn" value = "${banquet.getName()}" />
<br><select name=location>
            			<option name=zero value="0">${banquet.getLocation()}</option>
            			<option name=one value="1">Reykjavík</option>
            			<option name=two value="2">Hafnarfjörður</option>
            			<option name=three value="3">Garðsbær</option>
            			<option name=four value="4">Kópsvogur</option> 
           			</select>
<br>Götu heiti: <input type="text" name = "streetAddrs" value = "${banquet.getAddress()}" />
<br>Verð: <input type="text" name = "price" value = "${banquet.getPrice()}" />
<br>Hámarksfjöldi: <input type="text" name = "maxppl" value = "${banquet.getMax()}" />
<br>Símanúmer: <input type="text" name = "phonenr" value = "${banquet.getPhonenr()}" />
<br>Netfang: <input type="text" name = "email" value = "${banquet.getEmail()}" />
<input type="hidden" name = "id" value = "${banquet.getId()}" />
<input type="hidden" name = "origLoc" value = "${banquet.getLocation()}" />
<br><input type = "submit" value = "Staðfesta Breytingar" />
</form>
</body>
<footer>
<form action="/demo/eydaSal" method = "post">
<input type="hidden" name = "id" value = "${banquet.getId()}" />
<input type = "submit" value = "Eyða Sal" />
</form>
</footer>