<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Convertisseur de température</title>
</head>
<body>

<h1>Bonjour tout le monde</h1>

Nous sommes le <%= new java.util.Date().toString()%> et tout va bien.<br><br>


Vous pouvez convertir une température exprimée en
<b>Celsius</b> en une valeur exprimée en
<b>Fahrenheit</b>.

<hr/>

<form method="post"
      action="${pageContext.request.contextPath}/convertisseur">

    Valeur en Celsius: <input type="text" size="20" name="celsius" /> <br />

    <input type="submit" value="Convertir" />

</form>

<hr/>

</body>
</html>