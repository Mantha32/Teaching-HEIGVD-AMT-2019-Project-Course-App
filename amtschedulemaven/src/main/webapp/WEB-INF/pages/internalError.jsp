<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/6/19
  Time: 10:05 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../includes/header.jsp" %>
<!-- Main content -->
<!------------------ Nested Row body ------------->

<div class="row" id="Aboutcontent">
    <div class="col-md-12">
        <!-- Main content -->
        <section class="content">

            <div class="error-page">
                <h1 class="headline text-info"> 500 </h1>
                <div class="error-content" border-bottom-danger border-left-danger>
                    <h4 class="headline text-info">Website error</h4>
                    <p>
                        We apologize, an error occurred upon your request. The issue has been notify to the administrator.
                        Try later!
                        Or go back to <a href="<c:url value="home" />">  dashboard </a> instead.
                    </p>
                </div><!-- /.error-content -->
            </div><!-- /.error-page -->

        </section><!-- /.content -->
    </div>

</div>

<%@include file="../includes/footer.jsp" %>
