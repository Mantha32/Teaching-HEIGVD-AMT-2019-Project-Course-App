<%--
    Document   : index
    Created on : 18 juil. 2019, 15:49:09
    Author     : doriane kaffo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Cours</title>

    <!-- Custom fonts for this template-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">

    <!-- Page level plugin CSS-->
    <link href="/vendor/datatables/dataTables.bootstrap4.css"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

    <link rel="stylesheet" href="css/sb-style.css">

    <!-- librairies pour le calendrier -->
    <link href='/assets/css/fullcalendar.css' rel='stylesheet' />
    <link href='/assets/css/fullcalendar.print.css' rel='stylesheet'
          media='print' />

    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src='/assets/js/jquery-ui.custom.min.js' type="text/javascript"></script>
    <script src='/assets/js/fullcalendar.js' type="text/javascript"></script>

    <style>
        .dataTables_filter {
            float: right;
            text-align: left;
        }
    </style>
</head>

<body id="page-top">

<%@ include file="/header.jsp" %>

<div class="row">
    <div class="col-md-12">

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item"><a class="nav-link"
                                        href="enseignant.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tableau de Bord</span>
                </a></li>
                <li class="nav-item active"><a class="nav-link" href="courses">
                    <i class="fas fa-fw fa-flag"></i> <span>Mes Cours</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="/logout">
                    <i class="fas fa-fw fa-flag"></i> <span>Deconexion</span>
                </a></li>
            </ul>

            <div id="content-wrapper">

                <div class="table-responsive" style="margin-left: 30px; margin-right: 50px">
                    <table class="table table-hover table-dark"
                           id="dataTable">
                        <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Titre</th>
                            <th class="text-center">Description</th>
                            <th class="text-center">Enseignant</th>
                        </tr>
                        </thead>

                        <tbody>
                        <%
                            @SuppressWarnings("unchecked")
                            List<Course> courses = (List<Course>)request.getAttribute("courses");
                            for(Course course : courses){
                        %>
                        <tr class="note">
                            <td class="code text-center"><%=course.getCourseid() %></td>
                            <td class="code text-center"><%=course.getTitre() %></td>
                            <td class="code text-center"><%= course.getDescription() %></td>
                            <td class="text-center"><%= course.getUser().getUsername() %></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>

                <%@ include file="/footer.jsp" %>
                <!-- /.content-wrapper -->
            </div>
        </div>
    </div>
</div>
</body>

<!-- Bootstrap core JavaScript-->
<script src="/vendor/jquery/jquery.min.js"></script>

<!-- AdminLTE App -->
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Select2 -->
<script src="/bower_components/select2/dist/js/select2.full.min.js"></script>

<!-- InputMask -->
<script src="/plugins/input-mask/jquery.inputmask.js"></script>
<script src="/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="/plugins/input-mask/jquery.inputmask.extensions.js"></script>

<!-- DataTables -->
<script src="/vendor/datatables/jquery.dataTables.js"></script>
<script src="/vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- SlimScroll -->
<script
        src="/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>

<script src='/assets/js/jquery-ui.custom.min.js' type="text/javascript"></script>
</html>
