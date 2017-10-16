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
${sportvenue.getName()} 
</body>
<footer>
<form action="/demo/eydaSport" method = "post">
<input type="hidden" name = "id" value = "${sportvenue.getId()}" />
<input type = "submit" value = "Eyða Sal" />
</form>
</footer>