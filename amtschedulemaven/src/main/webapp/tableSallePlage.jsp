<%@page import="java.util.List"%>
<%@page import="com.amt.schedule.entities.Salle"%>

<div class="table-responsive">
	<table class="table table-bordered table-hover table-dark"
		id="dataTable">
		<thead>
			<tr>
				<th class="text-center">Nom</th>
				<th class="text-center">Capacit�</th>
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
				title : 'Code'
			}, {
				title : 'Contenance'
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
			populate_calendar(tab[1]);
		});

		function populate_calendar(salle) {
			$('#calendar')
					.replaceWith(
							'<div id="calendar" class="col-md-9 float-right border"><div style="clear: both"></div>');
			$.ajax({
				url : 'plages?salle=' + salle,
				dataType : 'xml',
				type : 'GET',
				success : function(doc) {
					var eventsArr = [];
					if ($(doc).find('plage').length > 0) {
						$(doc).find('plage').each(function() {
							eventsArr.push({
								id : $(this).find('id').html(),
								title : false,
								start : $(this).find('debut').html(),
								end : $(this).find('fin').html(),
								allDay : false,
								className : 'info'
							});
						});
					}
					initialize(eventsArr, salle);
				}
			});
		}

		populate_calendar(t.data()[0][0]);
	});
</script>
