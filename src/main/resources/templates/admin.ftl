<!DOCTYPE html>
<html>
<head>
    <title>Online-Blog</title>
</head>
<body>
    <p>Online-Blog</p><hr>
    <h4>Administrator panel</h4>
    <table>
        <tr>
            <th>Email</th>
            <th>Phone number</th>
            <th>Active</th>
            <th>Role</th>
            <th>Ban</th>
            <th>Edit</th>
            <th>Detailed information</th>
        </tr>
        <#list users as user>
            <tr>
                <th>${user.email}</th>
                <th>${user.numberPhone}</th>
                <th>
                    <#if user.active>
                        true
                    <#else>
                        false
                    </#if>
                </th>
                <th><#list user.roles as role>${role}</#list></th>
                <th>
                    <form action="/admin/user/ban/${user.id}" method="post">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <input type="submit" value="ban">
                    </form>
                </th>
                <th><a href="/admin/user/edit/${user.id}">Edit</a></th>
                <th><a href="/user/${user.id}">Detailed information</a></th>
            </tr>
        <#else>
            <h3>User not found</h3>
        </#list>
    </table>
</body>
</html>