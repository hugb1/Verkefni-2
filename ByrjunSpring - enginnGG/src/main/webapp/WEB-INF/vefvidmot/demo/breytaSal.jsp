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
<input type="text" name = "nafn" value = "${banquet.getName()}" />
<br><input type="text" name = "location" value = "${banquet.getLocation()}" />
<br><input type="text" name = "streetAddrs" value = "${banquet.getAddress()}" />
<br><input type="text" name = "price" value = "${banquet.getPrice()}" />
<br><input type="text" name = "maxppl" value = "${banquet.getMax()}" />
<br><input type="text" name = "phonenr" value = "${banquet.getPhonenr()}" />
<br><input type="text" name = "email" value = "${banquet.getEmail()}" />
<input type="hidden" name = "id" value = "${banquet.getId()}" />
<br><input type = "submit" value = "Staðfesta Breytingar" />
</form>
</body>
<footer>
<form action="/demo/eydaSal" method = "post">
<input type="hidden" name = "id" value = "${banquet.getId()}" />
<input type = "submit" value = "Eyða Sal" />
</form>
</footer>