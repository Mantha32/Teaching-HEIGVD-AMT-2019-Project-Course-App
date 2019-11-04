<%-- 
    Document   : crenau
    Created on : 18 juil. 2019, 16:18:52
    Author     : doriane kaffo
--%>

<%@page import="com.amt.schedule.entities.Type"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Type type = (Type) session.getAttribute("type");
	if (type.getStatut().compareTo("Enseignant") != 0) {
		response.sendRedirect("404.jsp");
	}
%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Crenaux</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

<link href='assets/css/fullcalendar.css' rel='stylesheet' />
<link href='assets/css/fullcalendar.print.css' rel='stylesheet'
	media='print' />

<script src="vendor/jquery/jquery.min.js"></script>
<script src='assets/js/jquery-ui.custom.min.js' type="text/javascript"></script>
<script src='assets/js/fullcalendar.js' type="text/javascript"></script>

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

#calendar { /*    float: right; */
	margin: 0 auto;
	width: 900px;
	background-color: #FFFFFF;
	border-radius: 6px;
	box-shadow: 0 1px 2px #C3C3C3;
}

#traineau { /*    float: left; */
	margin: 0 auto;
	width: 600px;
	background-color: #FFFFFF;
	border-radius: 6px;
	box-shadow: 0 1px 2px #C3C3C3;
}
</style>
</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="index.html">Start Bootstrap</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<ul class="navbar-nav ml-auto no-arrow mx-1">
			<li><a href="#" class="btn btn-link btn-primary text-white"
				style="margin-right: 20px; width: 150px; visibility: hidden">Enseignant</a>
			</li>
			<li><a href="blank - Etudiant.html"
				class="btn btn-link btn-primary text-white"
				style="margin-right: 20px; margin-left: 20px; width: 150px; visibility: hidden">Etudiant</a>
			</li>
			<li><a href="blank - Salle.html"
				class="btn btn-link btn-primary text-white"
				style="margin-right: 20px; margin-left: 20px; width: 150px; visibility: hidden">Salle</a>
			</li>
			<li><a href="blank - Niveau.html"
				class="btn btn-link btn-primary text-white"
				style="margin-right: 20px; width: 150px; visibility: hidden">Niveau</a>
			</li>
			<li><a href="eventModif.html"
				class="btn btn-link btn-primary text-white"
				style="margin-right: 20px; width: 150px; visibility: hidden">Evenements</a>
			</li>
		</ul>


		<!-- Navbar Search -->
		<form
			class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0"
			style="visibility: hidden">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..."
					aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">

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



	<div class="col-md-12">
		<div class="row">
			<div class="col-md-12">

				<div id="wrapper">

					<!-- Sidebar -->
					<ul class="sidebar navbar-nav">
						<li class="nav-item"><a class="nav-link" href="index_.jsp">
								<i class="fas fa-fw fa-tachometer-alt"></i> <span>Accueil</span>
						</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="crenau.jsp"> <i class="fas fa-fw fa-edit"></i><span>Mes
									Crénaux</span></a></li>
						<li class="nav-item"><a class="nav-link" href="charts.html">
								<i class="fas fa-fw fa-chart-area"></i> <span>Mes
									Statistiques</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="evenement.jsp">
								<i class="fas fa-fw fa-table"></i><span>Mes Evenements</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="evenement.jsp">
								<i class="fas fa-fw fa-table"></i><span>Mes Rapports</span>
						</a></li>
					</ul>

					<div id="content-wrapper">

						<div class="container-fluid">

							<!-- Page Content -->
							<h1>Crénau</h1>
							<hr>

							<!-- Calendar-->
							<div class="card mb-12">
								<div class="card-header">
									<i class="fas fa-fw fa-table"></i> Choisissez vos Crénaux de
									disponibilité
								</div>
							</div>

							<div class="card-body">
								<div id="traineau" class="col float-left border"
									style="clear: both"></div>
								<div id="calendar" class="col float-right border">
									<div style='clear: both'></div>
								</div>

							</div>

							<input id="userId" type="hidden" value="${matricule}">
							<!-- /.container-fluid -->

							<!-- Sticky Footer -->
							<footer class="sticky-footer"
								style="position: relative; left: 20px; width: 100%;">
								<div class="container my-auto">
									<div class="copyright text-center my-auto">
										<span>Copyright © TP-ICT308 2019</span>
									</div>
								</div>
							</footer>

						</div>
						<!-- /.content-wrapper -->

					</div>
					<!-- /#wrapper -->
				</div>
			</div>
		</div>



	</div>
	<!-- end of div.col-md-12 -->
	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>

</body>

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

<!-- /#wrapper -->
<script type="text/javascript">
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

			var calendar = $('#calendar')
					.fullCalendar(
							{
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
									var title = confirm('Voulez-vous valider cette plage horraire ?');
									var id = -1;
									if (!title) {
									} else {
										$
												.post(
														'traineaux',
														{
															opt : 'ajouter',
															matricule : $(
																	'#userId')
																	.val(),
															jour : start
																	.toDateString()
																	.substr(0,
																			3),
															debut : start,
															fin : end
														},
														function(data) {
															if (data == "Aucune plage libre trouve!!!") {
																alert(data);
																calendar
																		.fullCalendar('unselect');
															}
															window.location
																	.reload(true);
														});
									}
									calendar.fullCalendar('unselect');
								},
								droppable : true, // this allows things to be dropped onto the calendar !!!
								drop : function(date, allDay) { // this function is called when something is dropped

									// retrieve the dropped element's stored Event Object
									var originalEventObject = $(this).data(
											'eventObject');

									// we need to copy it, so that multiple events don't have a reference to the same object
									var copiedEventObject = $.extend({},
											originalEventObject);

									// assign it the date that was reported
									copiedEventObject.start = date;
									copiedEventObject.allDay = allDay;

									// render the event on the calendar
									// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
									$('#calendar').fullCalendar('renderEvent',
											copiedEventObject, true);

									// is the "remove after drop" checkbox checked?
									if ($('#drop-remove').is(':checked')) {
										// if so, remove the element from the "Draggable Events" list
										$(this).remove();
									}
								},
								events : eventsArr,
							});
		}
		$.ajax({
			url : 'traineaux?matricule=' + $('#userId').val(),
			dataType : 'xml',
			type : 'GET',
			success : function(doc) {
				var eventsArr = [];
				$(doc).find('traineau').each(function() {
					eventsArr.push({
						id : $(this).find('id').html(),
						start : $(this).find('debut').html(),
						end : $(this).find('fin').html(),
						allDay : false,
						className : 'info'
					});
				});
				initialize(eventsArr);
			}
		});

		$.get('ressources?page=tableTraineau.jsp&matricule='
				+ $('#userId').val(), function(data) {
			$('#traineau').html(data);
		});

	});
</script>
</html>
