<!DOCTYPE html>
<html>
<head>
    <title>BUYSELL</title>
</head>
<body>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    User name: <input type="text" name="name"><br><br>
    email: <input type="email" name="email"><br><br>
    Phone number: <input type="text" name="numberPhone"><br><br>
    Password: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Register"/>
</form>
<#if errorMessage??>
    <h2 style = "color: red">${errorMessage}</h2>
</#if>
</body>
</html>