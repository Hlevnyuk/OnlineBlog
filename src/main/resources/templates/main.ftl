<!DOCTYPE html>
<html>
<head>
    <title>Online-Blog</title>
</head>
<body>
    <header>
        <p>Online-Blog</p>
    </header>

<#list posts as post>
    <div>
        <p>${post.author} | <a href="/post/${post.id}">More...</p></a>
    </div>
    <#else>
    <h3>No post</h3>
</#list>
<hr>
<form action="/post/create" method="post">
    author: <input type="text" name="author"/><br><br>
    post text: <input type="text" name="text"/><br><br>
    <input type="submit" value="publication"/>
</form>
</body>
</html>