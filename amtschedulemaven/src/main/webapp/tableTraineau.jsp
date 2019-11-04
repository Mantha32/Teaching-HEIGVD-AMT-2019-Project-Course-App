<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Traineau"%>

<div class="table-responsive">
	<table class="table table-bordered table-hover table-dark"
		id="dataTable">
		<thead>
			<tr>
				<th class="text-center">Num</th>
				<th class="text-center">Jour</th>
				<th class="text-center">Debut</th>
				<th class="text-center">Fin</th>
				<th class="text-center">Action</th>
			</tr>
		</thead>

		<tbody>
			<%
						@SuppressWarnings("unchecked")
									List<Traineau> traineaux = (List<Traineau>)request.getAttribute("traineaux");
									for(Traineau traineau : traineaux){
					%>
			<tr class="note">
				<td class="code text-center"><%= traineau.getNumero() %></td>
				<td class="text-center"><%= traineau.getJour() %></td>
				<td class="text-center"><%= traineau.getDebut() %></td>
				<td class="text-center"><%= traineau.getFin() %></td>
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

<script>
	$(function() {
		var tab = [];
		var t = $('#dataTable').DataTable({
			columns : [ {
				title : 'Numero'
			}, {
				title : 'Jour'
			}, {
				title : 'Debut'
			}, {
				title : 'Fin'
			}, {
				title : 'Action'
			} ],
			info : false,
			lengthChange : false,
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
		});

		function supprimer(numero) {
			params = {
				opt : "supprimer",
				num : numero
			};
			ver = confirm('Voulez vous vraiment supprimer le ' + numero);
			if (ver) {
				$.post('traineaux', params, function(data) {
					alert(data);
					window.location.reload(true);
				});
			}
		}

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
