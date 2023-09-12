<!DOCTYPE html>
<html>
<head>
    <title>Online-Blog</title>
</head>
<body>
    <h1>Profile!</h1><br><br>
    name: ${user.name}<br>
    email: ${user.email}<br>
    phonenumber: ${user.numberPhone}<br>
    <#list posts as post>
         <div>
             <p>${post.text} | <a href="/post/${post.id}">More...</p></a>
         </div>
        <#else>
        <h3>No posts</h3>
    </#list>
</body>
</html>