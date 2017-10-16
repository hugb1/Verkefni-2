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
<title>Authenticate</title>
</head>
<body>
<h1>Innskráningar síða</h1>
<form action="/demo/verify" method = "post">
<h2>Vinsamlegast fylltu út eftirfarandi upplýsingar:</h2>

<br>Tegund sals: 
<input type="radio" name="myradio" value="1" /> Veislusalur
<input type="radio" name="myradio" value="2" /> Íþróttasalur
<br>ID númer sals: <input name="id" type="text" placeholder="Id" />
<br>Key: <input name="key" type="text" placeholder="Key" />
<input type="submit" value="Staðfesta" />
</form>
</body>

<footer>

</footer>