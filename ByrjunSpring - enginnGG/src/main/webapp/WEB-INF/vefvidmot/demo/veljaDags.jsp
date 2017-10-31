<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">
    <head>
        <title>Datepick</title>
        <link href="<c:url value="/javaScript/test.css" />" rel="stylesheet">
		<script src="<c:url value="/javaScript/datePicker.js" />"></script>
		<script src="<c:url value="/javaScript/jquery-ui.min.js"/>"></script>
	</head>
	<body>
		<div id="header">
			<h2><br/>Select a Destination</h2>
		</div>
            <p>Departing: <input type="text" id="departing"></p>
            <p>Returning: <input type="text" id="returning"></p>
            
            <h1>1. Test CSS</h1>
            
            <h2>2. Test JS</h2>
			<div id="msg"></div>
	</body>
</html>