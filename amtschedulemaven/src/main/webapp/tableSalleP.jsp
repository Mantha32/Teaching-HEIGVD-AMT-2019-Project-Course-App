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
			populate_calendar();
		});

		function populate_calendar() {
			$('#calendar')
					.replaceWith(
							'<div id="calendar" class="col-md-9 float-right border"><div style="clear: both"></div>');
			$.ajax({
				url : 'cours?criteria=salle&key=' + tab[1],
				dataType : 'xml',
				type : 'GET',
				success : function(doc) {
					var eventsArr = [];
					if ($(doc).find('ue').length > 0) {
						$(doc).find('ue').each(
								function() {
									eventsArr.push({
										id : $(this).find('id').html(),
										title : $(this).find('ens').html()
												+ '\n'
												+ $(this).find('code').html()
												+ '\n'
												+ $(this).find('salle').html(),
										start : $(this).find('debut').html(),
										end : $(this).find('fin').html(),
										allDay : false,
										className : 'important'
									});
								});
					}
					initialize(eventsArr);
				}
			});
		}
	});
</script>
