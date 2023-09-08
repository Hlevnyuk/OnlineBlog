<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Online-Blog</title>
</head>
<body>
    Author: ${info.author}<br>
    <#list images as img>
        <img src="/images/${img.id}" height="60px"/><br><br>
    </#list>
    Post:<br>${info.text}
    <form action="/post/delete/${info.id}" method="post">
        <input type="submit" value="Delete post">
    </form>
    Comments
    <hr>
    <#list comments as item>
        ${item.text}
        <br><br>
        <#else>
        No comments
    </#list>
    <form action="/comment/create/${info.id}" method="post">
        Create a comment:<br>
        text: <input type="text" name="text"/>
        <input type="submit" value="publication"/>
    </form>
</body>
</html>