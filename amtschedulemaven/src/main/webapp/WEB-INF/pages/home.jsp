<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/6/19
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../includes/header.jsp" %>
<!-- Main content -->

<!-- courses list on the landing page home -->
<!------------------ Nested Row within course form body ------------->
<c:choose>
    <c:when test="${userInfo.isAdmin=='true'}">
        <%@include file="../user/listUser.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../courses/listCourse.jsp" %>
    </c:otherwise>
</c:choose>

<%@include file="../includes/footer.jsp" %>

