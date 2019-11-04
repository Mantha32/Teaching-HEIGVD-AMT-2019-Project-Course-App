<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Evenement"%>
<%@page import="com.amt.schedule.entities.Niveau"%>
<div class="container-fluid">
	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="index1Enseignant.html">Tableau
				de Bord</a></li>
		<li class="breadcrumb-item active">Gestion des Evenements</li>

	</ol>

	<!-- Page Content -->
	<h1>Parametres</h1>
	<hr>


	<!-- Area Chart Example-->

	<div class="card mb-6">
		<div class="card-header">
			<h5>
				<i class="fas fa-table"></i> Evenements
				<button type="button" class="btn btn-primary badge-pill float-right"
					data-toggle="modal" data-target="#modalContactForm">
					<i class="fas fa-fw fa-plus"></i>
				</button>
		</div>
		</h5>
		<div></div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-dark"
					id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th class="text-center sorting">Coordonateur</th>
							<th class="text-center">Titre</th>
							<th class="text-center">Effectif</th>
							<th class="text-center">Heure debut</th>
							<th class="text-center">Heure fin</th>
							<th class="text-center">Niveau</th>
							<th class="text-center">Description</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>
</div>
<!-- /.container-fluid -->

<!--Formulaire d'ajout -->

<div class="modal fade" id="modalContactForm" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<h4 class="modal-title w-100 font-weight-bold">Nouvel Evenement</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div>
				<div class="modal-body mx-3">

					<div class="md-form mb-5">
						<i class="fas fa-tag prefix grey-text"></i> <label
							data-error="wrong" data-success="right" for="form8">Titre</label>
						<input type="text" id="titre" class="form-control validate"
							placeholder="Titre">
					</div>
					<div class="md-form mb-5">
						<i class="fas fa-flag prefix grey-text"></i> <label
							data-error="wrong" data-success="right" for="form8">Effectif</label>
						<input type="text" id="contenance" class="form-control validate"
							placeholder="Effectif">
					</div>

					<div class="md-form mb-5">
						<i class="fas fa-clock"></i> <label data-error="wrong"
							data-success="right" for="form8">Heure Debut</label> <input
							type="datetime-local" id="debut" class="form-control validate"
							placeholder="Heure de Debut">
					</div>

					<div class="md-form mb-5">
						<i class="fas fa-clock"></i> <label data-error="wrong"
							data-success="right" for="form8">Heure Fin</label> <input
							type="datetime-local" id="fin" class="form-control validate"
							placeholder="Heure de Fin">
					</div>

					<div class="md-form mb-5">
						<i class="fas fa-clock"></i> <label data-error="wrong"
							data-success="right" for="form8">Niveau concern�</label><select
							id="niveau" class="form-control validate">
							<% 
							@SuppressWarnings("unchecked")
							List<Niveau> niveaux = (List<Niveau>)request.getAttribute("niveaux");
								for(Niveau niveau : niveaux){
									%>
							<option value="<%=niveau.getNiveau()%>"><%=niveau.getNiveau()%></option>
							<%
								}
							%>
						</select>
					</div>

					<div class="md-form">
						<i class="fas fa-pencil prefix grey-text"></i>
						<textarea id="description" class="md-textarea form-control"
							rows="4" placeholder="Description"></textarea>
					</div>
				</div>
			</div>

			<div class="modal-footer d-flex justify-content-center">
				<button id="ajouter" class="btn btn-success" data-dismiss="modal">
					Enregistrer <i class="fas fa-paper-plane-o ml-1"></i>
				</button>
				<button class="btn btn-danger" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>


<!-- Sticky Footer -->
<footer class="sticky-footer"
	style="position: relative; top: 20px; left: 15px; width: 100%;">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright � TP-ICT308 2019</span>
		</div>
	</div>
</footer>
<script>
	$(function() {
		$('[data-mask]').inputmask();
		var tab = [];
		var t = $('#dataTable').DataTable({
			columns : [ {
				title : 'Coordonateur'
			}, {
				title : 'Titre'
			}, {
				title : 'Effectif'
			}, {
				title : 'Heure debut'
			}, {
				title : 'Heure fin'
			}, {
				title : 'Niveau'
			}, {
				title : 'Description'
			}, {
				title : 'Action'
			} ],
			scrollY : 400,
			scrollCollapse : true,
			paging : false,
		});

		function populate_evenements() {
			$.get('ressources?page=tableEvenement.jsp&matricule='
					+ $('#userId').val(), function(data) {
				$('#content-wrapper').html(data);
			});
		}

		function ajouter() {
			var titre = $('#titre').val();
			var contenance = $('#contenance').val();
			var debut = $('#debut').val();
			var fin = $('#fin').val();
			var description = $('#description').val();
			var niveau = $('#niveau').val();

			params = {
				opt : "ajouter",
				matricule : $('#userId').val(),
				titre : titre,
				contenance : contenance,
				jour : new Date(debut).toUTCString().substr(0, 3),
				debut : new Date(debut),
				fin : new Date(fin),
				niveau : niveau,
				description : description
			};

			$.post('evenements', params, function(data) {
				alert(data);
				populate_evenements();
			});
		}

		function supprimer(code, debut, fin, concerne) {
			params = {
				opt : "supprimer",
				code : code
			};
			ver = confirm('Voulez vous vraiment supprimer cet evenemnt?');
			if (ver) {
				$.post('evenements', params, function(data) {
					alert(data);
					if (data == 'succes')
						populate_evenements();
				});
			}
		}

		$('#ajouter').on('click', ajouter);
		$('#dataTable tbody').on('click', '.delete', function() {
			if ($(this).parent().parent().hasClass('selected')) {
				$(this).parent().parent().removeClass('selected');
			} else {
				t.$('tr.selected').removeClass('selected');
				$(this).parent().parent().addClass('selected');
			}

			var texte = $('.selected').text();
			tab = texte.replace(/\t/g, '').split('\n');
		});
	});
</script>
