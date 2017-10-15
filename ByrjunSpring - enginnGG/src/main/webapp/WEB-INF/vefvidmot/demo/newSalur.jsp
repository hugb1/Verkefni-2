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
        <title>Nýr Salur</title>
         
    </head>
    <body >


    <marquee behavior="alternate"><img src="" alt="" style="width:150px;height:150px;"></marquee>
        <h1>Skráningar Síða</h1>
            <form action="/demo/skraSal" method="post">            
            <h2>Vinsamlegast fylltu út eftirfarandi upplýsingar:</h2>
            
            <br/>Veldu tegund sals:
            <input type="radio" name=myradio value="1"/>Veislusalir
            <input type="radio" name=myradio value="2"/>Íþróttasalir
            
            <br/>Heiti sals: <input name = "heiti" type = "text" placeholder = "Nafn"/>
             
            <br/>Veldu staðsetningu sals:
            <select name=loc>
            <option name=one value="1">Reykjavík</option>
            <option name=two value="2">Hafnarfjörður</option>
            <option name=three value="3">Garðsbær</option>
            <option name=four value="4">Kópsvogur</option>
            </select>
            
            <br/>Götuheiti: <input name = "streetAddress" type ="text" placeholder = "Street"/>
            
            <br/>Verð í krónum: <input name = "price" type = "text" placeholder = "Price"/>

            <br/>Hámarks fólksfjöldi: <input name = "maxppl" type = "text" placeholder = "Maxppl"/>
            
            <br/>Símanúmer: <input name = "phone" type ="text" placeholder = "PhoneNr"/>
            
            <br/>Netfang: <input name = "mail" type = "text" placeholder = "Email"/>
            
            <br/>Key*: <input name = "key" type = "text" placeholder = "Key"/>


            <br/><input type="submit" value="Staðfesta">
            </form>
    </body>
    <footer>
    *Key breytan er nokkurskonar password sem þarf að nota með ID númeri salsins ef breyta á upplýsingum varðandi salinn seinna meir.
    </footer>
</html>