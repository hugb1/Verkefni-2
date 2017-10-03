<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Search</title>
</head>
<body >

<font size="20"><marquee behavior="alternate">Search Interface</marquee></font>
    <h1>Search Page</h1>
        <h2>Search Details</h2>
        <form action="/demo/salir" method="post">
        <br/>select your desired accomidation:
        <input type="radio" name=myradio value="1"/>Veislusalir
        <input type="radio" name=myradio value="2"/>Íþróttasalir
        
        <br/>select your desired location:
        <select name=dropdown>
        <option name=one value=one> Reykjavík </option>
        <option name=two value=two> Hafnarfjörður </option>
        <option name=three value=three> Garðabær </option>
        <option name=four value=four> Kópavogur </option>
        </select>


        <br/>select your required capacity:
        <select name=dropdown>
        <option name=one value=one> 50 </option>
        <option name=two value=two> 100 </option>
        <option name=three value=three> 150 </option>
        <option name=four value=four> 200+ </option>
        </select>



        <br/><input type="submit" value="Submit">
        </form>
</body>
</html>