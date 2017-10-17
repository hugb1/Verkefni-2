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
<title>Breyta Íþróttasal</title>
</head>
<body>
<form action = "/demo/breytaSport" method = "post">
<input type="text" name = "nafn" value = "${sportvenue.getName()}" />
<br><input type="text" name = "location" value = "${sportvenue.getLocation()}" />
<br><input type="text" name = "streetAddrs" value = "${sportvenue.getAddress()}" />
<br><input type="text" name = "price" value = "${sportvenue.getPrice()}" />
<br><input type="text" name = "phonenr" value = "${sportvenue.getPhonenr()}" />
<br><input type="text" name = "email" value = "${sportvenue.getEmail()}" />
<input type="hidden" name = "id" value = "${sportvenue.getId()}" />
<br><input type = "submit" value = "Staðfesta Breytingar" />
</form>
</body>
<footer>
<form action="/demo/eydaSal" method = "post">
<input type="hidden" name = "id" value = "${sportvenue.getId()}" />
<input type = "submit" value = "Eyða Sal" />
</form>
</footer>