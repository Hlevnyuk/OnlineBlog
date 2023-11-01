<!DOCTYPE html>
<html>
<head>
    <title>Online-Blog</title>
</head>
<body>
    <p>Online-Blog</p><hr>
    <header>
        <#if user.email??>
            <h3>Name user: <i>${user.name}</i></h3>
            <form action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <input type="submit" value="Sign Out"/>
            </form>
            <a href="/user/${user.id}"><h1>Profile</h2></a>
            <#if user.isAdmin()>
                <a href="/admin">Admin panel</a>
            </#if>
        <#else>
            <a href = "/login">Sign in</a>
        </#if>
    </header>
<#list posts as post>
    <div>
        <p>${post.text} | <a href="/post/${post.id}">More...</p></a>
    </div>
    <#else>
    <h3>No post</h3>
</#list>
<#if user.email??>
    <hr>
    <form action="/post/create" method="post" enctype="multipart/form-data">
        Main Photo: <input type="file" name="file1"/><br><br>
        Second Photo: <input type="file" name="file2"/><br><br>
        Final Photo: <input type="file" name="file3"/><br><br>
        post text: <input type="text" name="text"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="publication"/>
    </form>
</#if>
</body>
</html>