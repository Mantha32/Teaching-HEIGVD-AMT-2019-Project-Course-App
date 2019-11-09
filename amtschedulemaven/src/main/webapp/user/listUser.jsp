<%--
    Document   : index
    Created on : 18 juil. 2019, 15:49:09
    Author     : Doriana kaffo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Enseignant</title>

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

    <script>
        function initialize(eventsArr) {

            $('#external-events div.external-event').each(function() {

                // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                // it doesn't need to have a start or end
                var eventObject = {
                    title : $.trim($(this).text())
                    // use the element's text as the event title
                };

                // store the Event Object in the DOM element so we can get to it later
                $(this).data('eventObject', eventObject);

                // make the event draggable using jQuery UI
                $(this).draggable({
                    zIndex : 999,
                    revert : true, // will cause the event to go back to its
                    revertDuration : 0
                    //  original position after the drag
                });
            });

            /* initialize the calendar
            -----------------------------------------------------------------*/

            var calendar = $('#calendar').fullCalendar({
                header : {
                    left : 'title',
                    center : 'agendaDay,agendaWeek,month',
                    right : 'prev,next today'
                },
                editable : false,
                firstDay : 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
                selectable : false,
                defaultView : 'agendaWeek',

                axisFormat : 'h:mm',
                columnFormat : {
                    month : 'ddd', // Mon
                    week : 'ddd d', // Mon 7
                    day : 'dddd M/d', // Monday 9/7
                    agendaDay : 'dddd d'
                },
                titleFormat : {
                    month : 'MMMM yyyy',
                    week : "MMMM yyyy",
                    day : 'MMMM yyyy'
                },
                allDaySlot : true,
                selectHelper : false,
                droppable : false, // this allows things to be dropped onto the calendar !!!
                events : eventsArr,
            });
        }
    </script>
    <style>
        #wrap {
            width: 1100px;
            margin: 0 auto;
        }

        #external-events {
            float: left;
            width: 150px;
            padding: 0 10px;
            text-align: left;
        }

        #external-events h4 {
            font-size: 16px;
            margin-top: 0;
            padding-top: 1em;
        }

        .external-event { /* try to mimick the look of a real event */
            margin: 10px 0;
            padding: 2px 4px;
            background: #3366CC;
            color: #fff;
            font-size: .85em;
            cursor: pointer;
        }

        #external-events p {
            margin: 1.5em 0;
            font-size: 11px;
            color: #666;
        }

        #external-events p input {
            margin: 0;
            vertical-align: middle;
        }

        #btnEnseignant,#btnSalle,#btnNiveau {
            cursor: pointer;
        }

        #calendar { /*    float: right; */
            margin: 0 auto;
            width: 900px;
            background-color: #FFFFFF;
            border-radius: 6px;
            box-shadow: 0 1px 2px #C3C3C3;
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
                                               href="admin.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tableau de Bord</span>
                </a></li>
                <li class="nav-item active"><a class="nav-link" href="users?role=Enseignant">
                    <i class="fas fa-fw fa-users"></i> <span>Gerer les enseignants</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="classroom">
                    <i class="fas fa-fw fa-flag"></i> <span>Gerer les Salles</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="courses">
                    <i class="fas fa-fw fa-flag"></i> <span>Gerer les Cours</span>
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
                            <th class="text-center">Username</th>
                            <th class="text-center">Firstname</th>
                            <th class="text-center">Lastname</th>
                            <th class="text-center">Role</th>
                        </tr>
                        </thead>

                        <tbody>
                        <%
                            @SuppressWarnings("unchecked")
                            List<User> users = (List<User>)request.getAttribute("users");
                            for(User user : users){
                        %>
                        <tr class="note">
                            <td class="code text-center"><%= user.getUsername() %></td>
                            <td class="code text-center"><%= user.getFirstname() %></td>
                            <td class="text-center"><%= user.getLastname() %></td>
                            <td class="code text-center"><%= user.getRole().getStatus() %></td>
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
<script src='/assets/js/fullcalendar.js' type="text/javascript"></script>


<script>
    $(function() {
        var tab = [];
        var t = $('#dataTable').DataTable({
            columns : [ {
                title : 'Username'
            }, {
                title : 'Firstname'
            }, {
                title : 'Lastname'
            }, {
                title : 'Role'
            } ],
            info : false,
            lengthChange : false,
            scollX : false,
            scrollY : 400,
            scrollCollapse : true,
            paging : false,
        });

        $('#dataTable tbody').on('click', 'tr', function() {
            if ($(this).hasClass('selected')) {
                $(this).removeClass('selected');
            } else {
                t.$('tr.selected').removeClass('selected');
                $(this).addClass('selected');
            }

            var texte = $('.selected').text();
            tab = texte.replace(/\t/g, '').split('\n');
            populate_calendar(tab);
        });

        function populate_calendar(tab) {
            $('#calendar')
                .replaceWith(
                    '<div id="calendar" class="col-md-9 float-right border"><div style="clear: both"></div>');
            $.ajax({
                url : 'cours?criteria=utilisateur&key=' + tab[1],
                dataType : 'xml',
                type : 'GET',
                success : function(doc) {
                    var eventsArr = [];
                    if ($(doc).find('ue').length > 0) {
                        $(doc).find('ue').each(
                            function() {
                                eventsArr.push({
                                    id : $(this).find('id').html(),
                                    title : $(this).find('ens').html()
                                        + '\n'
                                        + $(this).find('code').html()
                                        + '\n'
                                        + $(this).find('salle').html(),
                                    start : $(this).find('debut').html(),
                                    end : $(this).find('fin').html(),
                                    allDay : false,
                                    className : 'important'
                                });
                            });
                    }
                    initialize(eventsArr);
                }
            });
        }

        populate_calendar([ "root", "root" ]);
    });
</script>
</html>
