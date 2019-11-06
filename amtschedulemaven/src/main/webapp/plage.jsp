<%-- 
    Document   : index1
    Created on : 18 juil. 2019, 15:49:09
    Author     : doriane kaffo
--%>

<%@page import="com.amt.schedule.model.Type"%>
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
	function initialize(eventsArr, salle) {

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
			editable : true,
			firstDay : 1, //  1(Monday) this can be changed to 0(Sunday) for the USA system
			selectable : true,
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
			select : function(start, end, allDay) {
				var ver = confirm('Voulez vous enregistrer cette plage');
				if (ver) {
					$.post('plages', {
						opt : 'ajouter',
						salle : salle,
						jour : start.toDateString().substr(0, 3),
						debut : start,
						fin : end
					}, function(data) {
						alert(data);
						window.location.reload(true);
					});
				} else
					calendar.fullCalendar('unselect');
			},
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
					<li class="nav-item"><a class="nav-link" href="enseignant.jsp">
							<i class="fas fa-fw fa-users"></i> <span>Enseignants</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="charts.html">
							<i class="fas fa-fw fa-chart-area"></i> <span>Statistiques</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="evenement.jsp">
						<i class="fas fa-fw fa-table"></i> <span>Evenements</span>
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
								<i class="fas fa-fw fa-table"></i> Plages des salles
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

						<div class="card-footer small text-muted">Updated yesterday
							at 11:59 PM</div>

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
		$.get('ressources?page=tableSallePlage.jsp', function(data) {
			$('#owner').html(data);
		});
	});
</script>

</html>

