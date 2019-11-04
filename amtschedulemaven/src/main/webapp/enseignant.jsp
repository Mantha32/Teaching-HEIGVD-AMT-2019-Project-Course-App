<%--
    Document   : index
    Created on : 18 juil. 2019, 15:49:09
    Author     : doriane kaffo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
          type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

    <link rel="stylesheet" href="css/sb-style.css">

    <!-- librairies pour le calendrier -->
    <link href='assets/css/fullcalendar.css' rel='stylesheet' />
    <link href='assets/css/fullcalendar.print.css' rel='stylesheet'
          media='print' />

    <script src="vendor/jquery/jquery.min.js"></script>
    <script src='assets/js/jquery-ui.custom.min.js' type="text/javascript"></script>
    <script src='assets/js/fullcalendar.js' type="text/javascript"></script>

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
            margin: 10px auto;
            align-self: center;
            background-color: #FFFFFF;
            border-radius: 6px;
            box-shadow: 0 1px 2px #C3C3C3;
        }
    </style>
</head>

<body id="page-top">

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

    <a class="navbar-brand mr-1" href="index.jsp">Acceuil</a>

    <button class="btn btn-link btn-sm text-white order-1 order-sm-0"
            id="sidebarToggle" href="#">
        <i class="fas fa-bars"></i>
    </button>

    <!-- Navbar -->
    <ul class="right d-ld-block navbar-nav ml-auto ml-md-0">
        <li class="nav-item dropdown no-arrow mx-1"><a
                class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
                role="button" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span
                class="badge badge-danger">9+</span>
        </a>
            <div class="dropdown-menu dropdown-menu-right"
                 aria-labelledby="alertsDropdown">
                <a class="dropdown-item" href="#">Action</a> <a
                    class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
            </div></li>
        <li class="nav-item dropdown no-arrow mx-1"><a
                class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
                role="button" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span
                class="badge badge-danger">7</span>
        </a>
            <div class="dropdown-menu dropdown-menu-right"
                 aria-labelledby="messagesDropdown">
                <a class="dropdown-item" href="#">Action</a> <a
                    class="dropdown-item" href="#">Another action</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Something else here</a>
            </div></li>
        <li class="nav-item dropdown no-arrow"><a
                class="nav-link dropdown-toggle" href="#" id="userDropdown"
                role="button" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
        </a>
            <div class="dropdown-menu dropdown-menu-right"
                 aria-labelledby="userDropdown">
                <a class="dropdown-item" href="#">Settings</a> <a
                    class="dropdown-item" href="#">Activity Log</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#" data-toggle="modal"
                   data-target="#logoutModal">Logout</a>
            </div></li>
    </ul>

</nav>

