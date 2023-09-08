<!DOCTYPE html>
<html>
<head>
    <title>Online-Blog</title>
</head>
<body>
    <header>
        <p>Online-Blog | <a href = "/login">Sign in</a></p>
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>
    </header>

<#list posts as post>
    <div>
        <p>${post.author} | <a href="/post/${post.id}">More...</p></a>
    </div>
    <#else>
    <h3>No post</h3>
</#list>
<hr>
<form action="/post/create" method="post" enctype="multipart/form-data">
    author: <input type="text" name="author"/><br><br>
    Main Photo: <input type="file" name="file1"/><br><br>
    Second Photo: <input type="file" name="file2"/><br><br>
    Final Photo: <input type="file" name="file3"/><br><br>
    post text: <input type="text" name="text"/><br><br>
    <input type="submit" value="publication"/>
</form>
</body>
</html>