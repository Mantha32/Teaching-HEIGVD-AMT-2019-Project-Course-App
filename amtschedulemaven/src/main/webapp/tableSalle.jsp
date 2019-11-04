<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Salle"%>
<div class="container-fluid">
	<!-- Page Content -->
	<div class="card mb-3">
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover table-dark"
					id="dataTable">
					<thead>
						<tr>
							<th class="text-center">Nom</th>
							<th class="text-center">Capacit�</th>
							<th class="text-center">Action</th>
						</tr>
					</thead>

					<tbody>
						<%
						@SuppressWarnings("unchecked")
									List<Salle> salles = (List<Salle>)request.getAttribute("salles");
									for(Salle salle : salles){
					%>
						<tr class="note">
							<td class="code text-center"><%= salle.getCode() %></td>
							<td class="text-center"><%= salle.getContenance() %></td>
							<td class="text-center">
								<button class="btn btn-danger badge-pill delete">
									<i class="fas fa-fw fa-trash"></i>
								</button>
							</td>
						</tr>
						<%
						}
						%>
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
				<h4 class="modal-title w-100 font-weight-bold">Nouvelle Salle</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>

			<div>
				<div>
					<div class="modal-body mx-3">
						<div class="md-form mb-5">
							<i class="fas fa-user prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="nom">Nom</label> <input
								type="text" id="nomC" class="form-control validate"
								placeholder="Nom Salle">
						</div>

						<div class="md-form mb-5">
							<i class="fas fa-weight prefix grey-text"></i> <label
								data-error="wrong" data-success="right" for="contenance">Contenance</label>
							<input type="number" id="contenanceC"
								class="form-control validate" placeholder="Contenance">
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
		</div>
	</div>
</div>

<!-- Sticky Footer -->
<footer class="sticky-footer"
	style="position: relative; left: 20px; width: 100%;">
	<div class="container my-auto">
		<div class="copyright text-center my-auto">
			<span>Copyright � TP-ICT308 2019</span>
		</div>
	</div>
</footer>
<script>
	$(function() { //Initialize Select2 Elements $('.select2').select2();
		$('[data-mask]').inputmask();
		var tab = [];
		var t = $('#dataTable').DataTable({
			columns : [ {
				title : 'Code'
			}, {
				title : 'Contenance'
			}, {
				title : 'Action'
			} ],
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
			form(tab);
		});

		function form(tab) {
			$('#nomM').val(tab[1]);
			$('#contenanceM').val(tab[2]);
		}

		function populate_salles() {
			$.get('ressources?page=tableSalle.jsp', function(data) {
				$('#content-wrapper').html(data);
			});
		}

		function ajouter() {
			var code = $('#nomC').val();
			var contenance = $('#contenanceC').val();
			params = {
				opt : "ajouter",
				code : code,
				contenance : contenance
			};

			$.post('salles', params, function(data) {
				alert(data);
				populate_salles();
			});
		}

		function modifier() {
			var code = $('#nomM').val();
			var contenance = $('#contenanceM').val();

			var rev = confirm("Voulez vous enregistrer les modifications de: "
					+ code + " ?");
			if (rev) {
				var params = {
					opt : "modifier",
					code : code,
					contenance : contenance
				};
				$.post('salles', params, function(data) {
					alert(data);
					if (data == "succes")
						populate_salles();
				});
				$('#salle1 input').val('');
			}
		}

		function supprimer(code) {
			params = {
				opt : "supprimer",
				code : code
			};
			ver = confirm('Voulez vous vraiment supprimer la salle ' + code);
			if (ver) {
				$.post('salles', params, function(data) {
					alert(data);
					if (data == 'succes')
						populate_salles();
				});
			}
			$('#salle1 input').val('');
		}

		$('#ajouter').on('click', ajouter);
		$('#modifier').on('click', modifier);
		$('#cancelM').on('click', function() {
			$('#salle1 input').val('');
		});
		$('#dataTable tbody').on('click', '.delete', function() {
			if ($(this).parent().parent().hasClass('selected')) {
				$(this).parent().parent().removeClass('selected');
			} else {
				t.$('tr.selected').removeClass('selected');
				$(this).parent().parent().addClass('selected');
			}

			var texte = $('.selected').text();
			tab = texte.replace(/\t/g, '').split('\n');
			supprimer(tab[1]);
		});
	});
</script>
