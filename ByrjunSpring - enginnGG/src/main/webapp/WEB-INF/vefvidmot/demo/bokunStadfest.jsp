<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- author: Vilhjálmur Jónsson -->
<!-- email: vij7@hi.is -->
<!-- vefur sem segir okkur hvort bókun hafi heppnast-->

<html lang="is">
  <head>
    <title>Staðfesting á bókun</title>  
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
  </head>
  <body>

    <h2>Upplýsingar fyrir bókun</h2>
    <form action="demo/salurStadfest" method="POST" >
          <table width="75%">
            <tr> 
              <td width="48%">Nafn:</td>
              <td width="52%">
                <input type="text" name="name" />
              </td>
            </tr>
            <tr> 
              <td width="48%">Kennitala:</td>
              <td width="52%">
                <input type="text" name="name" />
              </td>
            </tr>
            <tr> 
              <td width="48%">Email:</td>
              <td width="52%">
                <input type="text" name="name" />
              </td>
            </tr>
            <tr> 
              <td width="48%">Sími:</td>
              <td width="52%">
                <input type="text" name="name" />
              </td>
            </tr>
          </table>
          <p> 
            <input type="submit" name="Submit" value="Bóka!" />
          </p>
    </form>

  </body>
  <footer>
  </footer>
</html>