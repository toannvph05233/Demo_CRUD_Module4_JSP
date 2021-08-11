<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 02/08/2021
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/create">create</a>
<table>
    <c:forEach items="${list}" var="c" varStatus="loop">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td><a href="/edit?index=${loop.index}">edit</a></td>
            <td><a href="/delete?index=${loop.index}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
