<%-- 
    Document   : index
    Created on : 18 juil. 2019, 15:49:09
    Author     : doriane kaffo
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="matricule" value="${sessionScope.matricule}" scope="session"/>
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

				<!-- Sidebar -->
				<ul class="sidebar navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="admin.jsp"> <i class="fas fa-fw fa-tachometer-alt"></i>
							<span>Tableau de Bord</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="users?role=Enseignant">
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

					<div class="container-fluid">

						<!-- Icon Cards-->
						<div class="row">
							<div class="col-xl-3 col-sm-6 mb-3">
								<div
									class="card text-white bg-primary o-hidden h-100 enseignant">
									<div class="card-body">
										<div class="card-body-icon">
											<i class="fas fa-fw fa-user-circle"></i>
										</div>
										<div class="mr-5">Enseignants</div>
									</div>
									<span id="btnEnseignant"
										class="card-footer text-white clearfix small z-1"> <span
										class="float-left"> consulter </span> <span
										class="float-right"> <i class="fas fa-angle-right"></i>

									</span>
									</span>


								</div>
							</div>
							<div class="col-xl-3 col-sm-6 mb-3">
								<div class="card text-white bg-warning o-hidden h-100 salle">
									<div class="card-body">
										<div class="card-body-icon">
											<i class="fas fa-fw fa-university"></i>
										</div>
										<div class="mr-5">Classroom</div>
									</div>
									<span id="btnSalle"
										class="card-footer text-white clearfix small z-1"> <span
										class="float-left"> consulter </span> <span
										class="float-right"> <i class="fas fa-angle-right"></i>
									</span>
									</span>
								</div>
							</div>
						</div>


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
							<div class="form-row">
								<div id="owner" class="table-responsive col-md-3 float-left"
									style="border: 1px solid gray;"></div>
								<div id="calendar" class="col-md-9 float-right border">
									<div style="clear: both"></div>
								</div>
							</div>

						</div>

					</div>

					<%@ include file="footer.jsp" %>
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
<script type="text/javascript">
	$(function() {

		function populate_owner(page) {
			$.get('ressources?page=' + page, function(data) {
				$('#owner').html(data);
			});
		}

		populate_owner('/user/tableUser.jsp');

		$('#btnEnseignant').on('click', function() {
			populate_owner('/user/tableUser.jsp');
		});
		$('#btnSalle').on('click', function() {
            populate_owner('/classroom/tableClassroom.jsp');
		});
	});
</script>

</html>

