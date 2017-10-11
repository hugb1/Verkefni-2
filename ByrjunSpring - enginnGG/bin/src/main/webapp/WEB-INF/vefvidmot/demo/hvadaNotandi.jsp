<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- author: Vilhjálmur Jónsson -->
<!-- email: vij7@hi.is -->

<html>

<head>
    <title>Hver er notandinn</title>
</head>
<body>

<h1></h1>

<!-- Skipunin /demo/hver send með post aðferðinni þegar við fyllum út formið -->
<!-- nafn breytan send með skipuninni /demo/hver-->

<form method="POST" action="/demo/hver">
	hvað heitirðu? <input name="nafn" type="text" placeholder="Nafn" ></input>
	<input type="submit" value="í lagi"/>
</form>
</body>

</html>