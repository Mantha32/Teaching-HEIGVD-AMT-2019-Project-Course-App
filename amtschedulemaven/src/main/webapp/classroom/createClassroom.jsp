<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/7/19
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="classroom" method="post">
    <label>Name :</label> <input type="text" name="name">
    <label>Floor :</label><input type="number" name="floor">
    <input type="hidden" value="add" name="opt">
    <button type="submit">create</button>
</form>
</body>
</html>
