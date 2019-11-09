<%--
  Created by IntelliJ IDEA.
  User: dilifera
  Date: 11/4/19
  Time: 7:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
    Document   : notFound
    Created on : Nov 4, 2018, 11:15:46 PM
    Author     : dilifera
--%>

<%@include file="../../includes/inc/header.jsp" %>
<div class="wrapper row-offcanvas row-offcanvas-left" style="min-height: 540px;">
    <!-- /.left-side  will remove because unrelevant for about page: this page is raw static page style-->

    <!-- Right side column. Contains the navbar and content of the page -->
    <div class="row" id="Aboutcontent">
        <div class="col-md-12">
            <!-- Main content -->
            <section class="content">

                <div class="error-page">
                    <h1 class="headline text-info"> 404</h1>
                    <div class="error-content">
                        <p>
                            Sorry, but we can't seem to find the page you are looking for.
                            Why don't you try to visit our <a href="<c:url value="home" />">  AMT project home page </a> instead.
                        </p>
                    </div><!-- /.error-content -->
                </div><!-- /.error-page -->

            </section><!-- /.content -->
        </div>

    </div>
</div><!-- ./wrapper -->

<%@include file="../../includes/inc/footer.jsp" %>
