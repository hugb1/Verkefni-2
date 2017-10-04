<!DOCTYPE html>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="is">
<head>
<title>Bókun á Íþróttahúsi</title>  
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/veitingaSalir.css"/>"/>
</head>
<body>
<h1>${sportvenues}</h1>
</body>
<footer>
<form action="/demo/sportStadfest" method="POST" >
      <table width="75%">
        <tr> 
          <td width="48%">Nafn:</td>
          <td width="52%">
            <input type="text" name="name" />
          </td>
        </tr>
        <tr> 
          <td width="48%">kennitala:</td>
          <td width="52%">
            <input type="text" name="kt" />
          </td>
        </tr>
        <tr> 
          <td width="48%">email:</td>
          <td width="52%">
            <input type="text" name="mail" />
          </td>
        </tr>
        <tr> 
          <td width="48%">sími:</td>
          <td width="52%">
            <input type="text" name="phone" />
          </td>
        </tr>
        <tr>
        <td> <input type = "hidden" name = "id" value = "${sportvenues.getId()}"/>
        </td>
        </tr>
      </table>
      <p> 
        <input type="submit" name="Submit" value="Bóka" />
      </p>
</form>
</footer>
</html>