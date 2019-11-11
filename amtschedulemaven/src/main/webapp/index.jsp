<%--
    Document   : index
    Created on : 18 juil. 2019, 15:49:09
    Author     : Doriane kaffo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tableau de bord</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">

    <!-- Page level plugin CSS-->

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

    <link rel="stylesheet" href="css/sb-style.css">

    <!-- librairies pour le calendrier -->
    <link href='assets/css/fullcalendar.css' rel='stylesheet' />
    <link href='assets/css/fullcalendar.print.css' rel='stylesheet'
          media='print' />

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

<%@ include file="header.jsp" %>

<div class="row">
    <div class="col-md-12">

        <div id="wrapper">

            <div id="content-wrapper">

                <nav class="navbar navbar-expand navbar-dark bg-dark static-top">
                    <a class="navbar-brand mr-1" href="login.jsp">Connexion</a>
                </nav>

                <div class="container-fluid">

                    <!-- Calendar-->
                    <div class="card mb-6">
                        <div class="card-header">
                            <i class="fas fa-fw fa-table"></i> Emploie de Temps
                        </div>
                        <br>
                    </div>
                    <div id="calendar" class="col-md-9 border">
                        <div style="clear: both"></div>
                    </div>

                    <%@ include file="footer.jsp" %>

                </div>
                <!-- /.content-wrapper -->
            </div>
        </div>
    </div>
</div>
</body>

<!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>

<!-- AdminLTE App -->
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

<!-- Select2 -->
<script src="bower_components/select2/dist/js/select2.full.min.js"></script>

<!-- InputMask -->
<script src="plugins/input-mask/jquery.inputmask.js"></script>
<script src="plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="plugins/input-mask/jquery.inputmask.extensions.js"></script>

<!-- DataTables -->
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

<!-- SlimScroll -->
<script
        src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>

<script src='assets/js/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='assets/js/fullcalendar.js' type="text/javascript"></script>

<script>
    $(function() {
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

            var calendar =  $('#calendar').fullCalendar({
                header: {
                    center: 'title',
                    right: 'agendaDay,agendaWeek,month',
                    left: 'prev,next today'
                },
                editable: false,
                firstDay: 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
                selectable: false,
                defaultView: 'agendaWeek',
                axisFormat: 'h:mm',
                columnFormat: {
                    month: 'ddd',    // Mon
                    week: 'ddd d', // Mon 7
                    day: 'dddd M/d',  // Monday 9/7
                    agendaDay: 'dddd d'
                },
                titleFormat: {
                    month: 'MMMM yyyy', // September 2009
                    week: "MMMM yyyy", // September 2009
                    day: 'MMMM yyyy'                  // Tuesday, Sep 8, 2009
                },
                navLinks: true,
                eventLimit: true,
                allDaySlot: false,
                droppable: false, // this allows things to be dropped onto the calendar !!!
                events: eventsArr,
            });
        }

        $.ajax({
            url : 'times?criteria=all',
            dataType : 'xml',
            type : 'GET',
            success : function(doc) {
                var eventsArr = [];
                if ($(doc).find('lecture').length > 0) {
                    $(doc).find('lecture').each(
                        function() {
                            eventsArr
                                .push({
                                    id : $(this).find('id').html(),
                                    title : $(this).find('titre')
                                        .html() + '\n' + $(this).find('ens').html(),
                                    start : $(this).find('debut')
                                        .html(),
                                    end : $(this).find('fin')
                                        .html(),
                                    allDay : false,
                                    className : 'important'
                                });
                        });
                }
                initialize(eventsArr);
            }
        });
    });
</script>
</html>

