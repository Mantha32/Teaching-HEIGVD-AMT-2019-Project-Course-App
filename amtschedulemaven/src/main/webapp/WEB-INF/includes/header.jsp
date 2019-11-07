<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/6/19
  Time: 10:35 PM
  Choose the right header depends on the user status

 <c:choose>
    <c:when test="${userInfo.isAdmin=='true'}">
        <%@include file="adminFeatureHeader.jsp" %>
    </c:when>

    <c:otherwise>
        <%@include file="userFeatureHeader.jsp" %>
    </c:otherwise>
</c:choose>

--%>

<%@include file="userFeatureHeader.jsp" %>