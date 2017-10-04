<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<html>
    <head>
        <title>Search</title>
         
    </head>
    <body >


    <marquee behavior="alternate"><img src="https://i.imgur.com/YfU0Cvz.jpg" alt="some_text" style="width:150px;height:150px;"></marquee>
        <h1>Leitar síða</h1>
            <h2>Leitar upplýsingar</h2>
            <form action="/demo/submit" method="post">
            <br/>Veldu tegund sals:
            <input type="radio" name=myradio value="1"/>Veislusalir
            <input type="radio" name=myradio value="2"/>Íþróttasalir
            
            <br/>Veldu staðsetningu sals:
            <select name=loc>
            <option name=one value="1">Reykjavík</option>
            <option name=two value="2">Hafnarfjörður</option>
            <option name=three value="3">Garðsbær</option>
            <option name=four value="4">Kópsvogur</option>
            </select>

            <br/>Veldu fjölda:
            <select name=cap>
            <option name=one value="1">50</option>
            <option name=two value="2">100</option>
            <option name=three value="3">150</option>
            <option name=four value="4">200+</option>
            </select>

            <br/><input type="submit" value="Leita">
            </form>
    </body>
    <footer>
    </footer>
</html>