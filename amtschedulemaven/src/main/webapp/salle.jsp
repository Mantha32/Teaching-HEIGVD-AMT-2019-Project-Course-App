<%-- 
    Document   : blank - Salle
    Created on : 18 juil. 2019, 16:17:43
    Author     : doriane kaffo
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Salle</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">

<!-- Page level plugin CSS-->
<link href="vendor/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin.css" rel="stylesheet">

</head>

<body id="page-top">

	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

		<a class="navbar-brand mr-1" href="index1.html">Acceuil</a>

		<button class="btn btn-link btn-sm text-white order-1 order-sm-0"
			id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>
		<ul class="navbar-nav ml-auto no-arrow mx-1">
			<li><a href="blank.html"
				class="btn btn-link btn-primary text-white"
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
				style="margin-right: 20px; width: 150px; visibility: hidden;">Niveau</a>
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
			<div class="col-md-9">

				<div id="wrapper">

					<!-- Sidebar -->
					<ul class="sidebar navbar-nav">
						<li class="nav-item"><a class="nav-link" href="index.jsp">
								<i class="fas fa-fw fa-tachometer-alt"></i> <span>Tableau
									de Bord</span>
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

					<!--  provided space for table -->
					<div id="content-wrapper">Chargement...</div>
					<!-- /.content-wrapper -->

				</div>
				<!-- /#wrapper -->
			</div>
			<div class="col-md-3">

				<div class="container">
					<div class="card card-register mx-auto mt-5" id="salle1">
						<div class="card-header">
							<h4>Modifier Salle</h4>
						</div>
						<div class="card-body">
							<div>
								<!-- Material input -->

								<div class="md-form form-group">
									<label for="nom" style="font-weight: bold;">Nom</label> <input
										type="text" class="form-control" id="nomM"
										placeholder="Nom de la salle" disabled="disabled"> <label
										for="contenance" style="font-weight: bold;">Contenance</label>
									<input type="text" class="form-control" id="contenanceM"
										placeholder="Contenance">

									<!--p>
                         <label for="message"> <b> Remarque </b></label>
                          <textarea name="message" id="materialize-textarea" cols="30" rows="3"></textarea>
                </p-->
								</div>
								<div class="form-row">
									<button id="modifier"
										class="btn btn-primary badge-pill col-md-6 "
										style="height: 40px; margin-right: 20px;">Save</button>
									<button id="cancelM"
										class="btn btn-danger badge-pill col-md-4 float-right">Cancel</button>
								</div>
							</div>
						</div>

					</div>
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

<!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.get('ressources?page=tableSalle.jsp', function(data) {
			$('#content-wrapper').html(data);
		});
	});
</script>

</html>

