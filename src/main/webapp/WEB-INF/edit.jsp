<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 02/08/2021
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><input type="text" name="id" value="${customer.id}" readonly ></td>
            <td><input type="text" name="name" value="${customer.name}"></td>
            <td><input type="text" name="email" value="${customer.email}"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Edit Nhan viên</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
