<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/6/19
  Time: 10:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../includes/header.jsp" %>
<!-- Main content -->

<!-- courses list example: how to use include header and footer -->
<h1>Edit classroom form</h1>
<form action="classroom" method="post">
    <label>Name :</label> <input type="text" name="name">
    <label>Floor :</label><input type="number" name="floor">
    <input type="hidden" value="edit" name="opt">
    <button type="submit">save</button>
</form>
<%@include file="../includes/footer.jsp" %>
