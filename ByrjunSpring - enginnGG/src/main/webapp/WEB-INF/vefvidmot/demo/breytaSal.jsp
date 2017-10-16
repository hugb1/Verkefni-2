<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: Pétur Logi Pétursson -->
<!-- email: plp2@hi.is -->
<!-- vefur til að búa til sali -->
<html>
<head>
<title>Breyta sal</title>
</head>
<body>
${banquet.getName()} 
</body>
<footer>
<form action="/demo/eydaSal" method = "post">
<input type="hidden" name = "id" value = "${banquet.getId()}" />
<input type = "submit" value = "Eyða Sal" />
</form>
</footer>