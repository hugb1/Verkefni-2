<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="is">

<!-- author: VilhjÃ¡lmur JÃ³nsson -->
<!-- email: vij7@hi.is -->
<!-- -->

<html>
<head>
    <title>Skráningar Staðfesting</title>
     
</head>
<body >


<marquee behavior="alternate"><img src="https://notendur.hi.is/~vij7/asdf/salirLogo.jpg" alt="some_text" style="width:150px;height:150px;"></marquee>
    <h1>Skráning ${banquet.getName()} tókst!</h1>
        <h2>Takk fyrir að velja Salir.com</h2>
        <br> <h3>ID númerið þitt er: ${banquet.getId()}</h3>

</body>
<footer>
<form action="/demo/search">
<input type = "submit" name = "Submit" value = "Aftur á byrjunarsíðu" />
</form>
</footer>
</html>