<div class="row">
    <div class="col-md-12">

        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item active"><a class="nav-link"
                                               href="index.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Tableau de Bord</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="charts.html">
                    <i class="fas fa-fw fa-chart-area"></i> <span>Statistiques</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="enseignant.jsp">
                    <i class="fas fa-fw fa-users"></i> <span>Enseignants</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="salle.jsp">
                    <i class="fas fa-fw fa-flag"></i> <span>Gerer les salles</span>
                </a></li>
                <li class="nav-item"><a class="nav-link" href="plage.jsp">
                    <i class="fas fa-fw fa-flag"></i> <span>Gerer les plages</span>
                </a></li>
            </ul>

            <div id="content-wrapper">

                <div class="container-fluid">
                    <!-- Calendar-->
                    <div class="card mb-6">
                        <div class="card-header">
                            <i class="fas fa-fw fa-table"></i> Emploie de Temps
                            <button type="button" class="btn btn-primary float-right"
                                    id="imprimer">
                                <i class="fas fa-fw fa-print"></i>Imprimer
                            </button>
                        </div>
                    </div>

                    <div class="card-body">
                        <div class="sparkline13-graph">
                            <div class="datatable-dashv1-list custom-datatable-overright">
                                <button type="button" class="btn btn-custon-four btn-primary" data-toggle="modal"
                                        data-target="#myModal" style="background-color: rgb(0, 111, 186)">
                                    <i class="fa fa-plus adminpro-informatio" aria-hidden="true"></i>
                                </button>
                                <div class="modal fade" id="myModal">
                                    <div
                                            class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header" style="background-color: rgb(0, 111, 186)">
                                                <h4 class="modal-title" style="font-size: 20px; color: white">
                                                    Nouvel Enseignant</h4>
                                                <button class="close" data-dismiss="modal"
                                                        style="color: white; margin-top: -25px">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <div>
                                                    <label for="">Matricule</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-user"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="text" id="mat"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Email</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-envelope"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="email" id="email"
                                                               class="form-control pro-edt-select form-control-primary input-lg"
                                                               placeholder="example@gmail.com">
                                                    </div>
                                                    <label for="">Nom</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-user"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="text" id="nom"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Sexe</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-bookmark"
                                                                                               aria-hidden="true"></i></span>
                                                        Homme: <input type="radio" name="sexe" value="1" class="form-control pro-edt-select form-control-primary input-lg">
                                                        &nbsp;&nbsp;Femme: <input type="radio" name="sexe" value="0" class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Grade</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-level-up-alt"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="text" id="grade"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Password</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-passport"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="password" id="pass"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Re password</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-passport"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="password" id="rpass"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <button id="create" type="button"
                                                            class="btn btn-custon-four btn-primary" data-dismiss="modal"
                                                            style="background-color: rgb(0, 111, 186); width: 100%;">
                                                        <i class="fa fa-check adminpro-informatio"
                                                           aria-hidden="true"></i>
                                                        Valider</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal fade" id="myModalUpdate">
                                    <div
                                            class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header" style="background-color: rgb(0, 111, 186)">
                                                <h4 class="modal-title" style="font-size: 20px; color: white">
                                                    Modifier Enseignant</h4>
                                                <button class="close" data-dismiss="modal"
                                                        style="color: white; margin-top: -25px">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <div>
                                                    <label for="">Matricule</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-user"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="text" id="matU"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Email</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-envelope"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="email" id="emailU"
                                                               class="form-control pro-edt-select form-control-primary input-lg"
                                                               placeholder="example@gmail.com">
                                                    </div>
                                                    <label for="">Nom</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-user"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="text" id="nomU"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Sexe</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-bookmark"
                                                                                               aria-hidden="true"></i></span>
                                                        Homme: <input type="radio" value="1" class="form-control pro-edt-select form-control-primary input-lg">
                                                        &nbsp;&nbsp;Femme: <input type="radio" value="0" class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <label for="">Grade</label>
                                                    <div class="input-group mg-b-pro-edt">
                                                            <span class="input-group-addon"><i class="fa fa-level-up-alt"
                                                                                               aria-hidden="true"></i></span>
                                                        <input type="text" id="gradeU"
                                                               class="form-control pro-edt-select form-control-primary input-lg">
                                                    </div>
                                                    <button id="update" type="button"
                                                            class="btn btn-custon-four btn-primary" data-dismiss="modal"
                                                            style="background-color: rgb(0, 111, 186); width: 100%;">
                                                        <i class="fa fa-check adminpro-informatio"
                                                           aria-hidden="true"></i>
                                                        Valider</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div id="myModalDelete" class="modal fade">
                                    <input type="hidden" id="delete_id">
                                    <div class="modal-dialog modal-confirm">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <div class="icon-box">
                                                    <i class="material-icons">&#xE5CD;</i>
                                                </div>
                                                <h4 class="modal-title">Are you sure?</h4>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">&times;</button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Do you really want to delete these records? This process cannot
                                                    be
                                                    undone.</p>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-info"
                                                        data-dismiss="modal">Cancel</button>
                                                <button id="delete" data-dismiss="modal" type="button"
                                                        class="btn btn-danger">Delete</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="owner" class="table-responsive"
                                     style="border: 1px solid gray;"></div>
                                <div id="calendar" class="border">
                                    <div style="clear: both"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Sticky Footer -->
                    <footer class="sticky-footer"
                            style="position: relative; width: 100%;">
                        <div class="container my-auto">
                            <div class="copyright text-center my-auto">
                                <span>Copyright © Your Website 2019</span>
                            </div>
                        </div>
                    </footer>
                </div>
                <!-- /.content-wrapper -->

                <!-- Scroll to Top Button-->
                <a class="scroll-to-top rounded" href="#page-top"> <i
                        class="fas fa-angle-up"></i>
                </a>

                <!-- Logout Modal-->
                <div class="modal fade" id="logoutModal" tabindex="-1"
                     role="dialog" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Ready to
                                    Leave?</h5>
                                <button class="close" type="button" data-dismiss="modal"
                                        aria-label="Close">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">Select "Logout" below if you are
                                ready to end your current session.</div>
                            <div class="modal-footer">
                                <button class="btn btn-secondary right-align" type="button"
                                        data-dismiss="modal">Cancel</button>
                                <a class="btn btn-primary" href="login.jsp">Logout</a>
                            </div>
                        </div>
                    </div>
                </div>
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
<script type="text/javascript">
    $(function() {
        $.get('utilisateurs', function(data) {
            $('#owner').html(data);
        });
        $('#create').on('click', function () {
            if($('#pass').val() === $('#rpass').val()) {
                $.post('utilisateurs', {
                    mat: $('#mat').val(),
                    email: $('#email').val(),
                    nom: $('#nom').val(),
                    sexe: $('[name="sexe"]').val(),
                    type: 'Enseignant',
                    pass: $('#pass').val()
                }, function (data) {
                    window.location.reload(true);
                });
            }
        });
    });
</script>
</html>

