<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 
<html lang="is">
  <head>
    <meta charset"utf-8">
    <link rel="stylesheet" type="text/css" href="bookings.css">

    <title>Bookings</title>
  </head>
  <body>
    <header>
      <section class="Header-section">
      </section>
    </header>
    <main>
      <Section class="search-bar-section">
      <div class="header-text">
        <h1> Finndu salinn sem hentar þér! </h1>
        <h3> Hvernig sal villtu?</h2>

      <div class="field">
          <label>
            <span>Veislusalir</span> <input type="radio" value="Veislusalir" name="number">
            <span>íþróttasalir</span><input type="radio" value="íþróttasalir" name="number">
          </label>
      </div>


      <form method="post" action="">
        <fieldset style=width:200px>
          <legend>search bar</legend>
          <div class="field">
            <label for="qualif">Location </label>
            <select name="location" id="location">
              <option>Reykjavík</option>
              <option>Kópavogur</option>
              <option>Garðabær</option>
              <option>Hafnafjörður</option>
            </select>
          </div>
          <div class="field">
            <label for="qualif">max capacity</label>
            <select name="location" id="location">
              <option>50</option>
              <option>100</option>
              <option>150</option>
              <option>200+</option>

            </select>
          </div>

        </form>
      </div>

        <button class="button">search</button>
    </main>
    <footer>
    </footer>
</body>
</html>