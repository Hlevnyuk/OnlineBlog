<!DOCTYPE html>
<html>
<head>
    <title>Online-Blog</title>
</head>
<body>
<h1>Online-Blog</h1>
<h4>Authorization</h4>
<form action = "/login" method="post">
    email: <input type = "email" name = "username"><br><br>
    password: <input type = "password" name = "password"><br><br>
    <input type = "hidden" name = "_csrf" value = "${_csrf.token}">
    <input type= "submit" value = "Sign in">
</form>
<a href = "/registration">Sign up</a>
</body>
</html>